package com.zefeng.checksystem.bean;

public class StuUser {

	private Integer id;
	private String stuschool;
	private String stuxibu;
	private String stubanji;
	private String stuname;
	private String stuno;
	private String education;

	public StuUser() {
		super();
	}

	public StuUser(String stuschool, String stuxibu, String stubanji,
			String stuname, String stuno,String education) {
		super();
		this.stuschool = stuschool;
		this.stuxibu = stuxibu;
		this.stubanji = stubanji;
		this.stuname = stuname;
		this.stuno = stuno;
		this.education = education;
	}

	public StuUser(Integer id, String stuschool, String stuxibu,
			String stubanji, String stuname, String stuno) {
		super();
		this.id = id;
		this.stuschool = stuschool;
		this.stuxibu = stuxibu;
		this.stubanji = stubanji;
		this.stuname = stuname;
		this.stuno = stuno;
		this.education = education;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStuxibu() {
		return stuxibu;
	}

	public void setStuxibu(String stuxibu) {
		this.stuxibu = stuxibu;
	}

	public String getStubanji() {
		return stubanji;
	}

	public void setStubanji(String stubanji) {
		this.stubanji = stubanji;
	}

	public String getStuname() {
		return stuname;
	}

	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public String getStuno() {
		return stuno;
	}

	public void setStuno(String stuno) {
		this.stuno = stuno;
	}

	public String getStuschool() {
		return stuschool;
	}

	public void setStuschool(String stuschool) {
		this.stuschool = stuschool;
	}
	

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	@Override
	public String toString() {
		return "StuUser [id=" + id + ", stuschool=" + stuschool + ", stuxibu="
				+ stuxibu + ", stubanji=" + stubanji + ", stuname=" + stuname
				+ ", stuno=" + stuno +"education"+education+"]";
	}

}
