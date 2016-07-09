package com.qsl.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOperation {

	/**
	 * 
	 * @Title: fileUpload
	 * @Description: 上传文件工具
	 * @param file
	 *            上传的文件
	 * @param fileFileName
	 *            上传的文件的原来名字
	 * @param fileContentType
	 *            上传的文件类型
	 * @throws IOException
	 * @return Boolean
	 *
	 */
	public static Boolean fileUpload(File file, String fileFileName, String fileContentType) {
		try {
			InputStream is = new FileInputStream(file);
			String tomcat_path = System.getProperty("catalina.home");

			String pic_path = tomcat_path + "\\webapps\\ROOT\\2ndClassPic\\";

			OutputStream os = new FileOutputStream(new File(pic_path, file.getName()));

			//System.out.println("fileFileName: " + fileFileName + "file.getName：" +file.getName());

			byte[] buffer = new byte[500];
			int length = 0;

			while (-1 != (length = is.read(buffer, 0, buffer.length)))

				os.write(buffer);

			os.close();
			is.close();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
