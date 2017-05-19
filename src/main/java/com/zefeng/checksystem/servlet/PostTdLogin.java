package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"), 10);
		// TdUser user = TdJdbc.selectUserById(id);
		TdUser user = getTdUser(id);
		if (user != null) {
			user.setTdcheck("已签到");
			updataTdUSer(user);
			if (TdJdbc.updateUser(user)) {
				request.setAttribute("id", user.getId());
				response.setContentType("text/html;charset=utf-8");
				request.getRequestDispatcher("/view/tdchecksuccess.jsp").forward(request, response);
				PrintConsole.Print("保存企业信息成功");
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("error");
				PrintConsole.Print("保存企业信息失败");
			}
		}else{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write("error");
			PrintConsole.Print("没有对应企业信息");
		}
	}
	
	/**
	 * 更新Application中的td状态
	 * @param user
	 */
	void updataTdUSer(TdUser user){		
		if (getServletContext().getAttribute("tduser") == null) {
			initApplication();
		}
		List<TdUser> allusers = (List<TdUser>) getServletContext().getAttribute("tduser");
		for(int i=0;i<allusers.size();i++){
			if(allusers.get(i).getId().equals(user.getId())){
				allusers.get(i).setTdcheck("已签到");
				getServletContext().setAttribute("tduser", allusers);	
			}
		}
	}

	/**
	 * 初始化application
	 */
	public void initApplication() {
		ServletContext application = getServletContext();
		List<TdUser> user = TdJdbc.selectAllUser();
		application.setAttribute("tduser", user);			
	}

	/**
	 * 按名模糊查找
	 * 
	 * @param name
	 * @return
	 */
	public TdUser getTdUser(int id) {
		TdUser user = null;
		if (getServletContext().getAttribute("tduser") == null) {
			initApplication();
		}
		List<TdUser> allusers = (List<TdUser>) getServletContext().getAttribute("tduser");
		for (TdUser tdUser : allusers) {
			if (tdUser.getId().equals(id)) {
				user = tdUser;
			}
		}
		return user;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
