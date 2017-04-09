package com.zefeng.checksystem.bean;

import java.util.List;

public class Department {

	private Integer id;
	private String name;
	private List<Clazz> classes;

	public Department() {
		super();
	}

	public Department(String name, List<Clazz> classes) {
		super();
		this.name = name;
		this.classes = classes;

	}

	public Department(Integer id, String name, List<Clazz> classes) {
		super();
		this.name = name;
		this.classes = classes;
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

	public List<Clazz> getClasses() {
		return classes;
	}

	public void setClasses(List<Clazz> classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Departmentjdbc [id=" + id + ", name=" + name + ", List<Clazz>="
				+ classes + "]";
	}
}
