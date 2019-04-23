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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DishController {

    @FXML private TextField txtId;
    @FXML private TextField txtName;
    @FXML private TextField txtPrice;
    @FXML private TextField txtRestaurant;
    @FXML private TextField searchId;
    @FXML private TextField searchName;

    @FXML private javafx.scene.control.TextArea resultConsole;
    @FXML private javafx.scene.control.TextField searchDishId;
    @FXML private javafx.scene.control.TextField searchDishName;
    @FXML private TableColumn<Dish,Integer> colDishId;
    @FXML private TableColumn<Dish,String> colDishName;
    @FXML private TableColumn<Dish,Integer> colDishPrice;
    @FXML private TableColumn<Dish,Integer> colDishRid;
    @FXML private TableView dishTable;

    public void insertDish(javafx.event.ActionEvent event)  throws ClassNotFoundException, SQLException {
        try {
            AdmDishDAO.insertDish(Integer.parseInt(txtId.getText()), txtName.getText(), Integer.parseInt(txtPrice.getText()), Integer.parseInt(txtRestaurant.getText()));
            resultConsole.setText("Success! Values has been added to DB");
            ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
            populateTable(dishList);

        }catch (SQLException e){
            System.out.println("Exception occurs in Insertion " +e);
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void updateDish(ActionEvent event) throws ClassNotFoundException, SQLException{
        try {
            AdmDishDAO.updateDish(Integer.parseInt(searchDishId.getText()), searchDishName.getText());
            resultConsole.setText("Data was updated");
            ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
            populateTable(dishList);

        }catch (SQLException e){
            System.out.println("Error while updating");
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void deleteDish(ActionEvent event) throws ClassNotFoundException,SQLException{
        try {
            AdmDishDAO.deleteDishById(Integer.parseInt(searchId.getText()));
            resultConsole.setText("Deleted successfully");
            ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
            populateTable(dishList);

        }catch (SQLException e){
            System.out.println("Error occured while deleting the record");
            e.printStackTrace();
            throw e;
        }
    }

    @FXML
    private void initialize() throws Exception{
        colDishId.setCellValueFactory(cellData -> cellData.getValue().getDishId().asObject());
        colDishName.setCellValueFactory(cellData -> cellData.getValue().getDishName());
        colDishPrice.setCellValueFactory(cellData -> cellData.getValue().getDishPrice().asObject());
        colDishRid.setCellValueFactory(cellData -> cellData.getValue().getDishRid().asObject());
        ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
        populateTable(dishList);

    }

    private void populateTable(ObservableList<Dish> dishList){
        dishTable.setItems(dishList);
    }

    @FXML
    private void searchDish(ActionEvent event) throws ClassNotFoundException, SQLException{
        ObservableList<Dish> list = AdmDishDAO.searchDish(searchId.getText());

        if (list.size()>0){
            populateTable(list);
            resultConsole.setText("Record has been found");
        }else{
            resultConsole.setText("No such records ");
        }


    }


    @FXML
    private void searchAllDishes(ActionEvent event) throws ClassNotFoundException,SQLException{
        ObservableList<Dish> dishList = AdmDishDAO.getAllRecords();
        populateTable(dishList);
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
