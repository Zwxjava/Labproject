<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<link type="text/css" href="/Labproject/view/resourses/css/base/Login2.css" rel="stylesheet" />
<meta http-equiv="utf-8" content="text/html; charset=utf-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
</head>
<body>
<form  action="/Labproject/zhaohuimima" method="post" >
			<!-- <div id="qj" style="width:100%;">
				<div id="wk" style="width:430px;height: 332px;margin-left:40%;margin-top: 10%;background-image:url(/Labproject/view/resourses/imgs/timg.gif);">
					<div id="zh" style="height: 30PX;margin-left:20%;margin-top: 10%;padding-top: 20%;">
						账号：<input type="text" id="text" name="zuser"/>
						<span id ="span_id1" style ="color:red"></span>
					</div>
					<div id="mm" style="height: 30PX;margin-left:20%;">
						密保1：<input type="text"  name="mibao1" />
						<span id ="span_id2" style ="color:red"></span>
					</div>
					<div id="mm" style="height: 30PX;margin-left:20%;">
						密保2：<input type="text"  name="mibao2" />
						<span id ="span_id3" style ="color:red"></span>
					</div>
					<div id="mm" style="height: 30PX;margin-left:20%;">
						密码：<input type="password"  name="zpassword" />
						<span id ="span_id4" style ="color:red"></span>
					</div>
					<div id="mm" style="height: 30PX;margin-left:20%;">
						再次确认：<input type="password"  name="rezpassword" />
						<span id ="span_id5" style ="color:red"></span>
					</div>
					<div id="dl" style="height: 30PX;margin-botton:20px;text-align: center;">
						<input type="submit"  id ="input_id_3" name="input_name_3" value="确认" />
					</div>		
				</div>
			</div> -->
			<div class ="top">
	 <div class ="top_title">
	 <div class ="top_title_one">
	 	<div class="userinfo">
	 		欢迎您，请找回您的账号！
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
                              <p> 
                              	                    
                           <input type="submit"  id ="input_id_3" name="input_name_3" class="button-box" value="确认" />
                                </p>
                          </div>
                                <div class="login-form-warp">
                                <p>
                                   账号：<span id ="span_id1" style ="color:red"></span><input type="text" id="text" name="zuser"/>
						
                                </p>
                                <p>
                                   密保 ：<span id ="span_id2" style ="color:red"></span><input type="text"  name="mibao1" />
						
                                </p>
                                <p>
			密保2：<span id ="span_id3" style ="color:red"></span><input type="text"  name="mibao2" />
						
                                </p>
                                <p>
         	密码：<span id ="span_id4" style ="color:red"></span><input type="password"  name="zpassword" />
						</p>
                                <p>
                                再次确认：<span id ="span_id5" style ="color:red"></span><input type="password"  name="rezpassword" />
						</p>
                                
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
<script type="text/javascript">
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
 		 var a = getUrlParam('message1');
 		 var b = getUrlParam('message2');
 		 var c = getUrlParam('message3');
 		 var d = getUrlParam('message4');
 		 var e = getUrlParam('message5');
 	      if(a==1){
 	    	  m ="账号不存在";
 	    	  $("#span_id1").empty().append(m);
 	      }
 	      if(b == 2){
 	    	 m ="密保1不对 ";
	    	  $("#span_id2").empty().append(m); 
 	      }
 	      if(c == 3){
	    	  m ="密保2不对";
	    	  $("#span_id3").empty().append(m);
	      }
 	     if(d == 4){
	    	  m ="两次输入的密码不对";
	    	  $("#span_id4").empty().append(m);
	      }
 	   if(e == 5){
	    	  m ="密码不能为空 ";
	    	  $("#span_id5").empty().append(m);
	      } 
 	 }
      
</script>
</html>