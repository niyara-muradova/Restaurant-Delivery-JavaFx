package RegistrationPackage;

import DBUtil.DBUtil;

import java.sql.SQLException;

public class RegistrationDAO {

    public static void insert(int id, String name, String surname, String gender, int card, String log_username, String log_password )throws SQLException, ClassNotFoundException{
        String sql = "insert into customer values("+id+", '"+name+"', '"+surname+"', '"+gender+"', '"+card+"', '"+log_username+"', '"+log_password+"')";
        try {
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Exception occured while inserting data");
        }
    }

    public static void updateName(String username, String name) throws ClassNotFoundException, SQLException{

        String sql = "update customer set customer_name = '"+name+"' where log_username = "+username+"";

        try{
            DBUtil.dbExecuteQuery(sql);

        }catch (SQLException e){
            System.out.println("Error occured while updating the record");
            e.printStackTrace();
            throw e;
        }
    }
}
