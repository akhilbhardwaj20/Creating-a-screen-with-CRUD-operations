<%-- 
    Document   : home
    Created on : 11 Jul, 2019, 6:00:24 PM
    Author     : Gaurav
--%>

<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body><center>
        <%--To check that user is already logged-in otherwise redirect to login page--%>
        <%
           String username=(String)session.getAttribute("username");
           if(username==null || username.trim().equals(""))
           {
               response.sendRedirect("login.jsp");
               return; //to avoid 'HTTP Status 500 - An exception occurred processing JSP page', as java code after this line shouldn't be excuted.
           }
        %>
        <a href="logout.jsp">Sign Out</a>
        <h3>Login successful!</h3>
        <h2>Hello <%=username%>!</h2>
        <%           
            UserDAO userDAO=new UserDAO();
            UserDTO userDTO=userDAO.getSpecificUserData(username);
        %>
        <table style="font-size: 20px" border="1">
            <tr>
                <td><b>Username:</b></td>
                <td><%=userDTO.getUsername()%></td>        
            </tr>
            <tr>
                <td><b>Password:</b></td>
                <td><%=userDTO.getPassword()%></td>        
            </tr>
            <tr>
                <td><b>First Name:</b></td>
                <td><%=userDTO.getFname()%></td>        
            </tr>
            <tr>
                <td><b>Last Name:</b></td>
                <td><%=userDTO.getLname()%></td>        
            </tr>
            <tr>
                <td><b>Phone:</b></td>
                <td><%=userDTO.getPhone()%></td>        
            </tr>
            <tr>
                <td><b>City:</b></td>
                <td><%=userDTO.getCity()%></td>        
            </tr>
            <tr>
                <td><b>Age:</b></td>
                <td><%=userDTO.getAge()%></td>        
            </tr>
        </table>
            <br>
            <b>To update data <a href="updateData.jsp">Click here</a></b><br><br>
            <b>To delete your profile <a href="deleteProfile.jsp">Click here</a></b>
    </centre></body>
</html>
