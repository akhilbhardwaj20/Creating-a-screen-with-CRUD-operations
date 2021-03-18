/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gaurav
 */
public class DeletionAuthenticator 
{
    public boolean isDelete(UserDTO user)
    {
        String username=user.getUsername();
        String password=user.getPassword();
        
        String tablePassword="";
        try
        {
            Statement st=DBConnector.getStatement();
            String query="SELECT password FROM userdata WHERE username='"+username.trim()+"'";            
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                tablePassword=rs.getString(1);
            }
            else
            {
                return false;
            }
            
            if(password.equals(tablePassword)) //if password is correct then delete record.
            {
                query="DELETE FROM userdata WHERE username='"+username.trim()+"'";
                int i= st.executeUpdate(query);
                if(i>0)
                {
                    return true;
                }
                return false;
            } 
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }

        return false;
    }
}
