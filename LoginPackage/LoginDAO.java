package LoginPackage;

import DBUtil.DBUtil;
import javafx.stage.Stage;

import java.sql.*;

import static DBUtil.DBUtil.dbConnect;

public class LoginDAO {
    static Connection conn;

        public static boolean isLogin(String username, String password) throws SQLException {

        String sql = "select * from customer where log_username = '"+username+"' and log_password = '"+password+"'";
        try {
            ResultSet resultSet = DBUtil.dbExecute(sql);
            if(resultSet.next()){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            return false;
        }
    }



}
