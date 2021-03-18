<%-- 
    Document   : updateData
    Created on : 19 Jul, 2019, 3:44:50 PM
    Author     : Gaurav
--%>

<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updation Page</title>
    </head>
    <body>
        <%--To check that user is already logged-in otherwise redirect to login page--%>
        <%
           String username=(String)session.getAttribute("username");
           System.out.println(username);
           if(username==null || username.trim().equals(""))
           {
               response.sendRedirect("login.jsp");
               return; //to avoid 'HTTP Status 500 - An exception occurred processing JSP page', as java code after this line shouldn't be excuted.
           }          
            UserDAO userDAO=new UserDAO();
            UserDTO userDTO=userDAO.getSpecificUserData(username);
        %>
        <center><h2>Update Details -</h2>
        <form action="UpdationChecker" method="post">
            <table>
                <tr>
                    <td><B>Username:</B></td>
                    <td><input type="text" name="username" value="<%=userDTO.getUsername()%>" readonly=""></td>
                </tr>
                <tr>
                    <td><B>Old Password:</B></td>
                    <td><input type="password" name="oldPassword" placeholder="Enter Old Password Here"></td>
                </tr>
                <tr>
                    <td><B>New Password:</B></td>
                    <td><input type="password" name="password" placeholder="Enter New Password Here"></td>
                </tr>
                <tr>
                    <td><B>Confirm Password:</B></td>
                    <td><input type="password" name="conPassword" placeholder="Re-enter Password Here"></td>
                </tr>
                <tr>
                    <td><B>First Name:</B></td>
                    <td><input type="text" name="fname" value="<%=userDTO.getFname()%>"></td>
                </tr>
                <tr>
                    <td><B>Last Name:</B></td>
                    <td><input type="text" name="lname" value="<%=userDTO.getLname()%>"></td>
                </tr>
                <tr>
                    <td><B>Phone Number:</B></td>
                    <td><input type="text" name="phone" value="<%=userDTO.getPhone()%>"></td>
                </tr>
                <tr>
                    <td><B>City:</B></td>
                    <td><input type="text" name="city" value="<%=userDTO.getCity()%>"></td>
                </tr>
                <tr>
                    <td><B>Age:</B></td>
                    <td><input type="number" name="age" value="<%=userDTO.getAge()%>"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"></td>
                </tr>
            </table>
        </form><br><br>
        <p><B>Note:</B> 1.Make sure your 'Password' and 'Confirm Password' fields contain same value.<br>
            2.Your username should be unique.<br>
            <B>Failure of above statements will lead to updation failure.</B></p>
        <br><br><h3>Changed your mind?... To go back to home page <a href="home.jsp">Click here</a></h3>
        </center>
    </body>
</html>
