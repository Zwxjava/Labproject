package main.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.utils.AppMD5Util;
import main.resources.config.IPconfig;
import main.java.mysql.mysqlUtil;

/**
 * Servlet implementation class LoginServlet
 * author：王喜壮
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String message ="1";//返回信息
		//接收Login.jsp数据
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		System.out.println("user" + user + "password" + password );
		
		//查询数据库 user1 password1 userlevel Nid
		List<Map<String,String>> list = new ArrayList<>();
		try {
		String sql = "select user1,userlevel,Nid,password1 from td_user";
		String[] parame = {"user1" ,"password1","userlevel","Nid"};
		
		list = mysqlUtil.show(sql,parame);
		System.out.println(list);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("LoginServlet"+"查询数据库信息错误"+ list);
		}
		HttpSession session = request.getSession();
		
		String getUser = "";
		String getUserlevel = "";
		String getNid = "";
		String getPassword = "";
		try {
		for( int i=0; i<list.size(); i++ ) {
			if(user.equals(list.get(i).get("user1"))&& 
			   AppMD5Util.getMD5(password).equals(list.get(i).get("password1"))) {
				getUser = list.get(i).get("user1");
				getPassword =list.get(i).get("password1");
				getUserlevel = list.get(i).get("userlevel");
				getNid = list.get(i).get("Nid");
			}
	}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("LoginServlet"+"输入的账号密码与数据库账号密码不匹配");
		}
		System.out.println("user1"+getUser+" "+"password1"+getPassword+" "+"userlevel"+getUserlevel+" "+"Nid"+getNid);
	
		if(user.equals(getUser)&&AppMD5Util.getMD5(password).equals(getPassword)) {
			session.setAttribute("user", getUser);
			session.setAttribute("pasword", getPassword);
			session.setAttribute("Nid", getNid);
		
			  //获取session的验证码
			   String code = (String) request.getSession().getAttribute("code");
		        // 获取页面提交的验证码
		        String inputCode = request.getParameter("code");
		        if(code.toLowerCase().equals(inputCode.toLowerCase())) { // 验证码不区分大小写
		            // 验证成功，跳转到成功页面	
		        	if(getUserlevel.equals("0")) {
		        	System.out.println(getUserlevel);
		 	       	response.sendRedirect("http://"+IPconfig.IP+":8080/Labproject/LoadMenu_zdz");
		 	       	}
		 	       	if(getUserlevel.equals("1")) {
		 	       	System.out.println(getUserlevel);
		 	    	  response.sendRedirect("http://"+IPconfig.IP+":8080/Labproject/ht_update");   
		 	       	}
		 	    	  return;
		        } else { // 验证失败
		        	String aString ="2";
		        response.sendRedirect("http://"+IPconfig.IP+":8080/Labproject/view/jsp/Login.jsp?message="+aString+"");
		        return;
		        }			
		  			}else {	
		  				//账号密码错误
		  			response.sendRedirect("http://"+IPconfig.IP+":8080/Labproject/view/jsp/Login.jsp?message="+message+"");
		  				return;
		  			}
		
	}
}

	
