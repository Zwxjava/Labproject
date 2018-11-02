package main.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.entiy.td_payment;
import main.java.mysql.mysqlUtil;
import main.java.service.Select_myslef;

/**
 * Servlet implementation class myslef_select_payment
 */
/**
 * 
 * @author 周文先
 * @date 2018/8/20
 * @updatedate 2018/8/20
 * @matters 无
 * @function  选择td_payment里的数据
 */
@WebServlet("/myslef_select_payment")
public class myslef_select_payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myslef_select_payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session =request.getSession();
		//判断session是否为空
		if (session ==null) {
			response.sendRedirect("/Labproject/view/jsp/Login.jsp");
			return;
		}
		String user1 = (String)session.getAttribute("user");
		System.out.println("用户："+user1);
		 List<td_payment> list =new ArrayList<>();
		 Select_myslef one =new Select_myslef();	  
		 list = one.select_four((String)request.getAttribute("issubmint"), user1);
		 System.out.println(list);
	     request.setAttribute("list", list);
	     request.getAttribute("list");     
	     RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/myslef.jsp");
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
