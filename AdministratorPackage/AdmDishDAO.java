package AdministratorPackage;
import DBUtil.DBUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
public class AdmDishDAO {

    public static void insertDish(int id, String name, int price, int restaurant)throws SQLException, ClassNotFoundException{
        String sql = "insert into dish values("+id+", '"+name+"', "+price+", "+restaurant+")";
        try {
            DBUtil.dbExecuteQuery(sql);

        }catch (SQLException e){
            System.out.println("Exception occured while inserting data");
        }
    }

    public static void updateDish(int id, String name) throws ClassNotFoundException, SQLException{

        String sql = "update dish set dish_name = '"+name+"' where dish_id = "+id+"";

        try{
            DBUtil.dbExecuteQuery(sql);

        }catch (SQLException e){
            System.out.println("Error occured while updating the record");
            e.printStackTrace();
            throw e;
        }
    }

    public static void deleteDishById(int id) throws SQLException, ClassNotFoundException{
        String sql = "delete from dish where dish_id = "+id+"";

        try {
            DBUtil.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("Error occured while deleting the Record");
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Dish> getAllRecords() throws ClassNotFoundException, SQLException{
        String sql = "select * from dish";

        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dish> dishList =  getDishObjects(rsSet);
            return dishList;
        }catch (SQLException e){
            System.out.println("Error occured while fetching the data");
            e.printStackTrace();
            throw e;
        }
    }

    private static ObservableList<Dish> getDishObjects(ResultSet rsSet) throws SQLException, ClassNotFoundException {

        try {
            ObservableList<Dish> dishlist = FXCollections.observableArrayList();

            while (rsSet.next()){
                Dish dish = new Dish();
                dish.setId(rsSet.getInt("dish_id"));
                dish.setName(rsSet.getString("dish_name"));
                dish.setPrice(rsSet.getInt("dish_price"));
                dish.setRid(rsSet.getInt("dish_restaurant_id"));
                dishlist.add(dish);
            }
            return dishlist;
        }catch (SQLException e){
            System.out.println("Error occured while fetching data");
            e.printStackTrace();
            throw e;
        }
    }

    public static ObservableList<Dish> searchDish(String dishId) throws ClassNotFoundException, SQLException{
        String sql = "select * from dish where dish_id = "+dishId+"";
        try {
            ResultSet rsSet = DBUtil.dbExecute(sql);
            ObservableList<Dish> list =  getDishObjects(rsSet);
            return list;
        }catch (SQLException e){
            System.out.println("Error while searching");
            e.printStackTrace();
            throw e;
        }
    }
}
