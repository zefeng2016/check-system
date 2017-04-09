package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zefeng.checksystem.bean.TdUser;
import com.zefeng.checksystem.bean.WeuiErrorInfo;
import com.zefeng.checksystem.common.TdJdbc;
import com.zefeng.checksystem.tools.PrintConsole;

public class GetTdInfo extends HttpServlet {


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

		HttpSession session = request.getSession(); 
		if (session.getAttribute("adminid")!=null) {
		List<TdUser> user = TdJdbc.selectAllUser(); 
		PrintConsole.Print("正在获取企业数据");
		if (user!=null) {
			request.setCharacterEncoding("utf-8");
			request.setAttribute("tdusers",user);
			PrintConsole.Print("获取企业数据成功");
	        request.getRequestDispatcher("/view/td.jsp").forward(request,response);
		}else{
				String pagetitel = "系统错误";
				String errortitle = "数据库查询失败";
				String errorinfo = "系统错误，3秒后将自动返回！";
				String errornum = "102";
				WeuiErrorInfo error = new WeuiErrorInfo(pagetitel,errortitle,errorinfo,errornum);
				request.setAttribute("error",error);
		        request.getRequestDispatcher("/view/error.jsp").forward(request,response);
		        PrintConsole.Print("获取企业数据失败");
			}
	}else {
		request.setCharacterEncoding("utf-8");
		request.getRequestDispatcher("/view/adminErrorLogin.jsp").forward(request,response);
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
