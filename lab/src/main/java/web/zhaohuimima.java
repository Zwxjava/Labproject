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
@WebServlet("/zhaohuimima")
public class zhaohuimima extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zhaohuimima() {
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
		String message1 = "1";
		String message2 = "2";
		String message3 = "3";
		String message4 = "4";
		String message5 = "5";
		String zuser = request.getParameter("zuser");
		String zpassword = request.getParameter("zpassword");
		String rezpassword = request.getParameter("rezpassword");
		String mibao1 =request.getParameter("mibao1");
		String mibao2 =request.getParameter("mibao2");
		
		System.out.println("zuser:"+zuser+" "+"zpassword:"+zpassword+" "+"rezpassword:" + rezpassword);
		
		
		if(zpassword==null||zuser==null||zpassword.replaceAll(" ", "").equals("")) {
			response.sendRedirect("/Labproject/view/jsp/zhaohuimima.jsp?message5="+message5+"");
			return;
		}
		//查询数据库 user 是否存在
		List<Map<String,String>> list = new ArrayList<>();
		String sql1 =" select * from td_user";
		String [] parame = {"user1","mibao1","mibao2"};
		try {
		list = mysqlUtil.show(sql1,parame);
		System.out.println(list);
		System.out.println(list.size());
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("zhaohuimima:"+"获取的user1报错");	
		}
		//遍历查询结果 
		String user1 ="";
		String mibao11 ="";
		String mibao22 ="";
		try {
		for(int i = 0;i<list.size();i++)   {
			System.out.println(zuser+"==");
			System.out.println(list.get(i).get("user1")+"---");
			System.out.println(mibao1+"==");
			System.out.println(list.get(i).get("mibao1")+"--");
			if(zuser.equals(list.get(i).get("user1"))&&mibao1.equals(list.get(i).get("mibao1"))&&mibao2.equals(list.get(i).get("mibao2"))){
			user1 = list.get(i).get("user1");
			mibao11 = list.get(i).get("mibao1");
			mibao22 = list.get(i).get("mibao2");
			System.err.println( user1 + mibao11 + mibao22 );
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("zhaohuimima:"+"遍历数据库user1报错");
		}
		//判断账号是否存 	
		
		String sql = "";
		if(zuser.equals(user1)) {
			if(mibao1.equals(mibao11)) {
				if(mibao2.equals(mibao22)) {
					if(zpassword.equals(rezpassword)) {//比较密码和再次输入密码是否相等
						System.out.println("zpassword:"+zpassword + "==rezpassword:" + rezpassword );
				 		sql = "UPDATE td_user SET password1='"+zpassword+"' WHERE user1='"+zuser+"';";
						System.out.println(sql);
					}else {
						response.sendRedirect("/Labproject/view/jsp/zhaohuimima.jsp?message4="+ message4 +"");
					}
				}else {
					response.sendRedirect("/Labproject/view/jsp/zhaohuimima.jsp?message3="+ message3 +"");
				}
			}else {
				response.sendRedirect("/Labproject/view/jsp/zhaohuimima.jsp?message2="+ message2 +"");
			}
		}else {
			response.sendRedirect("/Labproject/view/jsp/zhaohuimima.jsp?message1="+ message1 +"");
		}
			try {
			int r = mysqlUtil.update(sql);
			if (r==1) {
				request.setAttribute("message","密码重置成功");
				String str =(String)request.getAttribute("message");
				System.out.println(str);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/index2.jsp");
				dispatcher.forward(request, response); 
			}else {
				
				request.setAttribute("message","重置密码失败");
				request.getAttribute("message");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/zhuce.jsp");

			}
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("zhaohuimima:"+"sql语句错误"+ sql);
			}
	  			}

		 
}
	




		

