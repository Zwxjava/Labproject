package main.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import main.java.service.Update_myslef;

/**
 * Servlet implementation class myslef_update_issubmit
 */
/**
 * 
 * @author 周文先
 * @date 2018/8/20
 * @updatedate 2018/8/20
 * @matters 无
 * @function 修改提交状态改为已提交
 */
@WebServlet("/myslef_update_issubmit")
public class myslef_update_issubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myslef_update_issubmit() {
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
		String user1 = (String)session.getAttribute("user");
		
		System.out.println(user1);
		 String issubmint =request.getParameter("name");
			if (issubmint ==null) {
				issubmint ="0";
			}else {
				issubmint =request.getParameter("name");
			}
			//判断入参是否为空
			if (issubmint ==null||issubmint.equals("")) {
				System.out.println("用户："+user1+",issubmint:"+issubmint);
				request.setAttribute("message","用户："+user1+",issubmint:"+issubmint);
			     request.getAttribute("message");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/errorPage.jsp");
				dispatcher.forward(request, response); 
				return;
			}	 
		 List<td_payment> list =new ArrayList<>();
		 Select_myslef one =new Select_myslef();
		 list = one.select_four(issubmint, user1);
		     Date date =new Date();
			long d =date.getTime();
		for(int i =0;i<list.size();i++) {
			String Nid = list.get(i).getNid();
			Update_myslef update_myslef =new Update_myslef();
			 boolean b = update_myslef.Update_mysleftwo(Nid,d);
			if (b ==true) {
				request.setAttribute("boo", "修改成功");
			}else {
				request.setAttribute("boo", "修改失败");
			}
		}
		
		 request.setAttribute("list", list);
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
