<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="now" class="java.util.Date" />
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Test</title>
</head>
  <body>
  <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="now" />
    <h1>Hello World!</h1>
    <p>The time is: <c:out value="${now}"/></p>
    <p><a href="/boardItem/list">공지사항 목록</a><p>
  </body>
</html>