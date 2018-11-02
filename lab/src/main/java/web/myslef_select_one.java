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

import main.java.mysql.mysqlUtil;


/**
 * Servlet implementation class myslef_select_one
 */
/**
 * 
 * @author 周文先
 * @date 2018/8/20
 * @updatedate 2018/8/20
 * @matters 无
 * @function 查询账户
 */
@WebServlet("/myslef_select_one")
public class myslef_select_one extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myslef_select_one() {
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
		String id = (String)session.getAttribute("Nid");
		System.out.println(id);
		String issubmint =request.getParameter("name");
		String aString =(String)session.getAttribute("user");
		request.setAttribute("aString",aString);
		request.getAttribute("aString");	

		if (issubmint == null) {
			issubmint ="0";
		}else {
			issubmint =request.getParameter("name");
		}	
		//String aString =list.get(0).get("user1");
		request.setAttribute("issubmint",issubmint);
		request.getAttribute("issubmint"); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/myslef_select_payment");
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
