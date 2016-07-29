package com.sency.csdn;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sency.bean.CommonException;

public class DataUtil {
	// ���ظ����ӵ�ַ������
	public static String getDate(String urlStr) throws CommonException {
		StringBuffer sb;
		// ������
		HttpURLConnection conn;
		try {
			URL url = new URL(urlStr);
			conn = (HttpURLConnection) url.openConnection();
			// ����ʽ
			conn.setRequestMethod("GET");
			// ���ó�ʱ
			conn.setConnectTimeout(5000);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			if (conn.getResponseCode() == 200) {
				InputStream is = conn.getInputStream();
				byte[] bys = new byte[1024];
				int len = 0;
				sb = new StringBuffer();
				while ((len = is.read(bys)) != -1) {
					sb.append(new String(bys, 0, len,"UTF-8"));
				}
				is.close();
			} else {
				throw new CommonException("��������ʧ��!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new CommonException("��������ʧ��!");
		}

		return sb.toString();

	}
}
