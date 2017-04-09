package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zefeng.checksystem.bean.Post;
import com.zefeng.checksystem.common.PostJdbc;
import com.zefeng.checksystem.tools.PrintConsole;

public class PostNewPost extends HttpServlet {

	/**
	 * �����λ��Ϣ. <br>
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
		int isNewPost = Integer.parseInt(request.getParameter("isNewPost"), 10);
		int tdid = Integer.parseInt(request.getParameter("tdno"), 10);
		String postno = request.getParameter("postno");
		String postname = request.getParameter("postname");
		String postwages = request.getParameter("postwages");
		int postnum = Integer.parseInt(request.getParameter("postnum"), 10);
		String postjob = request.getParameter("postjob");
		if(isNewPost==1){
			Post post = new Post(tdid,postno,postname,postwages,postnum,postjob);
			if (PostJdbc.insertPost(post)) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("success");
				PrintConsole.Print("������λ�ɹ�");
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("error");
				PrintConsole.Print("������λʧ��");
			}
		}else{
			int postID = Integer.parseInt(request.getParameter("postID"), 10);
			Post post = new Post(postID,tdid,postno,postname,postwages,postnum,postjob);
			PrintConsole.Print("�޸ĸ�λ"+postID);
			if (PostJdbc.updatePost(post)) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("success");
				PrintConsole.Print("�޸ĸ�λ�ɹ�");
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("error");
				PrintConsole.Print("�޸ĸ�λʧ��");
			}
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
