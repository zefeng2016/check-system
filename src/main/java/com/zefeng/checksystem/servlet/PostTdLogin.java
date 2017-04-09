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

/**
 * Servlet implementation class PostTdLogin
 */
public class PostTdLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTdLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"), 10);
		TdUser user = TdJdbc.selectUserById(id);
		user.setTdcheck("已签到");
		if (TdJdbc.updateUser(user)) {
			request.setAttribute("id", user.getId());
			response.setContentType("text/html;charset=utf-8");
			request.getRequestDispatcher("/view/tdchecksuccess.jsp").forward(request,response);
			PrintConsole.Print("保存企业信息成功");
		} else {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("error");
			PrintConsole.Print("保存企业信息失败");
		}
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
