<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="main.java.entiy.td_payment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<link type="text/css" href="/Labproject/view/resourses/css/base/myslef.css" rel="stylesheet" />
<link type="text/css" href="/Labproject/view/resourses/css/base/page1.css" rel="stylesheet" />
<script src="/Labproject/view/resourses/js/page.js"></script>
<title>个人首页</title>
</head>				  
<body>
<div class="top">
			<div class="top_one"><div class="top_one_one">
				<div class="top_one_size"><a>首页</a></div> 					
				<div class="top_one_size">用户:${aString}&nbsp;&nbsp;&nbsp;<span style="font-size: 10px;"><a href ="/Labproject/myslef_select_exit">退出</a></span></div>				
			</div></div>
			<div class="top_two">
			<div class="top_two_img"><img src="/Labproject/view/resourses/imgs/08.png" width ="100%"; height ="80px"/></div>
			<div class="top_two_two">			    
				<div class="top_two_size"><a id ="dingdan" href ="/Labproject/myslef_select_one?name=0">订单首页</a></div>
				<div class="top_two_size"><a id ="lishidingdan" href ="/Labproject/myslef_select_one?name=1">历史订单</a></div>
			</div>
			</div>
		</div>	
		<div class="mid">
			<div class="mid">
			<div class="all"><div style ="margin:auto;width:60%;height:20px;background:white"></div></div>
			<div id ="dingdanid" class ="mid_one">
			<% ArrayList<td_payment> listTd_payments =(ArrayList)request.getAttribute("list");  
			if(listTd_payments.isEmpty()){%>
            <div class="order" rel ="0" id ="input_id_one">暂无订单</div>       	
           <%}else{			                 
            for( int i =0;i<listTd_payments.size();i++ ){
                  if(Integer.parseInt(listTd_payments.get(i).getIssubmint()) == 1){%>			                  
            	<div class="order">
		    	<div class="mid_order">书名:<%= listTd_payments.get(i).getBook_name()%></div>
		   		<div class="mid_order">总价:<%= listTd_payments.get(i).getBook_price()%></div>
		    	<div class="mid_order">数量:<%= listTd_payments.get(i).getBook_number()%>	</div>
		    	<div id ="zongshu_id" sum ="<%=listTd_payments.get(0).getPageAll()%>" style ="display:none"></div>			    	
		  
		</div> 
					<%}else{%>										
					<%}%>
				          <%}%>
				          <% if(Integer.parseInt(listTd_payments.get(0).getIssubmint())==0){ %>
			          
     	<div class="mid_button"><input class ="input_style" rel ="0" id ="input_id_one" name ="input_name_one" type="button" value="提交" onclick="sbuy()"/></div>
			<%}else{%>
			<div class="mid_button"><input class ="input_style" rel ="1" id ="input_id_one" name ="input_name_one" type="button" value="清空" onclick="removesbuy(<%= listTd_payments.get(0).getPaymentid()%>)"/></div>
			<%}%>
				     <%} %>
				      <div class ="mid_page" id ="div" ></div> 
			</div>		    	
			</div>
		</div>
		<div class="under">
			<div class="under_one">
				<div class="under_one_one">
					在线图书城，限时限量，欢迎来购
				广播电视节目制作经营许可证（京）字第01010号		
				</div>
				<div class="under_one_two">
					<img src="/Labproject/view/resourses/imgs/08.png" width="100%" height="120px" />
				</div>
			</div>
			</div>
		
</body>
	<script>
   function removebuy(id){
 	  window.location.href="/Labproject/myslef_update_ispayment?Nid="+id;
   }
   function sbuy(){
 	  window.location.href="/Labproject/myslef_update_issubmit?name=0";
   }
   function removesbuy(paymentid){	     
    window.location.href="/Labproject/myslef_update_isdelete?name=1&paymentid="+paymentid;
	      
   }	      
  	
     </script>
</html>