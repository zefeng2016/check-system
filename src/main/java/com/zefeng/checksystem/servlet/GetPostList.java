package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.zefeng.checksystem.bean.Post;
import com.zefeng.checksystem.common.PostJdbc;
import com.zefeng.checksystem.tools.PrintConsole;

public class GetPostList extends HttpServlet {

	/**
	 * 获取岗位列表.
	 * 
	 * 后台获取返回json.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int tdid = Integer.parseInt(request.getParameter("tdid"), 10);
		List<Post> postlist = PostJdbc.selectPostByTdId(tdid);
		if (postlist != null) {
			request.setCharacterEncoding("utf-8");
			PrintConsole.Print("正在获取岗位列表");
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("postlist", postlist);
			out.write(jsonObject.toString());
			PrintConsole.Print("获取岗位列表成功");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("error");
			PrintConsole.Print("正在获取岗位失败");
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}


}
