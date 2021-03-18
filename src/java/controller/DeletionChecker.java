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
import model.DeletionAuthenticator;

/**
 *
 * @author Gaurav
 */
public class DeletionChecker extends HttpServlet 
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
        
        DeletionAuthenticator authenticator=new DeletionAuthenticator();
        Boolean delete=authenticator.isDelete(user);
        
        if(delete)
        {
            response.sendRedirect("logout.jsp");
        }
        else
        {
            response.sendRedirect("deleteProfile.jsp");
        }
    }
}
