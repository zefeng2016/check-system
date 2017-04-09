package com.zefeng.checksystem.bean;

public class TdUser {
	private Integer id;
	private String tdno;
	private String tdname;
	private String tduser;
	private String tdphone;
	private String tdcheck;
	private String local;
	private String introduce;

	public TdUser() {
		super();
	}

	public TdUser(String tdno, String tdname, String tduser, String tdphone,
			String tdcheck, String local, String introduce) {
		super();
		this.tdno = tdno;
		this.tdname = tdname;
		this.tduser = tduser;
		this.tdphone = tdphone;
		this.tdcheck = tdcheck;
		this.local = local;
		this.introduce = introduce;
	}

	public TdUser(Integer id, String tdno, String tdname, String tduser,
			String tdphone, String tdcheck, String local, String introduce) {
		super();
		this.id = id;
		this.tdno = tdno;
		this.tdname = tdname;
		this.tduser = tduser;
		this.tdphone = tdphone;
		this.tdcheck = tdcheck;
		this.local = local;
		this.introduce = introduce;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTdno() {
		return tdno;
	}

	public void setTdno(String tdno) {
		this.tdno = tdno;
	}

	public String getTdname() {
		return tdname;
	}

	public void setTdname(String tdname) {
		this.tdname = tdname;
	}

	public String getTduser() {
		return tduser;
	}

	public void setTduser(String tduser) {
		this.tduser = tduser;
	}

	public String getTdphone() {
		return tdphone;
	}

	public void setTdphone(String tdphone) {
		this.tdphone = tdphone;
	}

	public String getTdcheck() {
		return tdcheck;
	}

	public void setTdcheck(String tdcheck) {
		this.tdcheck = tdcheck;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "TdUser [id=" + id + ", tdno=" + tdno + ", tdname=" + tdname
				+ ", tduser=" + tduser + ", tdphone=" + tdphone + ", tdcheck="
				+ tdcheck + ", local=" + local + ", introduce=" + introduce
				+ "]";
	}

}
