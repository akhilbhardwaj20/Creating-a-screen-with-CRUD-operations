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
import javax.servlet.http.HttpSession;
import model.LoginAuthenticator;

/**
 *
 * @author Gaurav
 */
public class LoginChecker extends HttpServlet 
{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("login.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        
        UserDTO user=new UserDTO();
        user.setUsername(username);
        user.setPassword(password);
        
        LoginAuthenticator authenticator=new LoginAuthenticator();
        Boolean login=authenticator.isLogin(user);
        
        if(login)
        {
            HttpSession session=request.getSession(true);
            session.setAttribute("username", username);
            response.sendRedirect("home.jsp");
        }
        else
        {
            response.sendRedirect("login.jsp");
        }
    }
}
