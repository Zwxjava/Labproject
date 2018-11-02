package main.java.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.mysql.mysqlUtil;
import main.resources.config.IPconfig;

/**
 * Servlet implementation class mid_del
 * author:gaolei
 * 最后修改时间：08-20 晚
 * 注意事项：无
 */
@WebServlet("/mid_del")
public class mid_del extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mid_del() {
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
		
		String delbookid = request.getParameter("hiddenvalue");
		System.out.println(delbookid);
		int delbooks = 0;
		try {
			if(delbookid==null||delbookid.equals("")) {
				System.out.println("11要删除的bookvalue为null");
			
			}
			else {
				System.out.println("22要删除的bookvalue为"+delbookid);
				String delbook ="update td_book set isdelete=1 where Nid="+delbookid;
				System.out.println(delbook);
				delbooks = mysqlUtil.update(delbook);
				 if(delbooks==1) {
						request.setAttribute("message","删除图书成功");
						request.getAttribute("message");
						System.out.println("删除图书成功");
						
						 RequestDispatcher dispatcher = request.getRequestDispatcher("he_del_searchtype");
							dispatcher.forward(request, response); 
							return;
					}
					else {
						request.setAttribute("message","删除图书失败");
						request.getAttribute("message");
						System.out.println("删除图书失败");
						 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/errorPage.jsp");
						 dispatcher.forward(request, response); 
					}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("33要删除的bookvalue为null");
			System.err.println("用户:"+user+"，servlet: mid_del 数据获取失败   要删除的typevalue为null ");
			request.setAttribute("message", "数据加载失败");
			request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
		}
	
		//删除图书类型
		
		String deltypeid = request.getParameter("hiddentypevalue");
		System.out.println("要删除的类型id"+deltypeid);
		int deltypes=0;
		try {
			if(deltypeid==null||deltypeid.equals("")) {
				System.out.println("44要删除的deltypeid为null");
				request.setAttribute("message","删除类型失败，");
				request.getAttribute("message");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/errorPage.jsp");
				 dispatcher.forward(request, response); 
				return;
			}
			else {
				System.out.println("55要删除的deltypeid为"+delbookid);
				String deltype ="delete from td_type where Nid="+deltypeid;
				 deltypes = mysqlUtil.update(deltype);
				String deltypebooks ="update td_book set isdelete=1 where typeid="+deltypeid;
				 mysqlUtil.update(deltypebooks);
				
				 if(deltypes==1) {
						request.setAttribute("message","删除类别成功");
						request.getAttribute("message");
						System.out.println("删除类别成功");
					}
					else {
						request.setAttribute("message","删除类别失败");
						request.getAttribute("message");
						System.out.println("删除类别失败");
						 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/errorPage.jsp");
						 dispatcher.forward(request, response); 
					}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("66要删除的typevalue为null");
			System.err.println("用户:"+user+"，servlet: mid_del 数据获取失败   要删除的typevalue为null ");
			request.setAttribute("message", "数据加载失败");
			request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("he_del_searchtype");
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
