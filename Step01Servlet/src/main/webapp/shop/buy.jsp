<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// GET 방식 요청 파라미터로 전달되는 상품의 번호와 갯수 얻어내기
	String num=request.getParameter("num");
	String amount=request.getParameter("amount");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/shop/buy.jsp</title>
</head>
<body>
	<div class="container">
		<p>
			<strong>Gura</strong> 고객님
			<strong><%=num %></strong> 번 상품
			<strong><%=amount %></strong> 개의 주문을 완료 했습니다.
 		</p>
	</div>
</body>
</html>