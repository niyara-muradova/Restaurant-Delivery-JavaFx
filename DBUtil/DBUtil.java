package DBUtil;

import com.sun.rowset.CachedRowSetImpl;
import javafx.stage.Stage;

import java.sql.*;

public class DBUtil {

    private static Stage stage;
    private static Connection connection = null;
    private static final String connStr = "jdbc:oracle:thin:@DESKTOP-U6FR4RJ:1522:xe";

    //database connection method
    public static void dbConnect() throws SQLException, ClassNotFoundException{
        try {
            connection = DriverManager.getConnection(connStr,"rest","sootnoshenie");
        }catch (SQLException e){
            System.out.println("Connection failed");
            throw e;
        }
    }
    //disconnecting database method
    public static void dbDisconnect() throws SQLException{
        try {
            if(connection!=null&&!connection.isClosed()){
                connection.close();
            }
        }catch (Exception e){
            throw e;
        }
    }

    //for insert update delete from db
    public static void dbExecuteQuery(String sqlStmt) throws SQLException, ClassNotFoundException{
        Statement stmt = null;
        try{
            dbConnect();
            stmt = connection.createStatement();
            stmt.executeUpdate(sqlStmt);
        }catch (SQLException e){
            System.out.println("Problem occured at dbExecuteQuery "+e);
            e.printStackTrace();
            throw e;

        }finally {
            if(stmt!=null){
                stmt.close();
            }
            dbDisconnect();
        }
    }
    //for getting data from database(selects)
    public static ResultSet dbExecute(String sqlQuery) throws ClassNotFoundException, SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        CachedRowSetImpl crs = null;

        try {
            dbConnect();
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sqlQuery);
            crs = new CachedRowSetImpl();
            crs.populate(rs);


        } catch (SQLException e) {
            System.out.println("Problem occured in dbExecute " + e);
            throw e;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }

    public static void setStage(Stage stage) {
        DBUtil.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

}
