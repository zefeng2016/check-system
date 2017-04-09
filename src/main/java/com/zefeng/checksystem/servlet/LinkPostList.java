package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zefeng.checksystem.bean.Post;
import com.zefeng.checksystem.bean.TdUser;
import com.zefeng.checksystem.common.PostJdbc;
import com.zefeng.checksystem.common.TdJdbc;
import com.zefeng.checksystem.tools.PrintConsole;

public class LinkPostList extends HttpServlet {



	/**
	 * The doGet method of the servlet. <br>
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

		int id = Integer.parseInt(request.getParameter("id"), 10);
		
		List<Post> postlist = PostJdbc.selectPostByTdId(id);
		if (postlist != null) {
			request.setCharacterEncoding("utf-8");
			PrintConsole.Print("正在获取岗位列表");
			response.setContentType("text/html;charset=utf-8");
			request.setAttribute("postlist", postlist);	
			PrintConsole.Print("获取岗位列表成功");
		} else {
			request.setCharacterEncoding("utf-8");
			PrintConsole.Print("正在获取岗位列表");
			response.setContentType("text/html;charset=utf-8");
			request.setAttribute("postlist", "error");	
			PrintConsole.Print("获取岗位列表成功");
		}
		
		TdUser user = TdJdbc.selectUserById(id);
		PrintConsole.Print("正在获取企业简介");
		if (user != null) {
			request.setCharacterEncoding("utf-8");
			request.setAttribute("user", user);	
			response.setContentType("text/html;charset=utf-8");
			PrintConsole.Print("获取企业数据成功");
	        request.getRequestDispatcher("/view/tdindex.jsp").forward(request,response);
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("查无结果，请重试");
			PrintConsole.Print("获取企业简介失败");
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
