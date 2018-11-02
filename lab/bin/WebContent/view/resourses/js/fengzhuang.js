var a ;

function showbtn(data){
	

	$("#table_box").empty();
	
	for(var t=(parseInt($("#currentpage").val())-1)*5;t<parseInt($("#currentpage").val())*5;t++){
		var html = '<form method="get" action="/Labproject/mid" style="margin-top:10px;"><tr style="width:150%"><td><div id="'+data.shuzu[t][0]+'" class="delbook" style="width:150px;float:left;margin-left:20px;">' 
		+data.shuzu[t][1]+'</div></td>'
		 +'<td>'
		      +'<div id="update_div'+data.shuzu[t][0]+'" style="visibility:visiable;float:left;">' 
		           +'图书价格：<input type="text" name="update_book_price" id="update_book_price" value="'+data.shuzu[t][3]+'"  style="width:100px;margin-right:10px;"/>' 
			       +'图书数量：<input type="text" name="update_book_number" id="update_book_number" value="'+data.shuzu[t][2]+'" style="width:100px; margin-right:10px;"/>' 
			        +'<input type="hidden" name="update_book_id" id="update_book_id" value="'+data.shuzu[t][0]+'"/>' 
			  +'</div>'
		+'</td>'
		+'<td><input type="button" id="'+data.shuzu[t][0]+'" name="update_button" class="update_button" value="显式信息" style=" margin-right:10px;"/></td>' 
		+'<td><input type="submit" id="'+data.shuzu[t][0]+'" class="delbookbutton" value="更改"/></td>'
		+'</tr></form>';
		if(data.shuzu[t][0]!=10000){
			$("#table_box").append(html);}
	}
}

function jiazai(x,total,per){
	a = x;
	
	$("#gl_update").append(
			'<div id="main_box">'
		    +'</div>');
	$("#pages_box").empty();
	$("#main_box").empty();
	$("#main_box").append(
			'<div id="content_box" >'
			+'<table id="table_box" >'
			+'	<tr><td></td><td></td></tr>'
			+'</table>'
			+'</div>'
			+'<div id="pages_box" >'
			+'</div>'	
		);
	$("#pages_box").append(
			'<div id="div_btn_box">'
			+'<input type="button" id="pre_page" value="上一页" style="float:left;margin-right:10px;"/>'
			+'<input type="button" id="first_page" value="首页" style="float:left;margin-right:10px;"/>'
			
			+'<div id="add_btn" style="float:left;margin-right:10px;">'
			+'</div>'
			+'<input type="button" id="last_page" value="尾页" style="float:left;margin-right:10px;" />'
			+'<input type="button" id="back_page" value="下一页" style="float:left;margin-right:10px;" />'
			+'<input type="text" id="jump_text" value="" style="width:30px;margin-right:10px;" >'
			+'<input type="button" id="jump_botton" value="跳转" onclick="jumppage()" style="float:left;margin-right:10px;" >'
			+'总页数：<input type="text" id="totalpage" value="" style="width:30px;" >'
			+'当前页:<input type="text" id="currentpage" style="width:30px;" value="1" style="float:left"/>'
		    +'</div>'
	);
	   $("#totalpage").attr('value',total);
		 if(total<=5){
     	    for(var i = 0;i<total;i++){
     	    	$("#add_btn").append(
     	    		'<input type="button" id="'+(i+1)+'" value="'+(i+1)+'" class="select_btn"/>	'
     	    	);
     	    }
     		}else{
     			for(var i = 0;i<5;i++){
	        	    	$("#add_btn").append(
	        	    		'<input type="button" id="'+(i+1)+'" value="'+(i+1)+'" class="select_btn"/>	'
	        	    	);
	        	    }
     		}
		 //初始化第一页
		 
		 $("#table_box").empty();
			for(var t=0;t<5;t++){
				if(x.shuzu[t][0]!=10000){
					
	    			$("#table_box").append('<form method="get" action="/Labproject/mid" style="margin-top:10px;"><tr style="width:150%"><td><div id="'+data.shuzu[t][0]+'" class="delbook" style="width:150px;float:left;margin-left:20px;">' 
	    					+data.shuzu[t][1]+'</div></td>'
	    					 +'<td>'
	    					      +'<div id="update_div'+data.shuzu[t][0]+'" style="visibility:visiable;float:left;">' 
	    					           +'图书价格：<input type="text" name="update_book_price" id="update_book_price" value="'+data.shuzu[t][3]+'"  style="width:100px;margin-right:10px;"/>' 
	    						       +'图书数量：<input type="text" name="update_book_number" id="update_book_number" value="'+data.shuzu[t][2]+'" style="width:100px; margin-right:10px;"/>' 
	    						        +'<input type="hidden" name="update_book_id" id="update_book_id" value="'+data.shuzu[t][0]+'"/>' 
	    						  +'</div>'
	    					+'</td>'
	    					+'<td><input type="button" id="'+data.shuzu[t][0]+'" name="update_button" class="update_button" value="显式信息" style=" margin-right:10px;"/></td>' 
	    					+'<td><input type="submit" id="'+data.shuzu[t][0]+'" class="delbookbutton" value="更改"/></td>'
	    					+'</tr></form>');}
			}
			
		//给每个页码btn添加点击事件，当点击该按钮时，调用showtrs（）方法中的showbtn（）加载相应的数据到页面上
		 showtrs(x);
		 
		 //前一页的点击事件
			   $("#pre_page").click(function(){			  	   			 
				   var current = $("#currentpage").val();
				    if(parseInt(current)==1){alert('亲，已经是第一页了')};
				    if(parseInt(current)>1){
				    var beforepage = parseInt(current)-1;
				    $("#currentpage").attr('value',beforepage);
				    showbtn(a);
						if(parseInt($("#3").val())!=3){
						 for(var j =1;j<=5;j++){
				 				$("#"+j).attr('value',parseInt($("#"+j).val())-1);
				 		 }
						}
				    }
			   });			  			  				  				  	
	
		//后一页的点击事件		
			   $("#back_page").click(function(){			  	   			 
					var current = $("#currentpage").val();
				    var afterpage = parseInt(current)+1;
				    if(parseInt(current)==parseInt($("#totalpage").val())){alert('已经是最后一页了')};
				    if(parseInt(current)<parseInt($("#totalpage").val())){
				    $("#currentpage").attr('value',afterpage);
				    showbtn(a);
						 if(parseInt($("#3").val())!=(parseInt($("#totalpage").val())-2)){
						 for(var j =1;j<=5;j++){
				 				$("#"+j).attr('value',parseInt($("#"+j).val())+1);
				 				}
						 }
				    }	 
			   });		
			   
			//首页加载事件   
			   
			   $("#first_page").click(function(){
				   
				   $("#currentpage").attr('value',1);
					showbtn(a);
					$("#1").attr('value',1);
				    $("#2").attr('value',2);
				    $("#3").attr('value',3);
				    $("#4").attr('value',4);
				    $("#5").attr('value',5);
			   });	
	
			 //尾页加载事件  
			  
			   $("#last_page").click(function(){
				   
				   $("#currentpage").attr('value',parseInt($("#totalpage").val()));
					showbtn(a);
					$("#1").attr('value',(parseInt($("#totalpage").val())-4));
				    $("#2").attr('value',(parseInt($("#totalpage").val())-3));
				    $("#3").attr('value',(parseInt($("#totalpage").val())-2));
				    $("#4").attr('value',(parseInt($("#totalpage").val())-1));
				    $("#5").attr('value',(parseInt($("#totalpage").val())));
			   });	
			   	
			   //跳转事件
			   
			   $("#jump_botton").click(function(){
				   var jump_text = $("#jump_text").val();
				   if( parseInt(jump_text)<= parseInt($("#totalpage").val()) && parseInt(jump_text)>=1){
				    	if(parseInt(jump_text)<=(parseInt($("#totalpage").val())-2)&&parseInt(jump_text)>=3){
						    $("#currentpage").attr('value',jump_text);
						    showbtn(a);
						    $("#1").attr('value',parseInt(jump_text)-2);
						    $("#2").attr('value',parseInt(jump_text)-1);
						    $("#3").attr('value',jump_text);
						    $("#4").attr('value',parseInt(jump_text)+1);
						    $("#5").attr('value',parseInt(jump_text)+2);
				    	}
				    	if(parseInt(jump_text)==(parseInt($("#totalpage").val())-1)||parseInt(jump_text)==(parseInt($("#totalpage").val()))){
				    		$("#currentpage").attr('value',jump_text);
				    		showbtn(a);
				    		$("#1").attr('value',(parseInt($("#totalpage").val())-4));
						    $("#2").attr('value',(parseInt($("#totalpage").val())-3));
						    $("#3").attr('value',(parseInt($("#totalpage").val())-2));
						    $("#4").attr('value',(parseInt($("#totalpage").val())-1));
						    $("#5").attr('value',(parseInt($("#totalpage").val())));
				    		}
				    	if(parseInt(jump_text)==1||parseInt(jump_text)==2){
				    		$("#currentpage").attr('value',jump_text);
				    		showbtn(a);
				    		$("#1").attr('value',1);
						    $("#2").attr('value',2);
						    $("#3").attr('value',3);
						    $("#4").attr('value',4);
						    $("#5").attr('value',5);
				    		}
				  
				   }
					   else{
						alert('超出页数范围');   
					   }
			   });	
}


//给每个btn添加点击事件，动态改变btn的值
function showtrs(x){
    	
		var btnclass = $(".select_btn");
		 for(var i=0;i < btnclass.length;i++){
			 btnclass[i].onclick=function(){
			$("#currentpage").attr('value',this.value);
			showbtn(x);
				if(this.id>3&&this.value<=(parseInt($("#totalpage").val())-2)){
		    		$("#3").attr('value',this.value);
		    		for(var j =1;j<=5;j++){
		    			if(j!=3){
		    				$("#"+j).attr('value',parseInt($("#"+j).val())+parseInt(this.id)-3);
		    			}
		    		}
		    	}
				 
		    	if(this.id<3&&parseInt($("#3").val())>3&&this.value>=3){
		    		$("#3").attr('value',this.value);
		    		for(var j =1;j<=5;j++){
		    			if(j!=3){
		    				$("#"+j).attr('value',parseInt($("#"+j).val())-(3-parseInt(this.id)));
		    			}
		    		}
		    	}
		 	}
		}
	 }

