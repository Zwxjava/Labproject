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
import javax.sound.midi.Soundbank;

import main.java.entiy.td_book;
import main.java.mysql.mysqlUtil;
import main.resources.config.IPconfig;



/**
 * Servlet implementation class ht_update
 * author:gaolei
 * 实现对图书的价格，库存量进行更新
 * 最后修改时间： 08-20 晚
 * 注意事项：无
 */
@WebServlet("/ht_update")
public class ht_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ht_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 IPconfig iPconfig =new IPconfig();
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");	
		if(user == null && password ==null){
			 response.sendRedirect("http://"+iPconfig.IP+":8080/Labproject/view/jsp/Login.jsp");
		}else{		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String del_book="select * from td_book where isdelete =0";
		System.out.println(del_book);
		List<Map<String, String>> list1 =new ArrayList<>();	
		String[] params1 = {"Nid","book_name","book_price","book_number"};
		//List<td_book> listdel_book=null;
		 String outstr="";
		try {
			    list1 =mysqlUtil.show(del_book, params1);
			    outstr="{\"code\":200,\"shuzu\":[";
			for (int i = 0; i < list1.size(); i++) {
				if(i==list1.size()-1) {
				outstr+= "["+list1.get(i).get("Nid")+",\""+list1.get(i).get("book_name")+"\","+list1.get(i).get("book_number")+","+list1.get(i).get("book_price")+"]";
		      }
				else {
					outstr+= "["+list1.get(i).get("Nid")+",\""+list1.get(i).get("book_name")+"\","+list1.get(i).get("book_number")+","+list1.get(i).get("book_price")+"],";
				}
			}
			outstr+="]}";
			//打印出参
			System.out.println(outstr);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("list1报错");
			System.err.println("用户:"+user+"，servlet:ht_update 数据获取失败  list1  ");
			request.setAttribute("message", "数据加载失败");
			request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
		}

		 request.setAttribute("outstr",outstr);
		 request.getAttribute("outstr");
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/ht_update.jsp");
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
