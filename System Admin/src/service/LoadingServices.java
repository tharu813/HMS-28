package service;

import model.User;
import util.DBConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadingServices {

    private static Connection con;
    private PreparedStatement preparedStatement;

    public User getUserId(){

        User user = new User();

        try {

            con = DBConnectionUtil.getConnection();
            String sql="select user_id from user order by user_id desc limit 1;";

            preparedStatement = con.prepareStatement(sql);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();
            int temp =Integer.parseInt(rs.getString(1))+1;
            String uid = String.valueOf(temp);
            user.setUserId(uid);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return user;
    }
}
