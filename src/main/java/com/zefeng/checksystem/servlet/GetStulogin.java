package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zefeng.checksystem.common.DepartClazzLink;

public class GetStulogin extends HttpServlet {
	
	String linkjsonString =null;
	
	/**
	 * 初始化系部班级数据
	 */
	public void init() throws ServletException{
		DepartClazzLink link = new DepartClazzLink();
		this.linkjsonString = link.getDepartClazzLink();
	}
	
	
	
	
	/**
	 * 获取学生登录界面. <br>
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
		
		if(this.linkjsonString!=null){
			request.setAttribute("DcJSON",linkjsonString);
	        request.getRequestDispatcher("/view/stulogin.jsp").forward(request,response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("error");
		}
		
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
		doGet(request, response);
	}

	
}
