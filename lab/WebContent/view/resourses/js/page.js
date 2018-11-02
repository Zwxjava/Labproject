/**
 * 分页插件
 * 需要传每页的条数。
 * 初始调用初始函数。chushi();
 * pageview(num,1)这个需要更改servlrt路径
 * 周文先 河北大学工商学院；
 * 支持jsP：刷新格式
 */
var before;//记录点击ID，为上一页下一页准备
var pagefor =1 ;//初始化分页显示
var ddi;//下一页控制流程
var bbi;//上一页控制流程
var eei;//下一页判断
var hl ="";//生成页码等页面
hl+='<div id ="shou" class ="box" name ="box" val ="1">首页</div>';
hl+='<div id ="shang" class ="box" name ="box"  val ="2">上一页</div>';
hl+='<div id ="pagema">';

hl+='</div>';         
hl+='<div id ="mo" class ="box" name ="box" val ="4">末页</div>';
hl+='<div id ="xia" class ="box" name ="box"  val ="3">下一页</div>';        
hl+='<div  class ="dbox">行数:<div id ="title" class ="xbox"></div></div>';  
hl+='<div  class ="dbox">页数:<div id ="size" class ="xbox"></div></div>';
hl+='<div id ="tiaozhuan" val ="5" class ="ebox" ><input type ="button" class ="input_box"  value ="跳页:" onclick ="pagetiao()"/><input type ="text" style ="width:50px;" id ="input_one"/></div>';  
//初始化
function chushi(pageSize,pageIndex,pageAll){
	//pageSize 每页显示的行数
	//pageindex 当前页 
	//pageAll 总行数 
	//跳页
	pagefor = pageIndex;
	$("#div").empty().append(hl);
    //pageview(num,1);
	$("#title").empty().append(pageAll);
	var x =parseFloat(pageAll);
	var y =parseFloat(pageSize);
	var page =Math.ceil(x/y);
	$("#size").empty().append(page);
    gopage(pagefor);   
        }
//跳页
function pagetiao(){
var a =$("div.box");  	
var va = $("#input_one").val();
var re =/^[1-9]*$/g;//判断输入的是否是纯文字
 if(!re.test(va)){
	 alert("输入格式错误")
	 return;
	 }
  pagefor = parseInt(va);
if(va>parseInt($("#size").text())){
	alert("超出最大页，请重试");
	return;
}else if (va<1){
	alert("超出最小页，请重试");
	return;
}else{
	goPage(pagefor);
	loadpage(pagefor);
}
}     
        //显示页面
		function gopage(aaa){			
	    	 var html2="";
	    	 if(parseInt($("#size").text())<5){
	    		 for(var i =0;i<parseInt($("#size").text());i++){
			    		var sum = parseInt(i)+1;
			    		html2+='<div id="'+sum+'" name ="box"  class ="box">'+sum+'</div>';	    		
			    	}
			    	$("#pagema").empty().append(html2);
			    	$("#shang").hide();
			    	$("#xia").hide();
			    	$("#mo").hide();
			    	$("#shou").hide();
			    	loadpage(parseInt(aaa));
	    	 }else{
	    		 for(var i =0;i<5;i++){
			    		var sum = parseInt(i)+1;			    		
			    		html2+='<div id="'+sum+'" name ="box"  class ="box">'+sum+'</div>';	    		
			    	 }
			    	$("#pagema").empty().append(html2);
			    	loadpage(parseInt(aaa));
	    	 }	    	 
		var a =$("[name='box']");	
		//var b =$("div.sbox");	
	    a.click(function(){
	    	if(parseInt($("#size").text())<5){
	    		$("#3").text(3);				
				$("#4").text(4);				
				$("#2").text(2);
				$("#1").text(1);
				before = $(this).text();					
				pagefor =parseInt(before);
				goPage(pagefor);
	    	}else{
	    	    if($(this).attr("val") == 1){
	    	    	pagefor = 1;
	    	    	//pageview(num,pagefor); 输出页码
					console.log(pagefor);
					goPage(pagefor);
					a.attr("class","box");	    	    	
	    	    	$("#1").attr("class","bbox");
	    	    	$("#3").text(3);
					$("#5").text(5);
					$("#4").text(4);				
					$("#2").text(2);
					$("#1").text(1);
	    	    }else if($(this).attr("val") == 4){
	    	    	pagefor = parseInt($("#size").text());
	    	    	//pageview(num,pagefor); 输出页码
					console.log(pagefor);
					goPage(pagefor);
					a.attr("class","box");	    	    	
	    	    	$("#5").attr("class","bbox");
	    	    	$("#3").text(parseInt($("#size").text())-2);
					$("#5").text($("#size").text());
					$("#4").text(parseInt($("#size").text())-1);				
					$("#2").text(parseInt($("#size").text())-3);
					$("#1").text(parseInt($("#size").text())-4);
	    	    }else if($(this).attr("val") == 5){	 	    	    	
	    	    }else if($(this).attr("val") == 2){
	    	    	if(pagefor<=1){
	    	    		pagefor == 1;
	    	    	}else{
	    	    		pagefor = parseInt( pagefor) - 1;
	    	    	}
	    	    	goPage(pagefor);
	    	    	loadpage(parseInt(pagefor)); 	
	    	    }
	    	    else if($(this).attr("val") == 3){		    	    	
	    	    	if(pagefor == parseInt($("#size").text())){
	    	    		pagefor = parseInt($("#size").text());
	    	    	}else{
	    	    		pagefor = parseInt( pagefor) + 1;
	    	    	}
	    	    	goPage(pagefor);
	    	    	loadpage(parseInt(pagefor));
	    	    }
	    	    else{
	    	    	before = $(this).text();					
					pagefor =parseInt(before);
					goPage(pagefor);
					loadpage(parseInt(pagefor));
	    	    }  }
		});   
	   }  
	 function loadpage(pagefor){
		 var a =$("[name='box']");	
		 if(pagefor <= 3 ){
				$("#3").text(3);
				$("#5").text(5);
				$("#4").text(4);				
				$("#2").text(2);
				$("#1").text(1);						
				a.attr("class","box");
				$("#"+pagefor+"").attr("class","bbox");						
			}else if(pagefor == parseInt($("#size").text())-2){		    	    			    	    		
	    		$("#4").text(pagefor);
				$("#3").text(pagefor-1);
				$("#2").text(pagefor-2);				
				$("#1").text(pagefor-3);
				$("#5").text(pagefor + 1);
				a.attr("class","box");	    	    	
 	    	$("#4").attr("class","bbox");	    	    	
	    	}else if(pagefor == parseInt($("#size").text())-1){
	    		$("#4").text(parseInt($("#size").text())-1);
				$("#3").text(parseInt($("#size").text())-2);
				$("#2").text(parseInt($("#size").text())-3);				
				$("#1").text(parseInt($("#size").text())-4);
				$("#5").text(parseInt($("#size").text()));
				a.attr("class","box");	    	    	
 	    	$("#4").attr("class","bbox");			    	    	
	    	}else if(pagefor == parseInt($("#size").text())){
	    		$("#4").text(parseInt($("#size").text())-1);
				$("#3").text(parseInt($("#size").text())-2);
				$("#2").text(parseInt($("#size").text())-3);				
				$("#1").text(parseInt($("#size").text())-4);
				$("#5").text(parseInt($("#size").text()));
				a.attr("class","box");	    	    	
 	    	$("#5").attr("class","bbox");			    	    	
	    	}
	    	else{
	    		$("#4").text(pagefor+1);
				$("#3").text(pagefor);
				$("#2").text(pagefor-1);				
				$("#1").text(pagefor-2);
				$("#5").text(pagefor+2);
				a.attr("class","box");	    	    	
 	    	$("#3").attr("class","bbox");		    	    	
 	}
	 }
	