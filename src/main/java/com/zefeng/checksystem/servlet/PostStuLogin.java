package com.zefeng.checksystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zefeng.checksystem.bean.StuUser;
import com.zefeng.checksystem.bean.WeuiErrorInfo;
import com.zefeng.checksystem.common.StuJdbc;
import com.zefeng.checksystem.tools.PrintConsole;

public class PostStuLogin extends HttpServlet {

	

	/**
	 * 保存学生信息. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		String stuschool = request.getParameter("checkbox");
		String stuschoolname = request.getParameter("stu_schoolname");
		String stuxibu = request.getParameter("stu_xibu");
		String stubanji = request.getParameter("stu_banji");
		String stuname = request.getParameter("stu_name");
		String  stuno =request.getParameter("stu_no");
		String  education = request.getParameter("stu_education");
		if(stuschool==null){
			 stuxibu = "外校";
			 stubanji = "外校";
			 stuno ="000000000";
		}
		StuUser user = new StuUser(stuschoolname, stuxibu, stubanji,stuname,stuno,education);
		if(StuJdbc.insertUser(user)){
			 request.getRequestDispatcher("/view/success.jsp").forward(request,response);
			 PrintConsole.Print("保存学生信息成功");
		}else {
			String pagetitel = "签到状态";
			String errortitle = "签到失败";
			String errorinfo = "系统错误，3秒后将自动返回！";
			String errornum = "101";
			WeuiErrorInfo error = new WeuiErrorInfo(pagetitel,errortitle,errorinfo,errornum);
			request.setAttribute("error",error);
	        request.getRequestDispatcher("/view/error.jsp").forward(request,response);
	        PrintConsole.Print("保存学生信息失败");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
