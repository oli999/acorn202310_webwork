<%@page import="test.cafe.dao.CafeDao"%>
<%@page import="test.cafe.dto.CafeDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CafeDto dto=new CafeDto();
	
	int num=Integer.parseInt(request.getParameter("num"));
	dto.setNum(num);
	
	String title=request.getParameter("title");
	dto.setTitle(title);
	
	String content=request.getParameter("content");
	dto.setContent(content);
	
	boolean isSuccess=CafeDao.getInstance().update(dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/cafe/protected/update.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container pt-5">
		<%if(isSuccess){ %>
	         <p class="alert alert-success">
	             수정 했습니다.
	            <a class="alert-link" href="${pageContext.request.contextPath }/cafe/detail.jsp?num=<%=dto.getNum()%>">확인</a>
	         </p>
      	<%}else{ %>
	         <p class="alert alert-danger">
	            수정 실패했습니다.
	            <a class="alert-link" href="updateform.jsp?num=<%=dto.getNum() %>">다시 수정하러 가기</a>
	         </p>
      	<%} %>
	</div>
</body>
</html>








