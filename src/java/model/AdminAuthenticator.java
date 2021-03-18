/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.AdminDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gaurav
 */
public class AdminAuthenticator 
{
    public boolean isAdmin(AdminDTO admin)
    {
        String username=admin.getUsername();
        String password=admin.getPassword();
        
        String tablePassword="";
        try
        {
            Statement st=DBConnector.getStatement();
            String Query="SELECT password FROM admin WHERE username='"+username.trim()+"'";            
            ResultSet rs=st.executeQuery(Query);
            if(rs.next())
            {
                tablePassword=rs.getString(1);
            }
            else
            {
                return false;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        if(password.equals(tablePassword))
        {
            return true;
        }
        return false;
    }
}
