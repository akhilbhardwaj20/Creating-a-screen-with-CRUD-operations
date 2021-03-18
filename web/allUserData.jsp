<%-- 
    Document   : allUserData
    Created on : 16 Jul, 2019, 7:50:54 PM
    Author     : Gaurav
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="dto.UserDTO"%>
<%@page import="dao.UserDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All User Data</title>
    </head>
    <body><center>
        <%--To check that admin is already logged-in otherwise redirect to Admin-login page--%>
        <%
           String username=(String)session.getAttribute("admin");
           if(username==null || username.trim().equals(""))
           {
               response.sendRedirect("adminLogin.jsp");
               return; //to avoid 'HTTP Status 500 - An exception occurred processing JSP page', as java code after this line shouldn't be excuted.
           }
        %>
        <h1>Every User's Data-</h1>
        <%
            UserDAO userDAO=new UserDAO();
            List<UserDTO> listOfAllUser= userDAO.getAllUserData();
        
            Iterator<UserDTO> listIterator=listOfAllUser.iterator();
        %>
        <table border="1" style="width: 1000spx">
                <tr>
                    <td><B>Username:</B></td>
                    <td><B>Password:</B></td>
                    <td><B>First Name:</B></td>
                    <td><B>Last name:</B></td>
                    <td><B>Phone:</B></td>
                    <td><B>City:</B></td>
                    <td><B>Age:</B></td>
                </tr>
        <%
            while(listIterator.hasNext())
            {
                UserDTO userDTO=listIterator.next();
        %>
                <tr>
                    <td><%=userDTO.getUsername()%></td>
                    <td><%=userDTO.getPassword()%></td>
                    <td><%=userDTO.getFname()%></td>
                    <td><%=userDTO.getLname()%></td>
                    <td><%=userDTO.getPhone()%></td>
                    <td><%=userDTO.getCity()%></td>
                    <td><%=userDTO.getAge()%></td>
                </tr>
        <%
            }
        %>
        </table>
        <h3>To logout <a href="adminLogout.jsp">Click Here</a></h3></center>
    </body>
</html>
