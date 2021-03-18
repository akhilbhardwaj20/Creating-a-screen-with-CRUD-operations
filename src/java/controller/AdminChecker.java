/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.AdminDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.AdminAuthenticator;

/**
 *
 * @author Gaurav
 */
public class AdminChecker extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("adminLogin.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        
        AdminDTO admin=new AdminDTO();
        admin.setUsername(username);
        admin.setPassword(password);
        
        AdminAuthenticator authenticator=new AdminAuthenticator();
        Boolean login=authenticator.isAdmin(admin);
        
        if(login)
        {
            HttpSession session=request.getSession(true);
            session.setAttribute("admin", username);
            response.sendRedirect("allUserData.jsp");
        }
        else
        {
            response.sendRedirect("adminLogin.jsp");
        }
    }    
}
