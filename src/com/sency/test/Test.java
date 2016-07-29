package com.sency.test;

import java.util.ArrayList;
import java.util.List;

import com.sency.bean.NewsItem;
import com.sency.biz.NewsItemBiz;
import com.sency.csdn.Constaint;

public class Test {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		NewsItemBiz biz = new NewsItemBiz();
		int currentPage = 1;
		try {
			// ҵ��
			List<NewsItem> newsItems = biz.getItem(Constaint.NEWS_TYPE_YEJIE,
					currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("--------------------");
			// ����Ա��־
			newsItems = biz.getItem(Constaint.NEWS_TYPE_CHENGYUXUAN,
					currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("--------------------");
			// �Ƽ���
			newsItems = biz.getItem(Constaint.NEWS_TYPE_YUNJISUAN, currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("--------------------");
			// �з�
			newsItems = biz.getItem(Constaint.NEWS_TYPE_YANFA, currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("--------------------");
			// �ƶ�
			newsItems = biz.getItem(Constaint.NEWS_TYPE_YIDONG, currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
