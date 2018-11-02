package main.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.service.Update_myslef;

/**
 * Servlet implementation class myslef_update_ispayment
 */
/**
 * 
 * @author 周文先
 * @date 2018/8/20
 * @updatedate 2018/8/20
 * @matters 无
 * @function 修改提交状态，转到历史订单
 */
@WebServlet("/myslef_update_ispayment")
public class myslef_update_ispayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myslef_update_ispayment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session =request.getSession();
		//判断session是否为空
		  if (session ==null) {
				response.sendRedirect("/Labproject/view/jsp/Login.jsp");
				return;
			}
		String Nid =request.getParameter("Nid");
		System.out.println(Nid);
		Update_myslef update_myslef =new Update_myslef();
		 boolean b = update_myslef.Update_myslef(Nid);
		if (b ==true) {
			request.setAttribute("boo", "修改成功");
		}else {
			request.setAttribute("boo", "修改失败");
		}
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/myslef_select_one");
		 dispatcher.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
