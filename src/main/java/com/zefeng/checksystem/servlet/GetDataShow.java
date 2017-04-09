package com.zefeng.checksystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zefeng.checksystem.bean.WeuiErrorInfo;
import com.zefeng.checksystem.common.StuJdbc;
import com.zefeng.checksystem.common.TdJdbc;
import com.zefeng.checksystem.tools.PrintConsole;

public class GetDataShow extends HttpServlet {

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
			int tdcnt = TdJdbc.selectTdCount();
			int otherStu = StuJdbc.selectOtherSchool();
			int ourStu = StuJdbc.selectOurSchool();
			PrintConsole.Print("正在获取企业数据");
			if ("0".equals(tdcnt)) {
				String pagetitel = "系统错误";
					String errortitle = "数据库查询失败";
					String errorinfo = "系统错误，3秒后将自动返回！";
					String errornum = "102";
					WeuiErrorInfo error = new WeuiErrorInfo(pagetitel,errortitle,errorinfo,errornum);
					request.setAttribute("error",error);
			        request.getRequestDispatcher("/view/error.jsp").forward(request,response);
			        PrintConsole.Print("获取统计数据失败");
			}else{
				request.setCharacterEncoding("utf-8");
				request.setAttribute("tdcnt",tdcnt);
				request.setAttribute("otherStu",otherStu);
				request.setAttribute("ourStu",ourStu);
				PrintConsole.Print("获取企业数据成功");
		        request.getRequestDispatcher("/view/datashow.jsp").forward(request,response);
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

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
