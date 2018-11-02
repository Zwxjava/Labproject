package main.java.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.entiy.td_type;
import main.java.mysql.mysqlUtil;
import main.java.utils.ImageBase64;
import main.resources.config.IPconfig;


/**
 * Servlet implementation class ht_insert_newbook
 * author:gaoelei
 * 添加图书类型，添加图书，在添加图书的时候获取之前添加的图书类型
 * 最后修改时间：08-20 晚
 * 注意事项：无
 */
@WebServlet("/ht_insert_newbook")
public class ht_insert_newbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ht_insert_newbook() {
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
		String type = request.getParameter("add_type_input");
		System.out.println(type);
		
		if(type==null||type.equals("")) {
			System.out.println("还没有输入书名");
			
		}
		else {
			//执行sql语句，插入图书类型
			String sql ="insert into td_type(type)values('"+type+"')";
			System.out.println(sql);
			int r = 0;
			try {
				r = mysqlUtil.add(sql);//返回值接收
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("插入类型操作返回值接受报错");
				System.err.println("用户:"+user+"，servlet:ht_insert_newbook插入类型操作返回值接受报错");
				request.setAttribute("message", "数据加载失败");
				request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
			}
			if (r==1){
				request.setAttribute("message","成功插入类型");
				request.getAttribute("message");
				System.out.println("插入类别成功");
				
			}else{
				request.setAttribute("message","失败插入类型");
				request.getAttribute("message");
				System.out.println("插入类别失败 sql:" + sql);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/errorPage.jsp");
				dispatcher.forward(request, response); 
				
			}
		}
		
		//获取之前添加到数据库中的图书类型，在添加图书的时候做为参数添加到图书表格中
		String sql ="select * from td_type";
		System.out.println(sql);
		List<Map<String, String>> list =new ArrayList<>();	
		String[] params = {"Nid","type"};
		try {
			list =mysqlUtil.show(sql, params);
			List<td_type> list2 =new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {
				td_type a =new td_type();
				a.setId(list.get(i).get("Nid"));
				a.setType(list.get(i).get("type"));
			    list2.add(a);
			    System.out.println(list.get(i).get("Nid"));
			    System.out.println(list.get(i).get("type"));
			}
			 request.setAttribute("list2",list2);
			 request.getAttribute("list2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("获取图书类型数组失败");
			System.err.println("用户:"+user+"，servlet:ht_insert_newbook数据获取失败");
			request.setAttribute("message", "数据加载失败");
			request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
		}
	
		 
		    Date date=new Date();
			request.setCharacterEncoding("utf-8");
			
			String selectvalue = request.getParameter("add_book_select");
			String book_name = request.getParameter("add_book_name");
			String book_price = request.getParameter("add_book_price");
			String book_number = request.getParameter("add_book_number");
			String imagedata = request.getParameter("imagedata");
			
			//打印日志：图片的base64字符串 、图书类型id、图书名称、图书价格、图书库存 
			
			System.out.println("selectvalue:"+selectvalue+"book_name:"+book_name+"book_price:"+book_price+"book_number:"+book_number);
			//base64很长，分开打印  方便查看
			System.out.println("imagedata:"+imagedata);

			if((selectvalue==null||selectvalue.equals(""))&&(book_name==null||book_name.equals(""))&&(book_price==null||book_price.equals(""))&&(book_number==null||book_number.equals(""))&&
					(imagedata==null||imagedata.equals(""))) {
				System.out.println("没有输入添加图书的信息");
				
			}
			else {
				//执行sql语句，将jsp传到servlet的数据作为参数，添加到图书对应的数据库表中
				//GenerateImage 有两个参数，一个是base64字符串，另一个参数是生成图片的路径
				ImageBase64.GenerateImage(imagedata.replace("data:image/png;base64,", ""),"D:/git/book/Labproject/lab/WebContent/resourses/imgs/books"+date.getTime()+".png");
				//实际存放在数据库表中的图片路径
				String imgs="/WebContent/resourses/imgs/books/"+date.getTime()+".png";
				String insertbooks = "insert into td_book (book_name,book_price,book_number,img,typeid)values('"+book_name+"','"+book_price+"','"+book_number+"','"+imgs+"','"+selectvalue+"')";
				System.out.println(insertbooks);
				int insert=0;
				try {
					insert = mysqlUtil.add(insertbooks);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.err.println("获取插入图书操作的返回值报错");
					System.err.println("用户:"+user+"，servlet: ht_insert_newbook 数据获取失败  list1  ");
					request.setAttribute("message", "数据加载失败");
					request.getRequestDispatcher("/view/jsp/errorPage.jsp").forward(request, response);
				}
				if(insert==1) {
					request.setAttribute("message","成功插入图书");
					request.getAttribute("message");
					System.out.println("插入图书成功");
				}
				else {
					request.setAttribute("message","成功插入失败");
					request.getAttribute("message");
					System.out.println( "user:"+user+"插入图书失败"+"sql:"+insertbooks);
					 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/errorPage.jsp");
					 dispatcher.forward(request, response); 
				}
				
			}
			
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/view/jsp/ht_insert.jsp");
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
