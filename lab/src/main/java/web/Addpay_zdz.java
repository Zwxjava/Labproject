package main.java.web;

import main.java.utils.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.mysql.mysqlUtil;

/**
 * Servlet implementation class Addpay_zdz
 * 赵大众
 * 最后修改时间：2018-8-20
 */
@WebServlet("/Addpay_zdz")
public class Addpay_zdz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addpay_zdz() {
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
		// TODO Auto-generated method stub
		//设置前台传来的格式为utf-8
		request.setCharacterEncoding("utf-8");
		
		//获得写入session中的Nid
		HttpSession session = request.getSession();
		Object userid = session.getAttribute("Nid");
		//验证是否登陆
		if(userid == null){
			request.setAttribute("message", "你没有登陆");
			request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
			return;
		}
		
		//获得书的名字，价格，购买数量
		String name = request.getParameter("name");
		String Nid = request.getParameter("Nid");
		String price = request.getParameter("price");
		String num = request.getParameter("num");
		//打印入参
		System.out.println("用户："+Nid+"Addpay_zdz"+"name:"+name+","+"Nid:"+Nid+","+"price:"+price+","+"num:"+num);
		
		//向数据库插入
		try{
			
			int nums = Integer.parseInt(num);
			int prices = Integer.parseInt(price);
			int tolPrice = nums*prices;
		
			String sql = "insert into td_payment(book_name,book_price,book_number,userid) values('"+name+"',"+tolPrice+","+nums+","+userid+")";
			System.out.println(sql);
			int flag = mysqlUtil.add(sql);
			
			String sql2 = "update td_book set book_number =book_number - "+nums+" where Nid="+Nid;
			System.out.println(sql2);
			int flag2 = mysqlUtil.update(sql2);
			
			if((flag == 1)&&(flag2 == 1)){
				response.sendRedirect("LoadMenu_zdz");
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("向数据库插入失败");
			request.setAttribute("message", "数据异常，购买失败失败！");
			request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
		}
	}

}
