package com.qsl.pojo;

public class Type {

	private int tid;
	private String tname;
	private int isParent;
	private int parentid;
	private int is_del;
	
	
	
	
	public int getIs_del() {
		return is_del;
	}
	public void setIs_del(int is_del) {
		this.is_del = is_del;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public int getIsParent() {
		return isParent;
	}
	public void setIsParent(int isParent) {
		this.isParent = isParent;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	/* £¨·Ç Javadoc£©
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Type [tid=" + tid + ", tname=" + tname + ", isParent="
				+ isParent + ", parentid=" + parentid + ", is_del=" + is_del
				+ "]";
	}
	
	
	
}
