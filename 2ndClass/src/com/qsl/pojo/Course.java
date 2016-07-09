package com.qsl.pojo;

public class Course {

	private int cid;
	private String cname;
	private String pic;
	private int chapter_num;
	private int stu_num;
	private String cdesc;
	private String level;
	private int  tid;
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
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getChapter_num() {
		return chapter_num;
	}
	public void setChapter_num(int chapter_num) {
		this.chapter_num = chapter_num;
	}
	public int getStu_num() {
		return stu_num;
	}
	public void setStu_num(int stu_num) {
		this.stu_num = stu_num;
	}
	public String getCdesc() {
		return cdesc;
	}
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", pic=" + pic
				+ ", chapter_num=" + chapter_num + ", stu_num=" + stu_num
				+ ", cdesc=" + cdesc + ", level=" + level + ", tid=" + tid
				+ ", is_del=" + is_del + "]";
	}
	
	
	
	
}
