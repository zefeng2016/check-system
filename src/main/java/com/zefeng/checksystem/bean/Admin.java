package com.zefeng.checksystem.bean;

public class Admin {
	private Integer id;
	private String username;
	private String password;
	private String adminname;

	public Admin() {
		super();
	}

	public Admin(String username, String password, String adminname) {
		super();
		this.username = username;
		this.password = password;
		this.adminname = adminname;

	}

	public Admin(Integer id, String username, String password, String adminname) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.adminname = adminname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", username=" + username + ", password="
				+ password + ", adminname=" + adminname;
	}
}
