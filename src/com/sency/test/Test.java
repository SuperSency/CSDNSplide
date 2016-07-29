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
			// 业界
			List<NewsItem> newsItems = biz.getItem(Constaint.NEWS_TYPE_YEJIE,
					currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("--------------------");
			// 程序员杂志
			newsItems = biz.getItem(Constaint.NEWS_TYPE_CHENGYUXUAN,
					currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("--------------------");
			// 云计算
			newsItems = biz.getItem(Constaint.NEWS_TYPE_YUNJISUAN, currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("--------------------");
			// 研发
			newsItems = biz.getItem(Constaint.NEWS_TYPE_YANFA, currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
			System.out.println("--------------------");
			// 移动
			newsItems = biz.getItem(Constaint.NEWS_TYPE_YIDONG, currentPage);
			for (NewsItem item : newsItems) {
				System.out.println(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
