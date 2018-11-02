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

import main.java.utils.AppMD5Util;
import main.java.mysql.mysqlUtil;
/**
 * Servlet implementation class zhuceServlet
 * 王喜壮
 */
@WebServlet("/zhuceServlet")
public class zhuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zhuceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "1";
		String messages = "2";
		String message3 = "3";
		
		String zuser = request.getParameter("zuser");
		String zpassword = request.getParameter("zpassword");
		String rezpassword = request.getParameter("rezpassword");
		String mibao1 =request.getParameter("mibao1");
		String mibao2 =request.getParameter("mibao2");
		
		
		System.out.println("zuser:"+zuser+" "+"zpassword:"+zpassword+" "+"rezpassword:" + rezpassword);
		
		
		if(zpassword==null||zuser==null||zpassword.replaceAll(" ", "").equals("")) {
			response.sendRedirect("/Labproject/view/jsp/zhuce.jsp?message3="+message3+"");
			return;
		}
		//查询数据库 user 是否存在
		List<Map<String,String>> list = new ArrayList<>();
		String sql1 =" select user1 from td_user";
		String [] parame = {"user1"};
		try {
		list = mysqlUtil.show(sql1,parame);
		System.out.println(list);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("zhuceServlet"+"获取的user1报错");	
		}
		//遍历查询结果 
		String user1 ="";
		try {
		for(int i = 0;i<list.size();i++) {
			if(zuser.equals(list.get(i).get("user1"))){
			user1 = list.get(i).get("user1");
			System.err.println(user1);
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("zhuceServlet"+"遍历数据库user1报错");
		}
		//判断账号是否存在
		try {
		if(zuser.equals(user1)) {
	  		System.out.println("====");
	  				//账号已存在
	  			response.sendRedirect("/Labproject/view/jsp/zhuce.jsp?message="+message+"");
	  				return;
	  			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("zhuceServlet"+"判断账号是否存在报错");
		}
		String sql = "";
		System.out.println("zpassword:"+zpassword + "==rezpassword:" + rezpassword );
	
			if(zpassword.equals(rezpassword)) {//比较密码和再次输入密码是否相等
			 sql = "INSERT INTO td_user (user1,password1,mibao1,mibao2) VALUES('"+ zuser +"','"+ AppMD5Util.getMD5(zpassword) +"','"+ mibao1 +"','"+mibao2+"');";
			System.out.println(sql);
			}else {
				response.sendRedirect("/Labproject/view/jsp/zhuce.jsp?messages="+ messages +"");
			}
	
		
		int r = mysqlUtil.add(sql);
		if (r==1) {
			request.setAttribute("message","注册成功");
			String str =(String)request.getAttribute("message");
			System.out.println(str);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/index.jsp");
			dispatcher.forward(request, response); 
		}else {
			
			request.setAttribute("message","注册失败");
			request.getAttribute("message");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/zhuce.jsp");

		}
		
	

		}
}


