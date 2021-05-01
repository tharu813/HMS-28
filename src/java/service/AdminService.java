package service;

import model.*;
import util.DBConnectionUtil;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdminService implements IAdmin{

    PreparedStatement preparedStatement;
    Connection con;
    @Override
    public boolean addDoctor(Doctor doctor) {
        try{
            con = DBConnectionUtil.getConnection();

            String sql="insert into user(user_id,username,nic,first_name,last_name,email,password,user_type) values(?,?,?,?,?,?,?,?) ";
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setString(1,doctor.getUserId());
            preparedStatement.setString(2,doctor.getUsername());
            preparedStatement.setString(3,doctor.getNic());
            preparedStatement.setString(4,doctor.getFirstName());
            preparedStatement.setString(5,doctor.getLastName());
            preparedStatement.setString(6,doctor.getEmail());
            preparedStatement.setString(7,doctor.getPassword());
            preparedStatement.setInt(8,doctor.getUserType());
            preparedStatement.execute();


            String sql2 ="insert into staff_user(staff_id,title,department) values(?,?,?)";
            preparedStatement=con.prepareStatement(sql2);

            preparedStatement.setString(1,doctor.getUserId());
            preparedStatement.setString(2,doctor.getTitle());
            preparedStatement.setString(3,doctor.getDepartment());
            preparedStatement.execute();


            String sql3="insert into docotor(doctor_id,slmc_no,specialization) values(?,?,?) ";
            preparedStatement=con.prepareStatement(sql3);

            preparedStatement.setString(1,doctor.getUserId());
            preparedStatement.setInt(2,doctor.getSlmc());
            preparedStatement.setString(3,doctor.getSpecialization());
            preparedStatement.execute();

            String sql4 ="insert into user_contact(user_id,contact_no) values(?,?)";
            preparedStatement=con.prepareStatement(sql4);

            preparedStatement.setString(1,doctor.getUserId());
            preparedStatement.setString(2,doctor.getContactNo());
            preparedStatement.execute();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }

        return true;
    }

    @Override
    public boolean addPatient(Patient patient) {

        try {
            con = DBConnectionUtil.getConnection();

            String sql = "insert into user(user_id,username,nic,first_name,last_name,email,password,user_type) values(?,?,?,?,?,?,?,?) ";
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, patient.getUserId());
            preparedStatement.setString(2, patient.getUsername());
            preparedStatement.setString(3, patient.getNic());
            preparedStatement.setString(4, patient.getFirstName());
            preparedStatement.setString(5, patient.getLastName());
            preparedStatement.setString(6, patient.getEmail());
            preparedStatement.setString(7, patient.getPassword());
            preparedStatement.setInt(8, patient.getUserType());
            preparedStatement.execute();


            String sql2="insert into patient(patient_id,age,dob,house_no,street,city,registered_by) values(?,?,?,?,?,?,?) ";
            preparedStatement=con.prepareStatement(sql2);

            preparedStatement.setString(1,patient.getUserId());
            preparedStatement.setInt(2,patient.getAge());
            preparedStatement.setDate(3,patient.getDob());
            preparedStatement.setInt(4,patient.getHouse_no());
            preparedStatement.setString(5,patient.getStreet());
            preparedStatement.setString(6,patient.getCity());
            preparedStatement.setString(7,patient.getRegistered_by());
            preparedStatement.execute();

            String sql4 ="insert into user_contact(user_id,contact_no) values(?,?)";
            preparedStatement=con.prepareStatement(sql4);

            preparedStatement.setString(1,patient.getUserId());
            preparedStatement.setString(2,patient.getContactNo());
            preparedStatement.execute();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }

        return true;
    }

    @Override
    public boolean addReceptionist(Receptionist receptionist) {
        try{
            con = DBConnectionUtil.getConnection();

            String sql="insert into user(user_id,username,nic,first_name,last_name,email,password,user_type) values(?,?,?,?,?,?,?,?) ";
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setString(1,receptionist.getUserId());
            preparedStatement.setString(2,receptionist.getUsername());
            preparedStatement.setString(3,receptionist.getNic());
            preparedStatement.setString(4,receptionist.getFirstName());
            preparedStatement.setString(5,receptionist.getLastName());
            preparedStatement.setString(6,receptionist.getEmail());
            preparedStatement.setString(7,receptionist.getPassword());
            preparedStatement.setInt(8,receptionist.getUserType());
            preparedStatement.execute();


            String sql2 ="insert into staff_user(staff_id,title,department) values(?,?,?)";
            preparedStatement=con.prepareStatement(sql2);

            preparedStatement.setString(1,receptionist.getUserId());
            preparedStatement.setString(2,receptionist.getTitle());
            preparedStatement.setString(3,receptionist.getDepartment());
            preparedStatement.execute();


            String sql3="insert into receptionist(receptionist_id) values(?) ";
            preparedStatement=con.prepareStatement(sql3);

            preparedStatement.setString(1,receptionist.getUserId());
            preparedStatement.execute();

            String sql4 ="insert into user_contact(user_id,contact_no) values(?,?)";
            preparedStatement=con.prepareStatement(sql4);

            preparedStatement.setString(1,receptionist.getUserId());
            preparedStatement.setString(2,receptionist.getContactNo());
            preparedStatement.execute();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }

        return true;
    }

    @Override
    public boolean addNurse(Nurse nurse) {
        try{
            con = DBConnectionUtil.getConnection();

            String sql="insert into user(user_id,username,nic,first_name,last_name,email,password,user_type) values(?,?,?,?,?,?,?,?) ";
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setString(1,nurse.getUserId());
            preparedStatement.setString(2,nurse.getUsername());
            preparedStatement.setString(3,nurse.getNic());
            preparedStatement.setString(4,nurse.getFirstName());
            preparedStatement.setString(5,nurse.getLastName());
            preparedStatement.setString(6,nurse.getEmail());
            preparedStatement.setString(7,nurse.getPassword());
            preparedStatement.setInt(8,nurse.getUserType());
            preparedStatement.execute();


            String sql2 ="insert into staff_user(staff_id,title,department) values(?,?,?)";
            preparedStatement=con.prepareStatement(sql2);

            preparedStatement.setString(1,nurse.getUserId());
            preparedStatement.setString(2,nurse.getTitle());
            preparedStatement.setString(3,nurse.getDepartment());
            preparedStatement.execute();


            String sql3="insert into nurse(nurse_id) values(?) ";
            preparedStatement=con.prepareStatement(sql3);

            preparedStatement.setString(1,nurse.getUserId());
            preparedStatement.execute();

            String sql4 ="insert into user_contact(user_id,contact_no) values(?,?)";
            preparedStatement=con.prepareStatement(sql4);

            preparedStatement.setString(1,nurse.getUserId());
            preparedStatement.setString(2,nurse.getContactNo());
            preparedStatement.execute();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }

        return true;
    }

    @Override
    public boolean addCashier(Cashier cashier) {
        try{
            con = DBConnectionUtil.getConnection();

            String sql="insert into user(user_id,username,nic,first_name,last_name,email,password,user_type) values(?,?,?,?,?,?,?,?) ";
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setString(1,cashier.getUserId());
            preparedStatement.setString(2,cashier.getUsername());
            preparedStatement.setString(3,cashier.getNic());
            preparedStatement.setString(4,cashier.getFirstName());
            preparedStatement.setString(5,cashier.getLastName());
            preparedStatement.setString(6,cashier.getEmail());
            preparedStatement.setString(7,cashier.getPassword());
            preparedStatement.setInt(8,cashier.getUserType());
            preparedStatement.execute();


            String sql2 ="insert into staff_user(staff_id,title,department) values(?,?,?)";
            preparedStatement=con.prepareStatement(sql2);

            preparedStatement.setString(1,cashier.getUserId());
            preparedStatement.setString(2,cashier.getTitle());
            preparedStatement.setString(3,cashier.getDepartment());
            preparedStatement.execute();


            String sql3="insert into cashier(cashier_id) values(?) ";
            preparedStatement=con.prepareStatement(sql3);

            preparedStatement.setString(1,cashier.getUserId());
            preparedStatement.execute();

            String sql4 ="insert into user_contact(user_id,contact_no) values(?,?)";
            preparedStatement=con.prepareStatement(sql4);

            preparedStatement.setString(1,cashier.getUserId());
            preparedStatement.setString(2,cashier.getContactNo());
            preparedStatement.execute();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }

        return true;
    }

    @Override
    public boolean addLabTechinician(LabTechnician labTechnician) {
        try{
            con = DBConnectionUtil.getConnection();

            String sql="insert into user(user_id,username,nic,first_name,last_name,email,password,user_type) values(?,?,?,?,?,?,?,?) ";
            preparedStatement=con.prepareStatement(sql);

            preparedStatement.setString(1,labTechnician.getUserId());
            preparedStatement.setString(2,labTechnician.getUsername());
            preparedStatement.setString(3,labTechnician.getNic());
            preparedStatement.setString(4,labTechnician.getFirstName());
            preparedStatement.setString(5,labTechnician.getLastName());
            preparedStatement.setString(6,labTechnician.getEmail());
            preparedStatement.setString(7,labTechnician.getPassword());
            preparedStatement.setInt(8,labTechnician.getUserType());
            preparedStatement.execute();


            String sql2 ="insert into staff_user(staff_id,title,department) values(?,?,?)";
            preparedStatement=con.prepareStatement(sql2);

            preparedStatement.setString(1,labTechnician.getUserId());
            preparedStatement.setString(2,labTechnician.getTitle());
            preparedStatement.setString(3,labTechnician.getDepartment());
            preparedStatement.execute();


            String sql3="insert into labTechnician(labtechnician_id) values(?) ";
            preparedStatement=con.prepareStatement(sql3);

            preparedStatement.setString(1,labTechnician.getUserId());
            preparedStatement.execute();

            String sql4 ="insert into user_contact(user_id,contact_no) values(?,?)";
            preparedStatement=con.prepareStatement(sql4);

            preparedStatement.setString(1,labTechnician.getUserId());
            preparedStatement.setString(2,labTechnician.getContactNo());
            preparedStatement.execute();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }

        return true;
    }

    @Override
    public boolean addConsultation_info(Consultation_info consultation_info) {
        try {
            con = DBConnectionUtil.getConnection();

            String sql = "insert into user(fee,time,date) values(?,?,?) ";
            preparedStatement = con.prepareStatement(sql);


            preparedStatement.setInt(1, consultation_info.getFee());
            preparedStatement.setTime(2, consultation_info.getTime());
            preparedStatement.setDate(3, consultation_info.getDate());

            preparedStatement.execute();


        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();

        }
        finally {
            DBConnectionUtil.closeConnection(preparedStatement,con);
        }

        return true;
    }
}
