<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <%--To check if user is already logged-in if so then redirect to home page--%>
        <%
           String username=(String)session.getAttribute("username");
           if(username!=null)
           {
               response.sendRedirect("home.jsp");
           }
        %>
        <center><h1>Welcome User!</h1>
            <form action="LoginChecker" method="post">
            <table>
                <tr>
                    <td><B>Username:</B></td>
                    <td><input type="text" name="username" placeholder="Enter Username Here"></td>
                </tr>
                <tr>
                    <td><B>Password:</B></td>
                    <td><input type="password" name="password" placeholder="Enter Password Here"></td>
                </tr>
                <tr>
                    <td><input type="reset"></td>
                    <td><input type="submit" value="login"></td>
                </tr>
            </table>
            </form><br><br>
    <h3>New here?... <a href="registration.jsp">Click here to Register</a></h3></center>
    </body>
</html>
