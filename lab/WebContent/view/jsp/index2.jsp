<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Insert title here</title>
</head>
<body>
<div id="qj" style="width:100%;">
				<div id="wk" style="width:430px;height: 332px;margin-left:40%;margin-top: 10%;background-image:url(/img/timg.gif);">
					<div id="zh" style="font-size:30px;color:#F514D8;height: 30PX;margin-left:20%;margin-top: 10%;padding-top: 20%;">
						恭喜您成功重置密码
					</div>
					<div id="mm" style="height: 30PX;margin-left:30%;">
						
						
					</div>
	  				<div style="width: 40%;height: 30px; margin-left:30%;">                       
            			      
         			
            		</div>
					<div id="dl" style="height: 30PX; margin-botton:20px;text-align: center;">
							 <a href="/Labproject/view/jsp/Login.jsp" style="color:#F514D8" >登陆</a> 
					</div>
					<div id="dl" style="height: 30PX; margin-botton:20px;text-align: center;">
						<a href="/Labproject/view/jsp/zhuce.jsp" style="color:#F514D8">重新注册</a>
					</div>		
				</div>
			</div>
</body>
</html>