package RegistrationPackage;

import AdministratorPackage.Restaurant;
import AdministratorPackage.RestaurantDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationController {

    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField name;
    @FXML private TextField surname;
    @FXML private TextField card;
    @FXML private TextField gender;
    @FXML private TextArea resultConcole;

    public void register(ActionEvent event) throws Exception{
        try {
            RegistrationDAO.insert(1, name.getText(), surname.getText(), gender.getText(), Integer.parseInt(card.getText()),username.getText(),password.getText());
            resultConcole.setText("Successfully registered");
        }catch (Exception e){
            System.out.println("Error while registering and inserting");
        }
    }

    public void return_back(ActionEvent event) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/LoginPackage/LoginView.fxml"));
            Scene log = new Scene(root);
            //gets stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(log);
            window.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Log page");
            e.printStackTrace();
            throw e;
        }
    }
}
