package com.qsl.pojo;

import java.io.File;

public class NewManager extends Manager {
	private File file;
	// �ύ������file������
	private String fileFileName;

	// �ύ������file��MIME����
	private String fileContentType;

	private String old_password;

	public String getOld_password() {
		return old_password;
	}

	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	

}
