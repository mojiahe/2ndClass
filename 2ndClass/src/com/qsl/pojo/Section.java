package com.qsl.pojo;

public class Section {

	private int sid;
	private String sname;
	private String sdesc;
	private int ord;
	private String time;
	private String url;
	private int cid;
	private int is_del;
	
	
	
	/**
	 * @return is_del
	 */
	public int getIs_del() {
		return is_del;
	}
	/**
	 * @param is_del 要设置的 is_del
	 */
	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSdesc() {
		return sdesc;
	}
	public void setSdesc(String sdesc) {
		this.sdesc = sdesc;
	}
	
	/**
	 * @return ord
	 */
	public int getOrd() {
		return ord;
	}
	/**
	 * @param ord 要设置的 ord
	 */
	public void setOrd(int ord) {
		this.ord = ord;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Section [sid=" + sid + ", sname=" + sname + ", sdesc=" + sdesc
				+ ", order=" + ord + ", time=" + time + ", url=" + url
				+ ", cid=" + cid + "]";
	}
	
	
	
	
	
}
