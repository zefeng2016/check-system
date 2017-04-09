package com.zefeng.checksystem.bean;

public class Post {
	private Integer id;
	private Integer tdid;
	private String postno;
	private String postname;
	private String postwages;
	private Integer postnum;
	private String postjob;

	public Post() {
		super();
	}

	public Post(Integer tdid, String postno, String postname, String postwages,
			Integer postnum, String postjob) {
		super();
		this.tdid = tdid;
		this.postno = postno;
		this.postname = postname;
		this.postwages = postwages;
		this.postnum = postnum;
		this.postjob = postjob;
	}

	public Post(Integer id, Integer tdid, String postno, String postname,
			String postwages, Integer postnum, String postjob) {
		super();
		this.id = id;
		this.tdid = tdid;
		this.postno = postno;
		this.postname = postname;
		this.postwages = postwages;
		this.postnum = postnum;
		this.postjob = postjob;
	}

	public String getPostno() {
		return postno;
	}

	public void setPostno(String postno) {
		this.postno = postno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTdid() {
		return tdid;
	}

	public void setTdid(Integer tdid) {
		this.tdid = tdid;
	}

	public String getPostname() {
		return postname;
	}

	public void setPostname(String postname) {
		this.postname = postname;
	}

	public String getPostwages() {
		return postwages;
	}

	public void setPostwages(String postwages) {
		this.postwages = postwages;
	}

	public Integer getPostnum() {
		return postnum;
	}

	public void setPostnum(Integer postnum) {
		this.postnum = postnum;
	}

	public String getPostjob() {
		return postjob;
	}

	public void setPostjob(String postjob) {
		this.postjob = postjob;
	}

	@Override
	public String toString() {
		return "Post[id=" + id + ", postno=" + postno + ", tdid=" + tdid
				+ ", postname=" + postname + ", postwages=" + postwages
				+ ", postnum=" + postnum + ", postjob=" + postjob + "]";
	}

}
