/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RegistrationAuthenticator;

/**
 *
 * @author Gaurav
 */
public class RegistrationChecker extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("registration.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String cpassword= request.getParameter("cpassword");
        String fname= request.getParameter("fname");
        String lname= request.getParameter("lname");
        String phone= request.getParameter("phone");
        String city= request.getParameter("city");
        String age= request.getParameter("age");
        
        
        if(username.isEmpty() || fname.isEmpty() || lname.isEmpty()|| phone.isEmpty()|| city.isEmpty() || age.isEmpty() || password.isEmpty() || !password.equals(cpassword))
        {
            response.sendRedirect("registrationFail.jsp"); 
            return;//to avoid 'HTTP Status 500 - cannot call sendRedirect() after the response has been commited', as we have multiple sendRedirect on one page.
        }
        
        UserDTO user=new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        user.setFname(fname);
        user.setLname(lname);
        user.setPhone(phone);
        user.setCity(city);
        user.setAge(age);
        
        RegistrationAuthenticator authenticator=new RegistrationAuthenticator();
        Boolean register=authenticator.isRegister(user);
        
        if(register)
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            response.sendRedirect("registrationFail.jsp");
        }
    }
}
