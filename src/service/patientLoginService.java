package service;

import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class patientLoginService {
    private Connection con;
    public boolean login(String user_id, String password){

        boolean st = false;
        try{
            con = DBConnectionUtil.getConnection();
            PreparedStatement preparedStatement = con.prepareStatement("select u.user_id,u.password from user u,patient p where u.user_id = p.patient_id and u.user_id=? and u.password=? ");
            preparedStatement.setString(1,user_id);
            preparedStatement.setString(2,password);


            ResultSet rs = preparedStatement.executeQuery();
            st  = rs.next();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }


        return st;
    }
}
