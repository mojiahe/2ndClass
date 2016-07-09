package com.qsl.pojo;

public class Teacher {

	private int tea_id;
	private String tea_name;
	private String job;
	private String exp;
	private String pic;
	private int is_del;
	
	public int getTea_id() {
		return tea_id;
	}
	public void setTea_id(int tea_id) {
		this.tea_id = tea_id;
	}
	public String getTea_name() {
		return tea_name;
	}
	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
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
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Teacher [tea_id=" + tea_id + ", tea_name=" + tea_name
				+ ", job=" + job + ", exp=" + exp + ", pic=" + pic
				+ ", is_del=" + is_del + "]";
	}
	
	
	
}
