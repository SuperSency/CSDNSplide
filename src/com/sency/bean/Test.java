package com.sency.bean;

import java.util.List;

public class Test {
public static void main(String[] args) {
	test01();
}
	public static void test01() {
		NewsItemBiz biz = new NewsItemBiz();
		int currentPage = 1;
		List<NewsItem> newsItems;
		try {
			/**
			 * ҵ��
			 */
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YEJIE, currentPage);
			while(!newsItems.isEmpty()){
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			currentPage++;
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YEJIE, currentPage);
			System.out.println("----------------------");
			}
			System.out.println("+++++++++++++++++++++++++++");
			/**
			 * ����Ա��־
			 */
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_CHENGXUYUAN, currentPage);
			while(!newsItems.isEmpty()){
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			currentPage++;
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_CHENGXUYUAN, currentPage);
			System.out.println("----------------------");
			}
			System.out.println("+++++++++++++++++++++++++++");
			/**
			 * �з�
			 */
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YANFA, currentPage);
			while(!newsItems.isEmpty()){
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			currentPage++;
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YANFA, currentPage);
			System.out.println("----------------------");
			}
			System.out.println("+++++++++++++++++++++++++++");
			/**
			 * �ƶ�
			 */
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YIDONG, currentPage);
			while(!newsItems.isEmpty()){
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			currentPage++;
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YIDONG, currentPage);
			System.out.println("----------------------");
			}
			System.out.println("+++++++++++++++++++++++++++");
			/**
			 * �Ƽ���
			 */
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YUNJISUAN, currentPage);
			while(!newsItems.isEmpty()){
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			currentPage++;
			newsItems = biz.getNewsItems(Constaint.NEWS_TYPE_YUNJISUAN, currentPage);
			System.out.println("----------------------");
			}
			System.out.println("+++++++++++++++++++++++++++");

		} catch (CommonException e) {
			e.printStackTrace();
		}
	}

}
