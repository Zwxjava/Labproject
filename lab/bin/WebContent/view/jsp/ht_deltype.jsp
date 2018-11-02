<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="main.java.entiy.td_type"%>
<%@page import="main.java.entiy.td_book"%>


   <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href="<%=basePath%>"> 
<link rel="stylesheet" type="text/css" href="/Labproject/view/resourses/css/base/ht.css"/>
<link rel="stylesheet" type="text/css" href="/Labproject/view/resourses/css/base/delbook_fenye.css"/>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="/Labproject/view/resourses/js/delbook_fenye.js"></script>
<title>后台界面</title>
</head>
<body >

	<div id="gl_foot"><b>后台管理系统<b></div>
	
	<div id="gl_mid">
	
		<div id="gl_nav" >
			<div id="gl_nav_1" onclick="show_add()"><b>增加</b></div>
			<div id="gl_nav_2" onclick="show_update()"><b>修改</b></div>
			<div id="gl_nav_3" ><b>删除</b></div>
			<!-- 向数据库中添加数据 -->
			
			<div id="gl_del" >
				 <div style="width:140px;margin-left:10px;">
				 	请选择删除操作:
				 </div>
				<select id="select_del" name="select_del" style="margin-left:20px;">
					<option value="0" >请选择</option>
					<option value="1" >删除类别</option>
					<option value="2" >删除图书</option>				
				 </select></br>
			
				<div id="ht_del_type" style="width:80%;height:500px;background-color:#F6F6F6;margin-left:10%; display:none; padding-top:30px;" >
							<% String strtype = (String)request.getAttribute("deltype");%> 
<%-- 			        <%out.println(strtype);%> --%>
			        <div style="display:none" id="hidden_deltype"><%out.println(strtype);%></div>
					<table id="table_type" style="margin-left:30px;"> 
		  			</table>
<%-- 							<% ArrayList<td_type> listdel_type = (ArrayList)request.getAttribute("listdel_type");%>  --%>
<!-- 							<table style="margin-left:40px;margin-top:30px;"> -->
<%-- 								<% for(int i = 0;i<listdel_type.size();i++){ %>  --%>
<%-- 								   <tr><td style="width:400px;"> <div id="div<%=listdel_type.get(i).getId()%> " class="deltype"> --%>
<%-- 								    <%=listdel_type.get(i).getType()%></div><td> --%>
<!-- 								   <form method="get" action="/Labproject/mid_del"> -->
<%-- 								    	<input type="hidden" name="hiddentypevalue" id="hiddentypevalue" value="<%=listdel_type.get(i).getId()%>"/> --%>
<%-- 								    	<td style="width:200px;"><input type="submit" id="input<%=listdel_type.get(i).getId()%>" class="delbutton" value="删除类型" /></td></tr> --%>
<!-- 								   </form> -->
<%-- 								 <% }%>    	 --%>
<!-- 							</table> -->
				
				</div>
				
				<div id="ht_del_book" style="width:80%;height:500px;background-color:#F6F6F6;margin-left:10%; display:block;" >
				     <% String strs= (String)request.getAttribute("delbook");%> 
			        <div style="display:none" id="hidden_delbook"><%out.println(strs);%></div>
					<table id="table_ori"style="margin-left:30px;"> 
		  			</table>

				</div>
				
				
			</div>
			
		</div>
	
	</div>
	
	
	
	<div id="gl_bottom"><b>Copyright © 2013-2018 <a href="/Labproject/view/jsp/Login.jsp">青城博雅 qcby.com</a>   All Rights Reserved. 备案号：冀ICP备15012807号-1</b></div>



	<script>
	
	var ss =$("#hidden_delbook").text();
	var data = new Function("return "+ss)();
	//alert(data.shuzu.length);
    function zz(){ jiazai(data,Math.floor((data.shuzu.length-1)/5+1),5);}
    zz();
	
    function load(){
    	
    	for(var i = 0;i<data.shuzu.length;i++){
    		
    		$("#table_ori").append(
    				'<form method="get" action="/Labproject/mid_del"><tr><td style="width:400px;"> <div id="'+data.shuzu[i][0]+'" class="delbook" style="width:350px;float:left;">'
					    +data.shuzu[i][1]+'</div></td>'
					    +'<input type="hidden" name="hiddenvalue" id="hiddenvalue" value="'+data.shuzu[i][0]+'"/>'	
					    +'<td style="width:200px;"><input type="submit" id="input'+data.shuzu[i][0]+'" class="delbookbutton" value="删除图书" style="float:left" /></td></tr>'
						+'</form>');
    	       } 
    }
    
    
   // load();
    

    
    
	 
    var type = $("#hidden_deltype").text();
 	var datat = new Function("return "+type)();
	//alert(data.shuzu[2][1]);
   //function deltype(){ jiazaitype(datat,Math.floor((datat.shuzu.length-1)/1+1),1);}
     //deltype();
   
   function loadtype(){
		for(var i = 0;i<datat.shuzu.length;i++){
			var htmltype = 
				'<form method="get" action="/Labproject/mid_del" style="margin-left:20px;"> <tr><td style="width:400px;"> <div id="div'+datat.shuzu[i][0]+'" class="deltype" style="width:400px;float:left;"> '
				   +datat.shuzu[i][1]+'</div></td>'
			    	+'<td><input type="hidden" name="hiddentypevalue" id="hiddentypevalue" value="'+datat.shuzu[i][0]+'"/></td>'
			    	+'<td style="width:200px;"><input type="submit" id="input'+datat.shuzu[i][0]+'" class="delbutton" value="删除类型" style="float:left; margin-top:10px;" /></td></tr>'
			  +'</form>' 
			$("#table_type").append(htmltype);
		}
	}
   loadtype();
   
   
   
	
	
	 var delbookbutton =$(".delbookbutton");
	 $(document).ready(function(){
	        $("#select_del").change(function(){
	            var item = $(this).val();
	            if(item==1){
	            	$("#ht_del_type").css('display','block');
	            	$("#ht_del_book").css('display','none');
	            }
	            if(item==2){
	            	$("#ht_del_book").css('display','block');
	            	$("#ht_del_type").css('display','none');
	            }
	            
	          
	        });
	    });
	 
	 
		function show_add(){

			window.location.href="/Labproject/ht_insert_newbook";
		}
		function show_update(){
			window.location.href="/Labproject/ht_update";
		}
		function show_del(){
			$("#gl_del").css('display','block');
			$("#gl_add").css('display','none');
			$("#gl_update").css('display','none');
		}
	</script>
</body>
</html>