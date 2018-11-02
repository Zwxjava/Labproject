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

import main.java.mysql.*;
import main.resources.config.IPconfig;

/**
 * Servlet implementation class LoadMenu_zdz
 * 赵大众
 * 最后修改时间：2018-8-20
 */
@WebServlet("/LoadMenu_zdz")
public class LoadMenu_zdz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadMenu_zdz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 IPconfig iPconfig =new IPconfig();
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");	
		
		if(user == null && password ==null){
			 response.sendRedirect("http://"+iPconfig.IP+":8080/Labproject/view/jsp/Login.jsp");
		}else{
			
		//导航栏
		String sql = "select * from td_type ";
		System.out.println(sql);
		String[] params = {"Nid","type"};
		List< Map<String,String> > listmap = new ArrayList<>();	
		
		//书籍
		String sql_books = "select Nid,book_name,book_price,book_number,img,typeid from td_book where isdelete=0 and book_number>0";
		System.out.println(sql_books);
		String[] params_books = {"Nid","book_name","book_price","book_number","img","typeid"};
		List< Map<String,String> > listmap_books = new ArrayList<>();	
		
		//畅销书
		String sql_sellwell = "select Nid,book_name,book_price,book_number,img,typeid from td_book where isdelete=0 and book_number>0 order by book_number limit 0,6";
		System.out.println(sql_sellwell);
		String[] params_sellwell = {"Nid","book_name","book_price","book_number","img","typeid"};
		List< Map<String,String> > listmap_sellwell = new ArrayList<>();	
		
		//新书
		String sql_new = "select Nid,book_name,book_price,book_number,img,typeid from td_book where isdelete=0 and book_number>0 order by Nid desc limit 0,5";
		System.out.println(sql_new);
		String[] params_new = {"Nid","book_name","book_price","book_number","img","typeid"};
		List< Map<String,String> > listmap_new = new ArrayList<>();
		
		//排行榜
		String sql_ranking = "select book_name from td_book where isdelete=0 order by book_number and book_number>0 limit 0,5";
		System.out.println(sql_ranking);
		String[] params_ranking = {"book_name"};
		List< Map<String,String> > listmap_ranking = new ArrayList<>();	
		
		//加载数据
		try{
			//加载导航类数据
			listmap = mysqlUtil.show(sql, params);
			request.setAttribute("menu", listmap);
			
			//加载所有的图书
			listmap_books = mysqlUtil.show(sql_books, params_books);
			request.setAttribute("books", listmap_books);
			
			//加载畅销书
			listmap_sellwell = mysqlUtil.show(sql_sellwell, params_sellwell);
			request.setAttribute("sellwell", listmap_sellwell);
			
			//加载新书
			listmap_new = mysqlUtil.show(sql_new, params_new);
			request.setAttribute("new", listmap_new);
			
			//加载排行榜
			listmap_ranking = mysqlUtil.show(sql_ranking, params_ranking);
			request.setAttribute("ranking", listmap_ranking);
			
			//转发到图书首页
			request.getRequestDispatcher("/view/jsp/Index_zdz.jsp").forward(request, response);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("用户:"+user+"，servlet:LoadMenu_zdz数据加载失败");
			request.setAttribute("message", "数据加载失败");
			request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
