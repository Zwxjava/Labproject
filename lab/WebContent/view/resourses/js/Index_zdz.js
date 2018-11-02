/**
 * 赵大众
 * 
 */

function displayBlo(){
	$("#position_1111").css("display","block");
}
function displayNo(){
	$("#position_1111").css("display","none");
}
function scrollNow(id){
	$("html,body").animate({
		scrollTop:$("#"+id).offset().top-120
	},1000
	);
}
function jia(id,num){
	var temp = parseInt($("#"+id).next().val());
	if(temp<=(num-1)){
		temp += 1;
		$("#"+id).next().val(temp);
	}else{
		
	}
}
function jian(id){
	var temp = parseInt($("#"+id).prev().val());
	if(temp>=2){
		temp -= 1;
		$("#"+id).prev().val(temp);
	}else{
		
	}
}
function sellwellbuy(id){
	
	
	var mes = confirm("确定购买吗");
	if(mes == true){
		alert("成功");
		var num = id.split("_")[1];
		$(".buy_num").prop("disabled",false);
		$("#form1_"+num).submit();
	}else if(mes == false){
		
	}
}
function newbuy(id){
	
	
	var mes = confirm("确定购买吗");
	if(mes == true){
		alert("成功");
		var num = id.split("_")[1];
		$(".buy_num").prop("disabled",false);
		$("#form2_"+num).submit();
	}else if(mes == false){
		
	}
}
function booksbuy(id){
	
	
	var mes = confirm("确定购买吗");
	if(mes == true){
		alert("成功");
		var num = id.split("_")[1];
		$(".buy_num").prop("disabled",false);
		$("#form3_"+num).submit();
	}else if(mes == false){
		
	}
}
function backTop(){
	$("html,body").animate({
		scrollTop:$(".logo").offset().top-120
	},1000
	);
}
$(function(){
	$(window).scroll(function(){
	var this_scrollTop = $(this).scrollTop();
	if(this_scrollTop>800 ){
	$(".backTop").css("display","block");
	}else{
		$(".backTop").css("display","none");
	}
	});
});
