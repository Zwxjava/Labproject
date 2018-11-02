package main.java.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class myslef_select_exit
 */
/**
 * 
 * @author 周文先
 * @date 2018/8/20
 * @updatedate 2018/8/20
 * @matters 无
 * @function 注销登陆
 */
@WebServlet("/myslef_select_exit")
public class myslef_select_exit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myslef_select_exit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =request.getSession();
		//如果seeion为空
		if (session ==null) {
			response.sendRedirect("/Labproject/view/jsp/Login.jsp");
			return;
		}
		//如果不为空，移除登陆session
		session.removeAttribute("user");
		//重定向到网页
		response.sendRedirect("/Labproject/view/jsp/Login.jsp");
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		//sessio定义获取session
		
		doGet(request, response);
		
	
	}

}
