<%-- 
    Document   : deleteProfile
    Created on : 3 Aug, 2019, 8:16:36 PM
    Author     : Gaurav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Profile</title>
    </head>
    <body><Center>
    <%--To check that user is already logged-in otherwise redirect to login page--%>
    <%
        String username=(String)session.getAttribute("username");
        if(username==null || username.trim().equals(""))
        {
            response.sendRedirect("login.jsp");
            return; //to avoid 'HTTP Status 500 - An exception occurred processing JSP page', as java code after this line shouldn't be excuted.
        }
    %>
    <br><br>
    <h2><%=username%> are you sure?</h2>
    <form action="DeletionChecker" method="post">
        <input type="text" name="username" value="<%=username%>" hidden="hidden">
    To delete your profile enter password:
        <input type="password" name="password" placeholder="Enter Password Here">
        <input type="submit" value="Delete">
    </form><br><br>
    <b><a href="home.jsp">Return to Home page</a></b>
    </center>
    </body>
</html>
