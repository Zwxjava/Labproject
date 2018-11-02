package main.java.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import main.java.entiy.td_payment;
import main.java.entiy.td_type;
import main.java.mysql.mysqlUtil;

/**
 * 
 * 作者： Administrator
 * 创建日期：
 * 最后修改时间：
 * 注意事项：无
 */
public class Select_myslef {
	//根据参数查询td_payment表的内容
	public List<td_payment> select_one(String issubmint,String user,String pageSize,String pageIndex) {
		System.out.println(",user:"+user+"issubmint:"+issubmint+",pageSize:"+pageSize+",pageIndex"+pageIndex);
		if (issubmint ==null ||issubmint.equals("")&&user ==null ||user.equals("")&&pageSize ==null ||pageSize.equals("")&&pageIndex ==null ||pageIndex.equals("")) {
			System.out.println(",user:"+user+"issubmint:"+issubmint+",pageSize:"+pageSize+",pageIndex"+pageIndex);
			List<td_payment> list2 =new ArrayList<>();
			return list2;
		}else {
		int aint =Integer.parseInt(pageSize);
		System.out.println(aint);
		int bint =Integer.parseInt(pageIndex);
		System.out.println(bint);
		String sql="";
		System.out.println(Integer.parseInt(issubmint));
		List<td_payment> list2 =new ArrayList<>();
		if(Integer.parseInt(issubmint) == 1) {
		 sql ="select DISTINCT issubmint, paymentid,submittime from td_payment where issubmint = "+issubmint+" and ispayment =0 and userid =(select Nid from td_user where user1 = '"+user+"' ) limit "+aint*(bint-1)+","+aint+"";
		 String sql2 ="select count(DISTINCT issubmint, paymentid,submittime) AS pageAll from td_payment where issubmint = "+issubmint+" and ispayment =0 and userid =(select Nid from td_user where user1 = '"+user+"' )";
		 System.out.println(sql2);
		 String[] params2 = {"pageAll"};
		 String[] params = {"issubmint","submittime","paymentid"};
		 System.out.println(sql);
			List<Map<String, String>> list =new ArrayList<>();	
			List<Map<String, String>> listpage =new ArrayList<>();
			try {
				 list = mysqlUtil.show(sql, params);
				 listpage = mysqlUtil.show(sql2, params2);
			     for (int i = 0; i < list.size(); i++) {
					td_payment payment =new td_payment();
					payment.setIssubmint(list.get(i).get("issubmint"));
					payment.setPaymentid(list.get(i).get("paymentid"));
					payment.setTime(list.get(i).get("submittime"));
					payment.setPageAll(listpage.get(0).get("pageAll"));
					list2.add(payment);
			     }
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("用户："+user+",sql:"+sql+",sql2:"+sql2);
			}
		}else {
	    sql ="select * from td_payment where issubmint = "+issubmint+" and ispayment =0 and userid =(select Nid from td_user where user1 = '"+user+"' ) limit "+aint*(bint-1)+","+aint+"";	
		System.out.println(sql);
		String sql2 ="select count(*) AS pageAll from td_payment where issubmint = "+issubmint+" and ispayment =0 and userid =(select Nid from td_user where user1 = '"+user+"' )";
		System.out.println(sql2);
		String[] params2 = {"pageAll"};
		String[] params = {"Nid","book_name","book_price","book_number","submittime","ispayment","issubmint","submittime","paymentid"};
		List<Map<String, String>> list =new ArrayList<>();	 
		List<Map<String, String>> listpage =new ArrayList<>();	
		try {
			 list = mysqlUtil.show(sql, params);
			 listpage = mysqlUtil.show(sql2, params2);
		     for (int i = 0; i < list.size(); i++) {
				td_payment payment =new td_payment();
				payment.setNid(list.get(i).get("Nid"));
				payment.setBook_name(list.get(i).get("book_name"));
				payment.setBook_price(list.get(i).get("book_price"));
				payment.setBook_number(list.get(i).get("book_number"));
				payment.setTime(list.get(i).get("submittime"));
				payment.setIspayment(list.get(i).get("ispayment"));
				payment.setIssubmint(list.get(i).get("issubmint"));
				payment.setPaymentid(list.get(i).get("paymentid"));
				payment.setTime(list.get(i).get("submittime"));
				list2.add(payment);
				payment.setPageAll(listpage.get(0).get("pageAll"));
		     }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("用户："+user+",sql:"+sql+",sql2:"+sql2);
		}
		
		}
		return list2; 
		}
	}
	public List<td_payment> select_two(String issubmint,String user,String paymentid) {	
		System.out.println(",user:"+user+"issubmint:"+issubmint+",paymentid:"+paymentid);
		if (issubmint ==null ||issubmint.equals("")&&user ==null ||user.equals("")&&paymentid ==null||paymentid.equals("") ) {
			System.out.println(",user:"+user+"issubmint:"+issubmint+",paymentid:"+paymentid);
			List<td_payment> list2 =new ArrayList<>();
			return list2;
		}else {		
		String sql ="select * from td_payment where issubmint = "+issubmint+" and ispayment =0 and paymentid ="+paymentid+" and userid =(select Nid from td_user where user1 = '"+user+"' ) limit 0,10";
		System.out.println(sql);
		String[] params = {"Nid","book_name","book_price","book_number","submittime","ispayment","issubmint","submittime","paymentid"};
		List<Map<String, String>> list =new ArrayList<>();
		 @SuppressWarnings("rawtypes")
		 List<td_payment> list2 =new ArrayList<>();
		try {
			 list = mysqlUtil.show(sql, params);		
		     for (int i = 0; i < list.size(); i++) {
				td_payment payment =new td_payment();
				payment.setNid(list.get(i).get("Nid"));
				payment.setBook_name(list.get(i).get("book_name"));
				payment.setBook_price(list.get(i).get("book_price"));
				payment.setBook_number(list.get(i).get("book_number"));
				payment.setTime(list.get(i).get("submittime"));
				payment.setIspayment(list.get(i).get("ispayment"));
				payment.setIssubmint(list.get(i).get("issubmint"));
				payment.setPaymentid(list.get(i).get("paymentid"));
				payment.setTime(list.get(i).get("submittime"));
				list2.add(payment);
		     }
		     
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("用户："+user+",sql:"+sql);
		}
		return list2;
		}   
	}
	public List<td_payment> select_four(String issubmint,String user) {
		System.out.println(",user:"+user+"issubmint:"+issubmint);
		if (issubmint ==null ||issubmint.equals("")&&user ==null ||user.equals("")) {
			System.out.println(",user:"+user+"issubmint:"+issubmint);
			List<td_payment> list2 =new ArrayList<>();
			return list2;
		}else {		
		String sql="";
		System.out.println(Integer.parseInt(issubmint));
		List<td_payment> list2 =new ArrayList<>();
		if(Integer.parseInt(issubmint) == 1) {
		 sql ="select DISTINCT issubmint, paymentid,submittime from td_payment where issubmint = "+issubmint+" and ispayment =0 and userid =(select Nid from td_user where user1 = '"+user+"' ) limit 0,10";
		 String sql2 ="select count(DISTINCT issubmint, paymentid,submittime) AS pageAll from td_payment where issubmint = "+issubmint+" and ispayment =0 and userid =(select Nid from td_user where user1 = '"+user+"' ) limit 0,10";
		
		 String[] params2 = {"pageAll"};
		 String[] params = {"issubmint","submittime","paymentid"};
		 System.out.println(sql);
		 System.out.println(sql2);
			List<Map<String, String>> list =new ArrayList<>();
			List<Map<String, String>> listpage =new ArrayList<>();
			try {
				 list = mysqlUtil.show(sql, params);
				 listpage = mysqlUtil.show(sql2, params2);
			     for (int i = 0; i < list.size(); i++) {
			      td_payment payment =new td_payment();
					payment.setIssubmint(list.get(i).get("issubmint"));
					payment.setPaymentid(list.get(i).get("paymentid"));
					payment.setTime(list.get(i).get("submittime"));
					payment.setPageAll(listpage.get(0).get("pageAll"));
					list2.add(payment);
			     }
			   
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("用户："+user+",sql:"+sql+",sql2:"+sql2);
			}
		}else {
	    sql ="select * from td_payment where issubmint = "+issubmint+" and ispayment =0 and userid =(select Nid from td_user where user1 = '"+user+"' )limit 0,10";	 
		System.out.println(sql);
		String sql2 ="select count(*) AS pageAll from td_payment where issubmint = "+issubmint+" and ispayment =0 and userid =(select Nid from td_user where user1 = '"+user+"' )";
		 System.out.println(sql2);
		String[] params2 = {"pageAll"};
		String[] params = {"Nid","book_name","book_price","book_number","submittime","ispayment","issubmint","submittime","paymentid"};
		List<Map<String, String>> list =new ArrayList<>();	
		List<Map<String, String>> listpage =new ArrayList<>();
		try {
			 list = mysqlUtil.show(sql, params);
			 listpage = mysqlUtil.show(sql2, params2);
		     for (int i = 0; i < list.size(); i++) {
				td_payment payment =new td_payment();				
				payment.setNid(list.get(i).get("Nid"));
				payment.setBook_name(list.get(i).get("book_name"));
				payment.setBook_price(list.get(i).get("book_price"));
				payment.setBook_number(list.get(i).get("book_number"));
				payment.setTime(list.get(i).get("submittime"));
				payment.setIspayment(list.get(i).get("ispayment"));
				payment.setIssubmint(list.get(i).get("issubmint"));
				payment.setPaymentid(list.get(i).get("paymentid"));
				payment.setTime(list.get(i).get("submittime"));
				payment.setPageAll(listpage.get(0).get("pageAll"));
				list2.add(payment);
		     }
		    ;
		     
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("用户："+user+",sql:"+sql+",sql2:"+sql2);
		}
		
		}
		return list2;
		
		}  
		
	   
	}
}
