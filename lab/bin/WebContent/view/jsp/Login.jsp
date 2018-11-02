<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<link type="text/css" href="/Labproject/view/resourses/css/base/Login.css" rel="stylesheet" />
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<base href="<%=basePath%>">
<title>Insert title here</title>

</head>
<body>
 	<form  action="/Labproject/LoginServlet" method="post" >
<!-- 			<div id="qj" style="width:100%;min-height:760px">  -->
<!-- 				<div id="wk" style="width:430px;height: 332px;margin-left:40%;margin-top: 10%;background-image:url(/Labproject/view/resourses/imgs/timg.gif);"> -->
<!-- 					<div id="zh" style="height:30PX;margin-left:20%;margin-top: 10%;padding-top: 20%;"> -->
<!-- 						账号：<input type="text" id="text" name="user"/> -->
<!-- 					</div> -->
<!-- 					<div id="mm" style="height: 30PX;margin-left:20%;"> -->
<!-- 						密码：<input type="password" id="password" name="password" /> -->
<!-- 						<span id ="span_id" style ="color:red"></span> -->
<!-- 					</div> -->
<!-- 	  				<div style="width: 40%;height: 80px; margin-left:30%;">                        -->
<!--             			<input id ="code_id" type="text" name="code" placeholder="请输入验证码">                     -->
<!--          			 <span>		 -->
<!-- 						<img alt="验证码" id="scode" src="/Labproject/ImageServlet" /> -->
<!-- 						<a href="#" onclick="javascript:flushCode();">看不清?</a> -->
<!--           			</span> -->
<!--             	</div> -->
<!-- 					<div id="dl" style="height: 30PX;margin-botton:20px;text-align: center;"> -->
<!-- 						<input type="submit"  id ="input_id_3" name="input_name_3" value="提交" /> -->
<!-- 					</div> -->
<!-- 					<div id="dl" style="height: 30PX;margin-botton:20px;text-align: center;"> -->
<!-- 						<a href="/Labproject/view/jsp/zhuce.jsp">立即注册</a> -->
					
					
<!-- 						<a href="/Labproject/view/jsp/zhaohuimima.jsp">忘记密码</a> -->
<!-- 					</div> -->
						
<!-- 				</div> -->
<!-- 			</div> -->



<div class ="top">
	 <div class ="top_title">
	 <div class ="top_title_one">
	 	<div class="userinfo">
	 		欢迎您，请登录您的账号！
	 	</div>
	 </div>
	 </div>
	 <div class ="top_main">
	 	<div class="main_log">
	 		<div class="log">
	 			<h1 class="log_img">
	 			
	 			<a href ="/Labproject/view/jsp/Login.jsp" title ="青城博雅图书网"><img src="/Labproject/view/resourses/imgs/uugai.com_1536197769405.png"/></a> 
	 			</h1>
	 		</div>
	 	</div>
	 </div>
	</div>
	
	<div style="margin: 0;min-height: 400px;"> 
	<div class="login-banner">
		<div class="login-main">
			<div class="login-one">
				<div class="login_con">
					<div class="login_form">
						<div class="login-form-title"> 
                                登录平台</div>
                                <div class="login-form-warp">
                                <p>
                                    <input name="user" type="text" id="txtuserno" placeholder="请输入账号">
                                </p>
                                <p>
                                    <input id="txtpas1" type ="password" name="password" autocomplete="off" maxlength="24"  placeholder="请输入密码" style="color: rgb(163, 163, 163);">
                                   
                                </p>
                                <p>
                                  
                                    <input name="code" type="text" id="txtcode" placeholder="请输入验证码" style="width: 70px; color: rgb(163, 163, 163);">
                                    <img src="/Labproject/ImageServlet" alt="验证码" title="点击刷新" id="scode" style ="display: inline-block;vertical-align: top;" height="35" width="80" onclick="javascript:flushCode()">
                                  
                                </p>
                                <p>
                                    <input type="submit" name="btnlog" value="" id="btnlog" class="button-box">
                                </p>
                                <p>
                                    <a href="/Labproject/view/jsp/zhaohuimima.jsp" class="J_findPwd">忘记密码&nbsp; </a>
                                    <img src="" style="margin-top:3px;">
                                    <a href="/Labproject/view/jsp/zhuce.jsp">&nbsp; 立即注册</a>
                                    <font color="red"> 
                                        <span id ="span_id" style ="color:red"></span></font></p>
                            </div>
					
					</div>
						<div class="bg_bar">
                        </div>
				</div>
			</div>
		</div>
		
	 </div>	
		
	</div>
	
	<div class="under">
		<div class="under_one">
			<h2>
				<strong>Copyright 2018 青城博雅 All Rights ReservedICP备051231231号</strong>
			</h2>
		</div>
	</div>
	
	</form> 


</body>
<script>
     $(
    		 fale()
    		 
     );
     function flushCode() {
 	    // 每次刷新的时候获取当前时间，防止浏览器缓存刷新失败
 	    var time = new Date();
 	    document.getElementById("scode").src = "/Labproject/ImageServlet?time=" + time;
 	}
     function getUrlParam(name) {
	  var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
	  var r = window.location.search.substr(1).match(reg); //匹配目标参数
	  if (r != null) return unescape(r[2]); return null; //返回参数值
	 }
     function fale(){
		 var m;
		 var a = getUrlParam('message');
	      if(a ==1){
	    	  m ="账号或密码错误";
	    	  $("#span_id").empty().append(m);
	      }else if(a==2){
	    	  m ="验证码错误"
	    	  $("#span_id").empty().append(m);
	      }
	      
	 }
      
</script>
</html>