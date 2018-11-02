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

import main.java.entiy.td_book;
import main.java.mysql.mysqlUtil;
import main.resources.config.IPconfig;

/**
 * Servlet implementation class mid
 * author : gaolei
 * 最后修改时间： 08-20
 * 注意事项： 无
 */
@WebServlet("/mid")
public class mid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mid() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");	
		if(user == null && password ==null){
			 response.sendRedirect("http://"+IPconfig.IP+":8080/Labproject/view/jsp/Login.jsp");
		}else{
		
		
		
		String updateid= request.getParameter("update_book_id");
		String updatenum = request.getParameter("update_book_number");
		String updateprice = request.getParameter("update_book_price");
		
		
		/*
		 * 打印日志： 更改的图书id 、更改的图书库存 、更改的图书价格
		 */
		
		System.out.println("updateid: "+updateid+"updatenum: "+updatenum+"updateprice: "+updateprice);
		
		
		
		//接收前端传过来的数据
		
		if((updatenum==null||updatenum.equals(""))&&(updateprice==null||updateprice.equals(""))&&(updateid==null||updateid.equals(""))) {
			System.out.println("11、要更改的信息为空");
			return ;
		}
		else {
			String update_sql = "update td_book set book_price="+updateprice+",book_number="+updatenum +" where Nid =" + updateid;
			System.out.println(update_sql);
			int update = 0;
			try {
				update = mysqlUtil.update(update_sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("更改的返回结果报错");
				System.err.println("用户:"+user+"，servlet: mid  更改的返回结果报错 ");
				request.setAttribute("message", "数据加载失败");
				request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
			}
			
			if(update == 1) {
				 System.out.println("更新成功");
				 request.setAttribute("updatemessage","更新成功");
				 request.getAttribute("updatemessage");
			}
			else {
				 request.setAttribute("updatemessage","更新失败");
				 request.getAttribute("updatemessage");
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/errorPage.jsp");
				 dispatcher.forward(request, response); 
			}
		}
		 
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("ht_update");
		 dispatcher.forward(request, response); 
		 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
