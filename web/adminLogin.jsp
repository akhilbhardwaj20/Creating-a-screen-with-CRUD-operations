<%-- 
    Document   : adminLogin
    Created on : 17 Jul, 2019, 6:14:19 PM
    Author     : Gaurav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Login</title>
    </head>
    <body>
        <%
           String username=(String)session.getAttribute("admin");
           if(username!=null)
           {
               response.sendRedirect("allUserData.jsp");
           }
        %>
        <center>
            <h2>Welcome Administrator!</h2>
        <form action="AdminChecker" method="post"> 
        <table border="1">
            <tr>
                <td>Administrator Name:</td>
                <td><input type="text" name="username" placeholder="Enter Admin Name Here"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" placeholder="Enter Password Here"></td>
            </tr>
            <tr>
                <td><input type="reset"></td>
                <td><input type="submit" value="Login"></td>
            </tr>
        </table>
        </form>
        </center>
    </body>
</html>
