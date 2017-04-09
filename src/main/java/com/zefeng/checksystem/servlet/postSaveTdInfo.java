package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zefeng.checksystem.bean.TdUser;
import com.zefeng.checksystem.common.TdJdbc;
import com.zefeng.checksystem.tools.PrintConsole;

public class postSaveTdInfo extends HttpServlet {


	/**
	 * 保存企业信息. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
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
		doPost(request, response);
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

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("tdid"), 10);
		String tdno = request.getParameter("tangwei");
		String name = request.getParameter("name");
		String user = request.getParameter("user");
		String phone = request.getParameter("phone");
		String local = request.getParameter("local");
		String check = request.getParameter("checkinfo");
		String introduce = request.getParameter("introduce");
		if (id == 0) {
			TdUser tduser = new TdUser(tdno, name, user, phone, check, local,
					introduce);
			id = TdJdbc.insertUser(tduser);
			if ("0".equals(id)) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("error");
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				PrintConsole.Print("查看新增的企业的ID"+id);
				out.write(id+"");
			}
		} else {
			TdUser tduser = new TdUser(id, tdno, name, user, phone, check,
					local, introduce);
			if (TdJdbc.updateUser(tduser)) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("success");
				PrintConsole.Print("保存企业信息成功");
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("error");
				PrintConsole.Print("保存企业信息失败");
			}
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
