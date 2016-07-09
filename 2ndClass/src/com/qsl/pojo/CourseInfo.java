package com.qsl.pojo;

public class CourseInfo {

	private int cid;
	private int tea_id;
	private String scope;
	private String method;
	private String harvest;
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
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getTea_id() {
		return tea_id;
	}
	public void setTea_id(int tea_id) {
		this.tea_id = tea_id;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getHarvest() {
		return harvest;
	}
	public void setHarvest(String harvest) {
		this.harvest = harvest;
	}
	
	
	
	public CourseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CourseInfo [cid=" + cid + ", tea_id=" + tea_id + ", scope="
				+ scope + ", method=" + method + ", harvest=" + harvest
				+ ", is_del=" + is_del + "]";
	}
	
	
	
}
