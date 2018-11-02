<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%=basePath%>">
		<title>青城博雅在线书城</title>
		<link rel="stylesheet" type="text/css" href="/Labproject/view/resourses/css/base/Index_zdz.css"/>
		<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
	</head>
	<body>
		<div class="top1" id="">
				<div class="qcby" id="">
					<div class="qcby_img1_div" id="">
						<img  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABsAAAAkCAYAAAB4+EEtAAADAElEQVRIie2W60vTYRTHv8tNnbGLl7w7yMmwnJJkXqAwWyWJoWuFFyhSEvJVQf9ALwLrdYGGpC8EL5lmYZMlTUgNvDCs4Wpz1dRlrrU1XZq/NbKft61w++2SSC92Xvx4Luc8n+ec5zzn+dFm9Z9WsUuyZ7dAAVgAtvMw49QkZi0LfsHovigr++ohlatgYabidPkFFByM9gnmlWcEYcFQax0eyqbAEIqQw9HieVMjusZmfILRPFUQ47waykfN6NfuAe9YIWol+eTYB2j7miF9vYSo3BJcK8//d5hePYjxx90Y+RqLnDIxSo8IHHNr3o511UM2akSo4DiuVhUikhniH0w/0YPe1hfQh6ajtKYMWUkclwtM9DVAJp+ENfEUKsS5SOO5P0eXsK1EsMaLUF1VgGSua9CWGFUyPG3vhRZCSGrK3W7sL9h6aDruQaYwIzxLjCuSbLA9hMYBnB7BcFs7GfIoZFVchOQwb5uOIxsXF3QYbryNZwoD7JwExLLoCPYStLFtBla58eDa5zHe0oD70vFtKs57trqCZYIONhkymk0P5cBb5JTkgb+2EYMS8o4eqMzEH6YhiBCexOXzeQgle8T0BEbffUYYac8m+/aV7anggLG5qSi+cQvFZFv1pA4tA04llbSJDA8PB/gJTgO7CbqhTrRFRKPqBH9zUIjKm9Xgw7V4UUFM+PbFjn2ZIlwSZzhG9TNvkGRuhMK65HmJTaGsIMsWE4wm63o7iNQ0zs1g6YczlHSG15wNfarJuVct6JAbwAwmz18jw4PBOcQU1ZJhE1CZuRVKz1KKrqNMxAP9J2A12pAi9h+0Ji49s9l/OdrpZ2oRnjQGW6QAyXHUl9svGCs6jkxnLUZeahCyn0xsTgyC7QvQzzrfsUWDFu91AINP2+h/Xya/Yb7DErPP4ezHO+jsvgsllTUrE5W5PGj669EmUyMo6ihYFOpuCzFBEJhXK6A3r7i2ZHJwKCMNe8kqs2jRQTNpREKaAHEUddTje7aT8n//8ARgAVgA5rP8Bm02Ght3BFggAAAAAElFTkSuQmCC" height="30" width="20"/>					
					</div>
					<div class="qcby_wd1" id="">
						<a style="display: block;height: 30px;width: 60px;text-align: center;line-height: 30px;text-decoration: none;font-size: 11px;color: dimgray;" href="">青城博雅</a>
					</div>
				</div>
				<div class="position" id="">
					<div class="qcby_img1_div" id="">
						<img  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABwAAAAlCAYAAABReInxAAACW0lEQVRYhe2WTWsTURSG3zgTQk0zY0yjNUwnkwSFSNWiVkNLkk4sJjRGW6SCG/sH3Ih/wZ0LXbpSXCjirijiomIKtYRawaJQRK1tPkQa2pjU0A4ktY0pyWTozFxBSpG8u3PPueeZOffjXEMqnfmNHdSenYQ1gU1gE7g7gDRpoJSdw/RkAgs/1/7YFOuEP3QODubvgAbdq229gPjDuxibyaK8zfcyJ4ZwfSQAC2GttIHrS3h25xYmUyXNJFRHBDdvRGElgGqGvB+9hykFjDbbYDE1xpVTL/FobF6fBo01lKRP+Dr1AzWc0YnTg2Gc7aguWik9jsdP32Jly515PY5kvwBe5y9VgdnPs1hcrdtcaACXe4/W7AJ7CcN9X3A/nqsOrCaxsAzwbSoJ8x8Rn5jXKGmpjDWZaW01N7gZlkWLTZCNLCK3pJoNYDvRF72gAWwxwyozc7+KDW5JkpDNzMlGHLAf1ABuSRVoF07B6arb6VejeD6TrMEy008w8S5fD7C54dmnD1RdQ5PJDvcxL+hvs9WNU/qONw9uI2FmsRdFrBTlu5eGq6cbB/R52seCcvvQq8hSLuYVsE1ZuhAR3QQ4HSAnnMSRM16d+4+Gt1/UPQ5EwIraui/ivEcdSQlhDAV5MloyoQ9kWA4uMQjeuI2TdiB8RYSFEPbiA2F74joHEQw4FKU1ot0fhd9hUpmlEO/DQNRH3g+5wFWEnHUkdagH12LHSafXRAxk2M17UgzhcKW0lVKOxIi6g1LEDbgiT1cMhsIy9rdG4G8nLKVC+g34H+v/f0Q1gU3g7gduAN5onmdqHdiIAAAAAElFTkSuQmCC" height="30" width="20"/>					
					</div>
					<div class="qcby_wd2" >
						保定
					</div>
				</div>
				<div class="myPayment">
					<a class="amyPayment" href="/Labproject/view/jsp/myslefindex.jsp" >我的订单</a>
				</div>
			</div>
			<div class="backTop" onclick="backTop()">
				<div class="tranangle"></div>
				<div class="backTop_wd">TOP</div>
			</div>
			<div class="top2" id="">
				<div class="logo" id="">
					青城博雅在线书店
				</div>
				<div class="menu" id="">
					<% List< Map<String,String> > listmap = (ArrayList)request.getAttribute("menu");  %>
					<% for(int i =0 ; i < listmap.size() ; i++ ) {%>
					<% out.println("<div class=\"menu_son\" >"
							+"<a class=\"a_menu_son\" href=\"javascript:void(0)\" onclick=\"scrollNow('type_"+listmap.get(i).get("Nid")+"')\">"+listmap.get(i).get("type")+"</a>"
							+"</div>"); 
					%>
					
					<% } %>
				</div>
			</div>
			<div class="top4" id="">
				<div class="sellwell" id="">
					<div class="title_sellwell" id="">
						<div class="titlewd" id="">
							销量冠军
						</div>
					</div>
					<div class="content_sellwell" id="">
					<% ArrayList<Map<String,String>> listmap_sellwell = (ArrayList)request.getAttribute("sellwell"); %>
					<% for(int i = 0 ; i < listmap_sellwell.size() ; i++ ) {%>
						<div class="booksellwell" id="">
							<div class="bookimgs" id="">
								<img src="<%= listmap_sellwell.get(i).get("img") %>" height="130" width="100"/>
							</div>
							<div class="bookwd" id="sellwellname_<%=listmap_sellwell.get(i).get("Nid")  %>">
								<%= listmap_sellwell.get(i).get("book_name") %>
							</div>
							<div class="bookwd" id="sellwellprice_<%=listmap_sellwell.get(i).get("Nid")  %>">
								<%= listmap_sellwell.get(i).get("book_price") %>元
							</div>
							<div class="bookwd" id="">
								库存:<%= listmap_sellwell.get(i).get("book_number") %>本
							</div>
							<div class="booksubmit" id="">
								<form action="Addpay_zdz" method="post" id="form1_<%=listmap_sellwell.get(i).get("Nid") %>">
								<input type="hidden" name="name" value="<%= listmap_sellwell.get(i).get("book_name") %>">
								<input type="hidden" name="Nid" value="<%= listmap_sellwell.get(i).get("Nid") %>">
								<input type="hidden" name="price" value="<%= listmap_sellwell.get(i).get("book_price") %>">
								<input class="buy" type="button" name="" id="sellwellbuy_<%=listmap_sellwell.get(i).get("Nid")%>" value="购买"  onclick="sellwellbuy(this.id)"/>
								<input class="jiajian" id="sellwelljia_<%=listmap_sellwell.get(i).get("Nid")%>" type="button" value="+" onclick="jia(this.id,<%=listmap_sellwell.get(i).get("book_number") %>)">
								<input class="buy_num" type="text" disabled="disabled" name="num" id="sellwellnum_<%=listmap_sellwell.get(i).get("Nid")%>" title="数量" value="1"/>
								<input class="jiajian" id="sellwelljian_<%=listmap_sellwell.get(i).get("Nid")%>" type="button" value="-" onclick="jian(this.id)">
								</form>
							</div>
						</div>
					<% } %>	
					</div>
				</div>
				<div class="newbook" id="">
					<div class="title_newbook" id="">
						<div class="titlewd" id="">
							新书推荐
						</div>
					</div>
					<div class="content_newbook" id="">
						<% ArrayList<Map<String,String>> listmap_new = (ArrayList)request.getAttribute("new"); %>
						<% for(int i = 0 ; i < listmap_new.size() ; i++ ) {%>
						<div class="booksellwell" id="">
							<div class="bookimgs" id="">
								<img src="<%= listmap_new.get(i).get("img") %>" height="130" width="100"/>
							</div>
							<div class="bookwd" id="newname_<%=listmap_new.get(i).get("Nid")  %>">
								<%= listmap_new.get(i).get("book_name") %>
							</div>
							<div class="bookwd" id="newprice_<%=listmap_new.get(i).get("Nid")  %>">
								<%= listmap_new.get(i).get("book_price") %>元
							</div>
							<div class="bookwd" id="">
								库存:<%= listmap_new.get(i).get("book_number") %>本
							</div>
							<div class="booksubmit" id="">
								<form action="Addpay_zdz" method="post" id="form2_<%=listmap_new.get(i).get("Nid") %>">
								<input type="hidden" name="name" value="<%= listmap_new.get(i).get("book_name") %>">
								<input type="hidden" name="Nid" value="<%= listmap_new.get(i).get("Nid") %>">
								<input type="hidden" name="price" value="<%= listmap_new.get(i).get("book_price") %>">
								<input class="buy" type="button" name="" id="newbuy_<%=listmap_new.get(i).get("Nid") %>" value="购买" onclick="newbuy(this.id)"/>
								<input class="jiajian" id="newjia_<%=listmap_new.get(i).get("Nid")%>" type="button" value="+" onclick="jia(this.id,<%=listmap_new.get(i).get("book_number") %>)">
								<input class="buy_num" type="text" disabled="disabled" name="num" id="newnum_<%=listmap_new.get(i).get("Nid")  %>" title="数量" value="1"/>
								<input class="jiajian" id="newjian_<%=listmap_new.get(i).get("Nid")%>" type="button" value="-" onclick="jian(this.id)">
								</form>
							</div>
						</div>
					<% } %>	
					</div>
				</div>
				<div class="rankinglist" id="">
					<div class="title_rankinglist" id="">
						<div class="titlewd" id="">
							图书排行
						</div>
					</div>
					<div class="content_rankinglist" id="">
						<% ArrayList<Map<String,String>> listmap_ranking = (ArrayList)request.getAttribute("ranking"); %>
						<% for(int i = 0 ; i < listmap_ranking.size() ; i++ ) {%>
						<div class="book_content_rankinglist" id="">
							<%= listmap_ranking.get(i).get("book_name")  %>
						</div>
						<% } %>
					</div>
				</div>
				<% ArrayList<Map<String,String>> listmap_books = (ArrayList)request.getAttribute("books"); %>
				<% for(int i = 0 ; i < listmap.size() ; i++ ){ %>
				<div class="typebook" id="type_<%= listmap.get(i).get("Nid") %>">
					<div class="bookstypes" id="">
						<div class="bookstypes_det" id="">
							<%= listmap.get(i).get("type")  %>
						</div>
					</div>
					<div class="content_typebook" id="">
					<% for(int k = 0 ; k < listmap_books.size() ; k++ ){ %>
						 <% if(listmap_books.get(k).get("typeid").equals(listmap.get(i).get("Nid"))){ %> 
						<div class="booksellwell" id="">
							<div class="bookimgs" id="">
								<img src="<%= listmap_books.get(k).get("img") %>" height="130" width="100"/>
							</div>
							<div class="bookwd" id="booksname_<%=listmap_books.get(k).get("Nid")%>">
								<%= listmap_books.get(k).get("book_name")  %>
							</div>
							<div class="bookwd" id="booksprice_<%=listmap_books.get(k).get("Nid")%>">
								<%= listmap_books.get(k).get("book_price")  %>元
							</div>
							<div class="bookwd" id="">
								库存:<%= listmap_books.get(k).get("book_number")  %>本
							</div>
							<div class="booksubmit" id="">
								<form action="Addpay_zdz" method="post" id="form3_<%=listmap_books.get(k).get("Nid")%>">
								<input type="hidden" name="name" value="<%= listmap_books.get(k).get("book_name") %>">
								<input type="hidden" name="Nid" value="<%= listmap_books.get(k).get("Nid") %>">
								<input type="hidden" name="price" value="<%= listmap_books.get(k).get("book_price") %>">
								<input class="buy" type="button" name="" id="booksbuy_<%=listmap_books.get(k).get("Nid")%>" value="购买" onclick="booksbuy(this.id)"/>
								<input class="jiajian" id="booksjia_<%=listmap_books.get(k).get("Nid")%>" type="button" value="+" onclick="jia(this.id,<%=listmap_books.get(k).get("book_number") %>)">
								<input class="buy_num" type="text" disabled="disabled" name="num" id="booksnum_<%=listmap_books.get(k).get("Nid")%>" title="数量" value="1"/>
								<input class="jiajian" id="booksjian_<%=listmap_books.get(k).get("Nid")%>" type="button" value="-" onclick="jian(this.id)">
								</form>
							</div>
						</div>
						<% } %>
					<% }  %>
					</div>
				</div>
				<% } %>
			</div>
	</body>
	<script type="text/javascript" src="/Labproject/view/resourses/js/Index_zdz.js"></script>
</html>