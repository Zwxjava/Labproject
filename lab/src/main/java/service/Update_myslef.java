package main.java.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.mysql.mysqlUtil;
import main.java.utils.DateFormatUtil;

public class Update_myslef {
	//修改是否购买的状态。
	public boolean Update_myslef(String id) {
		System.out.println(id);
		String sql ="update td_payment set ispayment =1 where Nid ="+id;
		System.out.println(sql);
		try {
			int r =mysqlUtil.update(sql);
			if (r==1) {
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("id："+id+",sql:"+sql);
			return false;
		}
		
		
	}
	//添加订单的时间并且提交。
	public boolean Update_mysleftwo(String id,long date) {
		System.out.println("id:"+id+",date:"+date);
		String time =DateFormatUtil.dateformat();
		
		String sql ="update td_payment set issubmint = 1  where Nid ="+id;
		String sql2 ="update td_payment set submittime ='"+time+"' where Nid ="+id;
		String sql3 ="update td_payment set paymentid ='"+date+"' where Nid ="+id;
		System.out.println(sql);
		System.out.println(sql2);
		System.out.println(sql3);
		try {
			int r =mysqlUtil.update(sql);
		    r =mysqlUtil.update(sql2);
		    r =mysqlUtil.update(sql3);
		if (r==1) {
			return true;
		}else{
			return false;
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("id："+id+",date:"+date+",sql:"+sql+",sql2"+sql2+",sql3"+sql3);
			return false;
		}
		
	}
	//修改取消订单的状态
    public boolean Update_myslefthree(String id) {
    	
		String sql ="update td_payment set issubmint =2  where paymentid ="+id;
		System.out.println(sql);
		try {
			int r =mysqlUtil.update(sql);
			if (r==1) {
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("id："+id+",sql:"+sql);
			return false;
		}
		
	}

}
