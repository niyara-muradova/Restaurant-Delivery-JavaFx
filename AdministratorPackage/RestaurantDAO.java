package AdministratorPackage;

import DBUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantDAO {

    public static void insertRestaurant(int id, String name, String address) throws SQLException, ClassNotFoundException{
        String sql = "insert into restaurant values(1, '"+name+"', '"+address+"')";

        try{
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occured while inserting data");
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Restaurant> getAllRecords() throws ClassNotFoundException, SQLException{

        String sql = "select restaurant_name, restaurant_address from restaurant";

        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Restaurant> restList =  getRestObjects(rsSet);
            return restList;
        }catch (SQLException e){
            System.out.println("Error occured while fetching the data");
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Restaurant> getRestObjects(ResultSet rsSet) throws SQLException, ClassNotFoundException {

        try {
            ObservableList<Restaurant> restlist = FXCollections.observableArrayList();

            while (rsSet.next()){
                Restaurant rest = new Restaurant();
                rest.setName(rsSet.getString("restaurant_name"));
                rest.setAddress(rsSet.getString("restaurant_address"));
                restlist.add(rest);
            }
            return restlist;
        }catch (SQLException e){
            System.out.println("Error occured while fetching data");
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Restaurant> searchRest(String restName) throws ClassNotFoundException, SQLException{
        String sql = "select restaurant_name, restaurant_address from restaurant where restaurant_name = '"+restName+"'";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Restaurant> list =  getRestObjects(rsSet);
            return list;
        }catch (SQLException e){
            System.out.println("Error while searching");
            e.printStackTrace();
            throw e;
        }
    }
}
