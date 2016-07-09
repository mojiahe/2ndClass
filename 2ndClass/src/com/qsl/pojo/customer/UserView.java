package com.qsl.pojo.customer;

import java.io.File;

import com.qsl.pojo.User;

public class UserView extends User {
	private String isRemember;
	
	private String oldPwd;
	private String newPwd;
	
	private File file;

	// �ύ������file������
	private String fileFileName;

	// �ύ������file��MIME����
	private String fileContentType;

	public String getIsRemember() {
		return isRemember;
	}

	public void setIsRemember(String isRemember) {
		this.isRemember = isRemember;
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

	
	public String getOldPwd() {
		return oldPwd;
	}

	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

	@Override
	public String toString() {
		return "UserView [isRemember=" + isRemember + "]" + super.toString();
	}
	
	
}
