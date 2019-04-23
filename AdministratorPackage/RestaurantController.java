package AdministratorPackage;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class RestaurantController {


    @FXML private TextField txtName;
    @FXML private TextField txtAddress;
    @FXML private TextArea resultConsole;
    @FXML private TextField searchName;

    @FXML private TableColumn<Restaurant,String> colRestName;
    @FXML private TableColumn<Restaurant,String> colRestAddress;
    @FXML private TableView restTable;

    public void insertRestaurant(javafx.event.ActionEvent event)  throws ClassNotFoundException, SQLException {
        try {
            RestaurantDAO.insertRestaurant(111,txtName.getText(), txtAddress.getText());
            resultConsole.setText("Success! Values has been added to DB");
            ObservableList<Restaurant> restList = RestaurantDAO.getAllRecords();
            populateTable(restList);

        }catch (SQLException e){
            System.out.println("Exception occurs in Insertion " +e);
            e.printStackTrace();
            throw e;
        }
    }

    private void populateTable(ObservableList<Restaurant> restList){
        restTable.setItems(restList);
    }

    @FXML
    private void initialize() throws Exception{
        colRestName.setCellValueFactory(cellData -> cellData.getValue().getRestaurantName());
        colRestAddress.setCellValueFactory(cellData -> cellData.getValue().getRestaurantAddress());
        ObservableList<Restaurant> restList = RestaurantDAO.getAllRecords();
        populateTable(restList);

    }

    @FXML
    private void searchRestaurant(ActionEvent event) throws ClassNotFoundException, SQLException{
        ObservableList<Restaurant> list = RestaurantDAO.searchRest(searchName.getText());

        if (list.size()>0){
            populateTable(list);
            resultConsole.setText("Record has been found");
        }else{
            resultConsole.setText("No such records ");
        }
    }

    @FXML
    private void searchAllRestaurants(ActionEvent event) throws ClassNotFoundException,SQLException{
        ObservableList<Restaurant> restList = RestaurantDAO.getAllRecords();
        populateTable(restList);
    }

    public void return_back(ActionEvent event) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/AdministratorPackage/AdministratorView.fxml"));
            Scene admDish = new Scene(root);

            //gets stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(admDish);
            window.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Admin page");
            e.printStackTrace();
            throw e;
        }
    }

}
