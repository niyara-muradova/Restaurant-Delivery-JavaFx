package CustomerPackage;

import AdministratorPackage.AdmDishDAO;
import AdministratorPackage.Dish;
import LoginPackage.LoginController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class CustomerController {

    @FXML private TextField txtName;
    @FXML private TextField txtSurname;
    @FXML private TextField txtCard;


    @FXML
    private void makeOrder(ActionEvent event) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/CustomerPackage/AdministratorDish.fxml"));
        Scene di = new Scene(root);
        //gets stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(di);
        window.show();
    }

    public void logout(ActionEvent event)throws Exception{
        try{
            System.exit(1);
        }catch (Exception e){
            System.out.println("Error occured while logging out");
            e.printStackTrace();
            throw e;
        }
    }


}
