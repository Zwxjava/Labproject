<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="main.java.entiy.td_type"%>
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
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>后台界面</title>
</head>
<body >

	<div id="gl_foot"><b>后台管理系统<b></div>	
	
	<div id="gl_mid">
	
		<div id="gl_nav" >
			<div id="gl_nav_1" ><b>增加</b></div>
			<div id="gl_nav_2" onclick="show_update()"><b>修改</b></div>
			<div id="gl_nav_3" onclick="show_del()"><b>删除</b></div>
			<!-- 向数据库中添加数据 -->
			<div id="gl_add" >
				 <div style="width:140px;margin-left:10px;">
				 	请选择添加操作:
				 	
				 
				 </div>
				<select id="select_add" name="select_add" style="float:left;margin-left:20px;">
					<option value="0" >请选择</option>
					<option value="1" >添加类别</option>
					<option value="2" >添加图书</option>				
				</select></br>
				
				<!-- 添加图书类别div --> 
				<div id="gl_add_type" style="width:80%;height:500px;background-color:#F6F6F6;margin-left:10%; margin-top:50px; display:none;" >
					 </br>
					 <form method="post" action="/Labproject/ht_insert_newbook"  >
					 	请输入图书类别: <input type="text" name="add_type_input" />
					 				<input type="submit" name="add_type_submit" value="提交"  style="margin-left:100px;"/><br/>	<h1>${message}</h1>
					 </form>
					 
				</div>
				
				<div id="gl_add_book" style="width:80%;height:600px;background-color:#F6F6F6;margin-left:10%; display:none;" >
					</br>
					请选择图书类别：<select id="select_add_books" name="select_add_books">
									<option value="0">请选择类别</option>
								<% ArrayList<td_type> list = (ArrayList)request.getAttribute("list2");%> 
							  	 <% for(int i = 0;i<list.size();i++){ %> 
									<option value="<%=list.get(i).getId()%>"><%=list.get(i).getType()%></option> 
								 <% }%>    	
								 </select></br></br>
								 
							 <form method="post" action="/Labproject/ht_insert_newbook">	 
					 	请输入图书名称：<input type="text" name="add_book_name" id="add_book_name" value=""/></br></br>
					 	请输入图书价格：<input type="text" name="add_book_price"  id="add_book_price" /></br></br>
					 	请输入图书数量：<input type="text" name="add_book_number"  id="add_book_number"/></br></br>
					 	           <input type="hidden" name="add_book_select"  id="add_book_select"/>
					 	        
					 	请上传图书封面：<input type="file" name="uploadFile"  id="uploadFile" onchange="selectImage(this);" /> </br> 
					 				<input type="hidden" id="imagedata" name="imagedata" class="input tips"  />
					 				<img src="" id="imagedisplay"    style="width:150px;height:150px; position:relative; bottom:200px; float:right; margin-right:80px;"  />
    								<br/><br/>
    								<input type="submit"  id="addbooks"  value="提交" style="float:right" />
    								 <input type="button"  id="addbooks"  value="确认信息" onclick="fuzhi()" style="float:right;margin-right:20px;" />
   									
					 		</form>
				</div>
			
			
			</div>
			
			
			
		</div>
	
	</div>	
	<div id="gl_bottom"><b>Copyright © 2013-2018 <a href="/Labproject/view/jsp/Login.jsp">青城博雅 qcby.com</a>  All Rights Reserved. 备案号：冀ICP备15012807号-1</b></div>



	<script>
	
	function fuzhi(){

		  $("#add_book_select").attr("value",$("#select_add_books").val());
		  alert( '确认图书信息');
		
	}
	

	
	 var image = '';
	    function selectImage(file) {
	        if (!file.files || !file.files[0]) {
	            return;
	        }
	        var reader = new FileReader();
	        reader.onload = function (evt) {
	           // 将图片显示在id为imagedisplay的img
	            document.getElementById('imagedisplay').src = evt.target.result;
	          // alert(evt.target.result);
	            // 将图片的base64数据存在id为imagedata的一个文本框
	            document.getElementById('imagedata').value = evt.target.result.toString();
	        }
	        reader.readAsDataURL(file.files[0]);
	    }
	

	
	 $(document).ready(function(){
	        $("#select_add").change(function(){
	            var item = $(this).val();
	            if(item==1){
	            	$("#gl_add_type").css('display','block');
	            	$("#gl_add_book").css('display','none');
	            }
	            if(item==2){
	            	$("#gl_add_book").css('display','block');
	            	$("#gl_add_type").css('display','none');
	            }
	            
	          
	        });
	    });
		
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
			$("#gl_add").css('display','block');
			$("#gl_update").css('display','none');
			$("#gl_del").css('display','none');
		}
		function show_update(){
			window.location.href="/Labproject/ht_update";
		}
		function show_del(){

			window.location.href="/Labproject/he_del_searchtype";
		}
	</script>
</body>
</html>