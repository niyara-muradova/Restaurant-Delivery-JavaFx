package AdministratorPackage;

import DBUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO {

    public static ObservableList<Customer> getAllRecords() throws ClassNotFoundException, SQLException {

        String sql = "select customer_name, customer_surname from customer";

        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Customer> custList =  getRestObjects(rsSet);
            return custList;
        }catch (SQLException e){
            System.out.println("Error occured while fetching the data");
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Customer> getRestObjects(ResultSet rsSet) throws SQLException, ClassNotFoundException {

        try {
            ObservableList<Customer> custlist = FXCollections.observableArrayList();

            while (rsSet.next()){
                Customer cust = new Customer();
                cust.setName(rsSet.getString("customer_name"));
                cust.setSurname(rsSet.getString("customer_surname"));
                custlist.add(cust);
            }
            return custlist;
        }catch (SQLException e){
            System.out.println("Error occured while fetching data");
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Customer> searchCust(String custName) throws ClassNotFoundException, SQLException{
        String sql = "select customer_name, customer_surname from customer where customer_name = '"+custName+"'";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Customer> list =  getRestObjects(rsSet);
            return list;
        }catch (SQLException e){
            System.out.println("Error while searching");
            e.printStackTrace();
            throw e;
        }
    }
}
