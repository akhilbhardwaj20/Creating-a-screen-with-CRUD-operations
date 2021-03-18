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
public class RegistrationAuthenticator 
{
    public boolean isRegister(UserDTO user)
    {
        String username=user.getUsername();
        String password=user.getPassword();
        String fname=user.getFname();
        String lname=user.getLname();
        String phone=user.getPhone();
        String city=user.getCity();
        String age=user.getAge();
        
        try
        {
            Statement st=DBConnector.getStatement();
            String query="SELECT username FROM userdata WHERE username='"+username+"'";//checking if username is already registered.         
            ResultSet rs=st.executeQuery(query);
            if(rs.next())
            {
                return false; //returing false is username is already registered.
            }              
            query="INSERT INTO userdata(username,password,fname,lname,phone,city,age) VALUES('"+username.trim()+"','"+password+"','"+fname.trim()+"','"+lname.trim()+"','"+phone.trim()+"','"+city.trim()+"','"+age+"')";            
            int i=st.executeUpdate(query); //inserting data to database as user is new.
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
