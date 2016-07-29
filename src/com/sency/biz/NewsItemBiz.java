package com.sency.biz;

import java.net.DatagramPacket;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sency.bean.CommonException;
import com.sency.bean.NewsItem;
import com.sency.csdn.DataUtil;
import com.sency.csdn.URLUtil;

/**
 * 1.每一个新闻是以关键字"unit"来标识的,10个新闻就有10个"unit" 2.新闻标题是以<h1>标识的
 * 
 * @author sency newsList是newsItem的集合,newsItem又包含很多个成员
 */
// 使用Jsoup解析HTML数据,并放入item中，封装返回Item
public class NewsItemBiz {
	public List<NewsItem> getItem(int newsType, int currentPage) throws CommonException {
		String urlStr = URLUtil.getUrl(newsType, currentPage);
		String htmlStr = DataUtil.getDate(urlStr);
		List<NewsItem> newsLists = new ArrayList<NewsItem>();
		NewsItem newsItem = null;
		// Jsoup解析HTML数据
		Document doc = Jsoup.parse(htmlStr);
		/**
		 * 每一个新闻是以关键字"unit"来标识的,10个新闻就有10个"unit" 打开链接，ctrl+u可以看源码
		 */
		// 下面这个步骤是得到一个页面上所有新闻item的集合
		Elements utils = doc.getElementsByClass("unit");
		for (int i = 0; i < utils.size(); i++) {
			newsItem = new NewsItem();
			newsItem.setNewsType(newsType);
			// 得到第一个新闻
			Element unit_ele = utils.get(i);

			/** 新闻标题是以<h1>标识的 */
			// 得到第一个新闻的标题,这里get(0)是因为h1的标签只有一个
			Element h1_ele = unit_ele.getElementsByTag("h1").get(0);
			/** 获取标题和链接,格式:<a href="链接">文章标题</a> */
			// 得到整体,即标签里标识的东西
			Element h1_a_ele = h1_ele.child(0);
			// 获取标题
			String title = h1_a_ele.text();
			// 获取链接
			String href = h1_a_ele.attr("href");
			// 设置标题和链接
			newsItem.setTitle(title);
			newsItem.setLink(href);

			// 通过h4的tag找日期
			Element h4_ele = unit_ele.getElementsByTag("h4").get(0);
			Element ago_ele = h4_ele.getElementsByClass("ago").get(0);
			String date = ago_ele.text();
			// 设置时间
			newsItem.setDate(date);

			// 得到图片和内容整体
			Element dl_ele = unit_ele.getElementsByTag("dl").get(0);
			// 图片
			Element dt_ele = dl_ele.child(0);// dt
			try {
				// 可能没有图片
				Element img_ele = dt_ele.child(0);
				String imgLink = img_ele.child(0).attr("src");
				newsItem.setImgLink(imgLink);
			} catch (IndexOutOfBoundsException e) {

			}
			Element content_ele = dl_ele.child(1);// dd
			String content = content_ele.text();
			newsItem.setContent(content);

			// 将每个item添加到itemList中
			newsLists.add(newsItem);
		}
		return newsLists;

	}
}
