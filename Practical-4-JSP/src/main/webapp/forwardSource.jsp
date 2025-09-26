<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Forward Example</title>
</head>
<body>
    <h2>Click the button to forward request to another JSP(Written By Shivansh Mishra!!)</h2>

    <form method="post">
        <input type="submit" name="forwardBtn" value="Go to Forward Target">
    </form>

    <%
        // If the button was clicked
        if (request.getParameter("forwardBtn") != null) {
    %>
        <jsp:forward page="forwardTarget.jsp" />
    <%
        }
    %>
</body>
</html>
