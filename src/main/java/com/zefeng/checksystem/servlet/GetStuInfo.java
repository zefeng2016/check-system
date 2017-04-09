package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zefeng.checksystem.bean.StuUser;
import com.zefeng.checksystem.bean.WeuiErrorInfo;
import com.zefeng.checksystem.common.StuJdbc;

public class GetStuInfo extends HttpServlet {

	/**
	 * 获取学生列表. <br>
	 *
	 * 直接返回页面.
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
		List<StuUser> user = StuJdbc.selectAllUser(); 
		if (user!=null) {
			request.setCharacterEncoding("utf-8");
			request.setAttribute("users",user);
	        request.getRequestDispatcher("/view/stu.jsp").forward(request,response);
		}else{
				String pagetitel = "系统错误";
				String errortitle = "数据库查询失败";
				String errorinfo = "系统错误，3秒后将自动返回！";
				String errornum = "102";
				WeuiErrorInfo error = new WeuiErrorInfo(pagetitel,errortitle,errorinfo,errornum);
				request.setAttribute("error",error);
		        request.getRequestDispatcher("/view/error.jsp").forward(request,response);
				
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
