<%@ page import="java.sql.*" %>
<%
    String name = request.getParameter("name");
    String email = request.getParameter("email");

    if(name != null && email != null) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/practicals_db", "root", "shivansh@mishra");

            PreparedStatement ps = con.prepareStatement("INSERT INTO users(name, email) VALUES (?, ?)");
            ps.setString(1, name);
            ps.setString(2, email);

            int i = ps.executeUpdate();
            if(i > 0) {
                out.println("<h3>Record inserted successfully!</h3>");
            } else {
                out.println("<h3>Failed to insert record.</h3>");
            }

            con.close();
        } catch(Exception e) {
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
    }
%>

<!DOCTYPE html>
<html>
<head><title>Insert Record</title></head>
<body>
<h2>Insert Record into Database</h2>
<form method="post">
    Name: <input type="text" name="name"><br><br>
    Email: <input type="text" name="email"><br><br>
    <input type="submit" value="Insert">
</form>
</body>
</html>
