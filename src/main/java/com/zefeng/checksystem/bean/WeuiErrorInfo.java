package com.zefeng.checksystem.bean;

public class WeuiErrorInfo {
	private String pagetitel;
	private String errortitle;
	private String errorinfo;
	private String errornum;

	public WeuiErrorInfo() {
		super();
	}

	public WeuiErrorInfo(String pagetitle, String errortitle, String errorinfo,
			String errornum) {
		super();
		this.pagetitel = pagetitle;
		this.errortitle = errortitle;
		this.errorinfo = errorinfo;
		this.errornum = errornum;
	}

	public String getPagetitel() {
		return pagetitel;
	}

	public void setPagetitel(String pagetitel) {
		this.pagetitel = pagetitel;
	}

	public String getErrortitle() {
		return errortitle;
	}

	public void setErrortitle(String errortitle) {
		this.errortitle = errortitle;
	}

	public String getErrorinfo() {
		return errorinfo;
	}

	public void setErrorinfo(String errorinfo) {
		this.errorinfo = errorinfo;
	}

	public String getErrornum() {
		return errornum;
	}

	public void setErrornum(String errornum) {
		this.errornum = errornum;
	}

}
