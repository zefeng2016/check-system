package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zefeng.checksystem.common.DepartClazzLink;

public class GetStulogin extends HttpServlet {

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
		//DepartClazzLink link = new DepartClazzLink();
		//String linkjsonString = link.getDepartClazzLink();
		String linkjsonString=getDepartClazzLink();
		if(linkjsonString!=null){
			request.setAttribute("DcJSON",linkjsonString);
	        request.getRequestDispatcher("/view/stulogin.jsp").forward(request,response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("error");
		}
		
	}
	
	/**
	 * 获取系部班级json
	 * @return
	 */
	protected String getDepartClazzLink(){
		String linkjsonString=null;
		ServletContext application = getServletContext();
		if(application.getAttribute("DepartClazz")==null){
			initDepartClazzLink();
		}
		linkjsonString=application.getAttribute("DepartClazz").toString();		
		return linkjsonString;
	}
	
	/**
	 * 初始化Application对象	
	 */
	private void initDepartClazzLink(){
		ServletContext application = getServletContext();
		DepartClazzLink link = new DepartClazzLink();
		String linkjsonString = link.getDepartClazzLink();
		application.setAttribute("DepartClazz", linkjsonString);		
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
