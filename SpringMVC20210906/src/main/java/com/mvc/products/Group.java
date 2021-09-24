package com.mvc.products;

public class Group {
	private Integer gid; // ����id
	private String gname; // �����W��

	public Group() {

	}

	public Group(Integer gid, String gname) {
        this.gid = gid;
		this.gname = gname;
	}

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	@Override
	public String toString() {
		return "Group [gid=" + gid + ", gname=" + gname + "]";
	}
	

}
