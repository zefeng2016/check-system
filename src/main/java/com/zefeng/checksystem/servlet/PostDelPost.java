package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zefeng.checksystem.common.PostJdbc;
import com.zefeng.checksystem.tools.PrintConsole;

public class PostDelPost extends HttpServlet {

	
	/**
	 * É¾³ý¸ÚÎ». <br>
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

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("postid"), 10);
		PrintConsole.Print("ÕýÔÚÉ¾³ý¸ÚÎ»"+id);
		boolean delPost = PostJdbc.deletePost(id);
		if (delPost) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("success");
			PrintConsole.Print("É¾³ý¸ÚÎ»³É¹¦");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("error");
			PrintConsole.Print("É¾³ý¸ÚÎ»Ê§°Ü");
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
