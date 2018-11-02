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
 * Servlet implementation class myslef_page
 */
/**
 * 
 * @author 周文先
 * @date 2018/8/20
 * @updatedate 2018/8/20
 * @matters 无
 * @function 分页信息
 */
@WebServlet("/myslef_page")
public class myslef_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myslef_page() {
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
		String sql ="select user1 from td_user where Nid =" +id;	
		String issubmint =request.getParameter("name");
		String pageSize =request.getParameter("pageSize");
		String pageIndex =request.getParameter("pagefor");
		String aString =(String)session.getAttribute("user");
		request.setAttribute("aString",aString);
		request.getAttribute("aString");
		System.out.println("User:"+aString+",issubmint :"+ issubmint +",pageSize:"+pageSize+",pageIndex:"+pageIndex);		
		//判断入参是否为空
		if (pageSize ==null || pageSize.equals("")&&pageIndex ==null ||pageIndex.equals("")) {
			System.out.println("User:"+aString+",issubmint :"+ issubmint +",pageSize:"+pageSize+",pageIndex:"+pageIndex);			
			request.setAttribute("message","User:"+aString+",issubmint :"+ issubmint +",pageSize:"+pageSize+",pageIndex:"+pageIndex);
			request.getAttribute("message");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/errorPage.jsp");
			dispatcher.forward(request, response); 
			return;
		}else {
		if (issubmint ==null) {
			issubmint ="0";
		}else {
			issubmint =request.getParameter("name");
		}	 
		System.out.println("User:"+aString+",sql:"+sql);
		String[] params = {"user1"};
		List<Map<String, String>> list =new ArrayList<>();
		try {
			list =mysqlUtil.show(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//xxx是用户唯一标志信息，例如学号，userid等具有唯一性的标志
			System.out.println("User:"+aString+"调用/myslef_page下get方法sql语句错误：" + sql);
			System.out.println("User:"+aString+",issubmint :"+ issubmint +",pageSize:"+pageSize+",pageIndex:"+pageIndex);			
			request.setAttribute("message","User:"+aString+",issubmint :"+ issubmint +",pageSize:"+pageSize+",pageIndex:"+pageIndex);
			request.getAttribute("message");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/errorPage.jsp");
			dispatcher.forward(request, response); 
			return;
			
		}
		
				 
		 List<td_payment> list2 =new ArrayList<>();
		 Select_myslef one =new Select_myslef();
		 list2 = one.select_one(issubmint, aString,pageSize,pageIndex);
		 System.out.println(list);
	     request.setAttribute("list", list2);
	     request.getAttribute("list");  
	     request.setAttribute("pageindex", pageIndex);
		 request.getAttribute("pageindex");
	     RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/myslef.jsp");
		 dispatcher.forward(request, response); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
