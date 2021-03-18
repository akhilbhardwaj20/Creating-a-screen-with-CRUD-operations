<%-- 
    Document   : adminLogout
    Created on : 21 Jul, 2019, 11:32:29 AM
    Author     : Gaurav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout JSP Page</title>
    </head>
    <body>
        <%
            session.invalidate();
            response.sendRedirect("adminLogin.jsp");
        %>
    </body>
</html>
