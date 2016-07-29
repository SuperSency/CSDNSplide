package com.sency.csdn;

public class URLUtil {
	public static final String NEWS_LIST_URL = "http://www.csdn.net/headlines.html";
	public static final String NEWS_LIST_URL_YIDONG = "http://mobile.csdn.net/mobile";
	public static final String NEWS_LIST_URL_YANFA = "http://sd.csdn.net/sd";
	public static final String NEWS_LIST_URL_YUNJISUAN = "http://cloud.csdn.net/cloud";
	public static final String NEWS_LIST_URL_ZAZHI = "http://programmer.csdn.net/programmer";
	public static final String NEWS_LIST_URL_YEJIE = "http://news.csdn.net/news";

	// 根据文章类型和当前页码生成相应的URL
	public static String getUrl(int newsType, int currentPage) {
		currentPage = currentPage > 0 ? currentPage : 1;
		String urlStr = "";
		switch (newsType) {
		case Constaint.NEWS_TYPE_YEJIE:
			urlStr = NEWS_LIST_URL_YEJIE;
			break;
		case Constaint.NEWS_TYPE_YANFA:
			urlStr = NEWS_LIST_URL_YANFA;
			break;
		case Constaint.NEWS_TYPE_CHENGYUXUAN:
			urlStr = NEWS_LIST_URL_ZAZHI;
			break;
		case Constaint.NEWS_TYPE_YUNJISUAN:
			urlStr = NEWS_LIST_URL_YUNJISUAN;
			break;
		case Constaint.NEWS_TYPE_YIDONG:
			urlStr = NEWS_LIST_URL_YIDONG;
			break;
		default:
			break;
		}
		urlStr += "/" + currentPage;
		return urlStr;
	}
}
