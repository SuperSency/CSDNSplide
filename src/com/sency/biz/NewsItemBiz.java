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
 * 1.ÿһ���������Թؼ���"unit"����ʶ��,10�����ž���10��"unit" 2.���ű�������<h1>��ʶ��
 * 
 * @author sency newsList��newsItem�ļ���,newsItem�ְ����ܶ����Ա
 */
// ʹ��Jsoup����HTML����,������item�У���װ����Item
public class NewsItemBiz {
	public List<NewsItem> getItem(int newsType, int currentPage) throws CommonException {
		String urlStr = URLUtil.getUrl(newsType, currentPage);
		String htmlStr = DataUtil.getDate(urlStr);
		List<NewsItem> newsLists = new ArrayList<NewsItem>();
		NewsItem newsItem = null;
		// Jsoup����HTML����
		Document doc = Jsoup.parse(htmlStr);
		/**
		 * ÿһ���������Թؼ���"unit"����ʶ��,10�����ž���10��"unit" �����ӣ�ctrl+u���Կ�Դ��
		 */
		// ������������ǵõ�һ��ҳ������������item�ļ���
		Elements utils = doc.getElementsByClass("unit");
		for (int i = 0; i < utils.size(); i++) {
			newsItem = new NewsItem();
			newsItem.setNewsType(newsType);
			// �õ���һ������
			Element unit_ele = utils.get(i);

			/** ���ű�������<h1>��ʶ�� */
			// �õ���һ�����ŵı���,����get(0)����Ϊh1�ı�ǩֻ��һ��
			Element h1_ele = unit_ele.getElementsByTag("h1").get(0);
			/** ��ȡ���������,��ʽ:<a href="����">���±���</a> */
			// �õ�����,����ǩ���ʶ�Ķ���
			Element h1_a_ele = h1_ele.child(0);
			// ��ȡ����
			String title = h1_a_ele.text();
			// ��ȡ����
			String href = h1_a_ele.attr("href");
			// ���ñ��������
			newsItem.setTitle(title);
			newsItem.setLink(href);

			// ͨ��h4��tag������
			Element h4_ele = unit_ele.getElementsByTag("h4").get(0);
			Element ago_ele = h4_ele.getElementsByClass("ago").get(0);
			String date = ago_ele.text();
			// ����ʱ��
			newsItem.setDate(date);

			// �õ�ͼƬ����������
			Element dl_ele = unit_ele.getElementsByTag("dl").get(0);
			// ͼƬ
			Element dt_ele = dl_ele.child(0);// dt
			try {
				// ����û��ͼƬ
				Element img_ele = dt_ele.child(0);
				String imgLink = img_ele.child(0).attr("src");
				newsItem.setImgLink(imgLink);
			} catch (IndexOutOfBoundsException e) {

			}
			Element content_ele = dl_ele.child(1);// dd
			String content = content_ele.text();
			newsItem.setContent(content);

			// ��ÿ��item��ӵ�itemList��
			newsLists.add(newsItem);
		}
		return newsLists;

	}
}
