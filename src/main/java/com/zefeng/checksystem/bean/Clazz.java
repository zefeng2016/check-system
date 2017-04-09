package com.zefeng.checksystem.bean;

public class Clazz {
	private Integer id;
	private String name;
	private Integer pid;

	public Clazz() {
		super();
	}

	public Clazz(String name, Integer pid) {
		super();
		this.name = name;
		this.pid = pid;

	}

	public Clazz(Integer id, String name, Integer pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "Clazzjdbc [id=" + id + ", name=" + name + ", pid=" + pid;
	}
}
