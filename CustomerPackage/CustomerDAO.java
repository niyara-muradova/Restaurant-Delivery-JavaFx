package CustomerPackage;

import DBUtil.DBUtil;
import LoginPackage.LoginController;
import LoginPackage.LoginDAO;

import java.sql.SQLException;

public class CustomerDAO {

    public void getProfile(String name, String surname, int card) throws SQLException, ClassNotFoundException{
        try {
            String sql = "select customer_name, customer_surname, customer_card_number from customer where log_username = 'niyara'";
            DBUtil.dbExecute(sql);
        }catch (Exception e){
            System.out.println("Error occured while fetching data");
            e.printStackTrace();
        }
    }
}
