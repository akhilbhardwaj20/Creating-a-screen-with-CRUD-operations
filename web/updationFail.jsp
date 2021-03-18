<%-- 
    Document   : updationFail
    Created on : 19 Jul, 2019, 4:06:15 PM
    Author     : Gaurav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updation Failed</title>
    </head>
    <body>
        <center><h2>Dear user your data updation has failed!</h2>
        <p>Possible Reasons:<br>
           1. Username already registered.<br>
           2. Password not equal to Confirm Password.<br>
           3. Null values in any of the field.<br>
        </p>
        <h3><a href="updateData.jsp">Click here to update again.</a></h3>
        <h3><a href="home.jsp">Click here to go to home page.</a></h3></center>
    </body>
</html>
