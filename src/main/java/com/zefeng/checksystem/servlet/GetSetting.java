package com.zefeng.checksystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zefeng.checksystem.bean.Admin;
import com.zefeng.checksystem.common.AdminJdbc;

public class GetSetting extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetSetting() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
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

		HttpSession session = request.getSession();
		if (session.getAttribute("adminid") != null) {

			int id = Integer.parseInt(session.getAttribute("adminid")
					.toString(), 10);

			Admin admin = AdminJdbc.selectAdminById(id);

			response.setContentType("text/html;charset=utf-8");
			request.setAttribute("admin_username", admin.getAdminname());
			request.setAttribute("admin_name", admin.getUsername());
			request.getRequestDispatcher("/view/setting.jsp").forward(request,
					response);
		} else {
			request.setCharacterEncoding("utf-8");
			request.getRequestDispatcher("/view/adminErrorLogin.jsp").forward(
					request, response);
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
		HttpSession session = request.getSession();
		if (session.getAttribute("adminid") != null) {
			int admin_id = Integer.parseInt(session.getAttribute("adminid")
					.toString(), 10);
			request.setCharacterEncoding("UTF-8");
			String admin_username = request.getParameter("admin_username");
			String admin_name = request.getParameter("admin_name");
			String admin_password = request.getParameter("admin_password");
			System.out.println("获取前台账户" + admin_id + "," + admin_name + ","
					+ admin_username + "," + admin_password);
			Admin upadmin = new Admin(admin_id, admin_name, admin_password,
					admin_username);
			System.out.println(upadmin);
			// public Admin(Integer id, String username, String password, String
			// adminname)
			if (AdminJdbc.updateAdmin(upadmin)) {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("success");
				// PrintConsole.Print("保存企业信息成功");
			} else {
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write("error");
				// PrintConsole.Print("保存企业信息失败");
			}
		} else {
			request.setCharacterEncoding("utf-8");
			request.getRequestDispatcher("/view/adminErrorLogin.jsp").forward(
					request, response);
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
