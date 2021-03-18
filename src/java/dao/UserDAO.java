/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBConnector;
import dto.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gaurav
 */
public class UserDAO 
{
    public List<UserDTO> getAllUserData()
    {
        List<UserDTO> listOfAllUsers=new ArrayList<UserDTO>();
        try
        {
            Statement st=DBConnector.getStatement();
            String query="SELECT * FROM userdata"; 
            ResultSet rs=st.executeQuery(query);
            
            while(rs.next())
            {
                UserDTO userDTO=new UserDTO();
                userDTO.setUsername(rs.getString(1));
                userDTO.setPassword(rs.getString(2));              
                userDTO.setFname(rs.getString(3));
                userDTO.setLname(rs.getString(4));
                userDTO.setPhone(rs.getString(5));
                userDTO.setCity(rs.getString(6));
                userDTO.setAge(rs.getString(7));
                listOfAllUsers.add(userDTO);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return listOfAllUsers;
    }
    
    public UserDTO getSpecificUserData(String username)
    {
        UserDTO userDTO=null;
        try
        {
            Statement st=DBConnector.getStatement();
            String query="SELECT * FROM userdata WHERE username='"+username+"'"; 
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                userDTO=new UserDTO();
                userDTO.setUsername(rs.getString(1));
                userDTO.setPassword(rs.getString(2));              
                userDTO.setFname(rs.getString(3));
                userDTO.setLname(rs.getString(4));
                userDTO.setPhone(rs.getString(5));
                userDTO.setCity(rs.getString(6));
                userDTO.setAge(rs.getString(7));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return userDTO;
    }
}
