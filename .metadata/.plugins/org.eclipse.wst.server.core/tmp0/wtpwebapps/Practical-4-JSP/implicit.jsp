<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Request Object Example</title></head>
<body>
<h2>Using Request Implicit Object</h2>
<%
    String clientIP = request.getRemoteAddr();
    String method = request.getMethod();
    String uri = request.getRequestURI();
%>
<p>Client IP: <%= clientIP %></p>
<p>Request Method: <%= method %></p>
<p>Requested URI: <%= uri %></p>
</body>
</html>
