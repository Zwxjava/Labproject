package main.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.entiy.td_book;
import main.java.entiy.td_type;
import main.java.mysql.mysqlUtil;
import main.resources.config.IPconfig;



/**
 * Servlet implementation class he_del_searchtype
 */
@WebServlet("/he_del_searchtype")
public class he_del_searchtype extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * author:gaolei
     * 实现两种删除：1、删除图书类别，删除类别之后，响应的图书在首页时查看不到的 ，删除图书类别表中的一行，更改图书数据表中的isdelete字段的值
     *           2、删除图书，“假”删除 只是更改图书数据表中的isdelete字段
     *  最后修改时间： 08-20
     *  注意事项： 无
     */
    public he_del_searchtype() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		IPconfig iPconfig =new IPconfig();
		String user = (String)session.getAttribute("user");
		String password = (String)session.getAttribute("password");	
		if(user == null && password ==null){
			 response.sendRedirect("http://"+iPconfig.IP+":8080/Labproject/view/jsp/Login.jsp");
		}else{
		//查询要删除的图书类别
		request.setCharacterEncoding("utf-8");
		String del_type="select * from td_type";
		List<Map<String, String>> list =new ArrayList<>();	
		String[] params = {"Nid","type"};
		String deltype="";
		try {
			list =mysqlUtil.show(del_type, params);
			deltype="{\"code\":200,\"shuzu\":[";
			for (int i = 0; i < list.size(); i++) {
				if(i==list.size()-1) {
					deltype+= "["+list.get(i).get("Nid")+",\""+list.get(i).get("type")+"\"]";
			      }
				else {
					deltype+= "["+list.get(i).get("Nid")+",\""+list.get(i).get("type")+"\"],";
				 }
			}
			deltype+="]}";
			System.out.println("删除类型字符串："+deltype);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.err.println("用户:"+user+"，servlet:he_del_searchtype数据获取失败");
			request.setAttribute("message", "数据加载失败");
			request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
		}
		
		//查询要删除的图书名称
		String del_book="select * from td_book where isdelete =0";
		System.out.println(del_book);
		List<Map<String, String>> list1 =new ArrayList<>();	
		String[] params1 = {"Nid","book_name"};
		String delbook="";
		try {
			list1 =mysqlUtil.show(del_book, params1);
			delbook="{\"code\":200,\"shuzu\":[";
			for (int i = 0; i < list1.size(); i++) {
				if(i==list1.size()-1) {
					delbook+= "["+list1.get(i).get("Nid")+",\""+list1.get(i).get("book_name")+"\"]";
			      }
				else {
					delbook+= "["+list1.get(i).get("Nid")+",\""+list1.get(i).get("book_name")+"\"],";
				 }
			}
			delbook+="]}";
			System.out.println("删除图书字符串："+delbook);
		} catch (Exception e1) {
			e1.printStackTrace();
			System.err.println("获取要删除的图书数组list1/listdel_book报错");
			System.err.println("用户:"+user+"，servlet:he_del_searchtype数据获取失败");
			request.setAttribute("message", "数据加载失败");
			request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
		}
		
		request.setAttribute("deltype",deltype);
		request.getAttribute("deltype");
		request.setAttribute("delbook",delbook);
		request.getAttribute("delbook");
		
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/ht_deltype.jsp");
		 dispatcher.forward(request, response); 
	
		}
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
