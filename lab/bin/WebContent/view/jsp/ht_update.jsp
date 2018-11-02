<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="main.java.entiy.td_type"%>
<%@page import="main.java.entiy.td_book"%>

    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 <base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="/Labproject/view/resourses/css/base/ht.css"/>
<link rel="stylesheet" type="text/css" href="/Labproject/view/resourses/css/base/fengzhuang.css"/>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="/Labproject/view/resourses/js/fengzhuang.js"></script>
<title>后台界面</title>
</head>
<body >
	<div id="gl_foot"><b>后台管理系统<b></div>
	<div id="gl_mid">
		<div id="gl_nav" >
			<div id="gl_nav_1" onclick="show_add()"><b>增加</b></div>
			<div id="gl_nav_2" onclick="show_update()"><b>修改</b></div>
			<div id="gl_nav_3" onclick="show_del()"><b>删除</b></div>

		</div>
		<div id="gl_update" >
			<% String strs= (String)request.getAttribute("outstr");%> 
			<div style="display:none" id="hidden_strs"><%out.println(strs);%></div>
		  <table id="table_ori"style="margin-left:30px;"> 
		  </table>
		
		 
		</div>
		<h2>${updatemessage}</h2>
	</div>
	<div id="gl_bottom"><b>Copyright © 2013-2018 <a href="/Labproject/view/jsp/Login.jsp">青城博雅 qcby.com</a>  All Rights Reserved. 备案号：冀ICP备15012807号-1</b></div>
	<script>
	
	var ss = $("#hidden_strs").text();
	var data = new Function("return "+ss)();
    function zz(){ jiazai(data,Math.floor((data.shuzu.length-1)/5+1),5);}
    zz();
    
	function load(){
		for(var i = 0;i<data.shuzu.length;i++){
			var html = '<form method="get" action="/Labproject/mid" style="width:1000px"><tr style="width:150%"><td><div id="'+data.shuzu[i][0]+'" class="delbook" style="width:150px">' 
	         +data.shuzu[i][1]+'</div></td>'
			 +'<td>'
	               +'<div id="update_div'+data.shuzu[i][0]+'" style="visibility:hidden;">' 
			           +'图书价格：<input type="text" name="update_book_price" id="update_book_price" value="'+data.shuzu[i][3]+'"  style="width:100px;margin-right:10px;"/>' 
				       +'图书数量：<input type="text" name="update_book_number" id="update_book_number" value="'+data.shuzu[i][2]+'" style="width:100px; "/>' 
				        +'<input type="hidden" name="update_book_id" id="update_book_id" value="'+data.shuzu[i][0]+'"/>' 
				  +'</div>'
			+'</td>'
			+'<td><input type="button" id="'+data.shuzu[i][0]+'" name="update_button" class="update_button" value="显式信息"/></td>' 
			+'<td><input type="submit" id="'+data.shuzu[i][0]+'" class="delbookbutton" value="更改"/></td>'
			+'</tr></form>';
			$("#table_ori").append(html);
		}
	}

	//load();
	
 	 var updatebook = $(".update_button");
	 var node=$("#update_div"+this.id);
	 for(var i = 0;i < updatebook.length;i++){
		updatebook[i].onclick=function(){
			if($("#update_div"+this.id).css("visibility")!="hidden"){
				 $("#update_div"+this.id).css("visibility","hidden");
			}else{
				 $("#update_div"+this.id).css("visibility","visible");
				};
			 }
		}
	 
		function show_add(){
			window.location.href="/Labproject/ht_insert_newbook";
		}
		function show_update(){
			$("#gl_update").css('display','block');
			$("#gl_add").css('display','none');
			$("#gl_del").css('display','none');
		}
		function show_del(){
			window.location.href="/Labproject/he_del_searchtype";
		}
	</script>
</body>
</html>