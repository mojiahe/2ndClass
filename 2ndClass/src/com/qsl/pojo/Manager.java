package com.qsl.pojo;

public class Manager {
	private int mid;
	private String mname;
	private String password;
	private String nickname;
	private int sex;
	private String tel;
	private String pic;//管理员头像路径
	private String lasttime;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getLasttime() {
		return lasttime;
	}
	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", mname=" + mname + ", password="
				+ password + ", nickname=" + nickname + ", sex=" + sex
				+ ", tel=" + tel + ", pic=" + pic + ", lasttime=" + lasttime
				+ "]";
	}

}
