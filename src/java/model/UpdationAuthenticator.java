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
public class UpdationAuthenticator 
{
    public boolean isUpdate(UserDTO user)
    {
        String username=user.getUsername();
        String password=user.getPassword();
        String oldPassword=user.getOldPassword();
        String fname=user.getFname();
        String lname=user.getLname();
        String phone=user.getPhone();
        String city=user.getCity();
        String age=user.getAge();
        
        try
        {
            //checking if old password is correct:
            Statement st=DBConnector.getStatement();
            String query="SELECT password FROM userdata WHERE username='"+username+"'";
            ResultSet  rs=st.executeQuery(query);
            if(rs.next() && !rs.getString(1).equals(oldPassword))
            {
                return false; 
            }
            //if old password is same then updating data:
            query="UPDATE userdata SET password='"+password+"',fname='"+fname.trim()+"',lname='"+lname.trim()+"',phone='"+phone.trim()+"',city='"+city.trim()+"',age='"+age+"' WHERE username='"+username+"'";            
            int i=st.executeUpdate(query);
            if(i>0)
            {
                return true;
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
        return false;
    }
}
