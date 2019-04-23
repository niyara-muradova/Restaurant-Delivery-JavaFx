package LoginPackage;

import AdministratorPackage.AdministratorApplication;
import CustomerPackage.CustomerApplication;
import DBUtil.DBUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.SQLException;

public class LoginController {


    @FXML
    public TextField txtUsername;
    public PasswordField txtPassword;

    public void login(ActionEvent event) throws Exception {

        try {
            if (LoginDAO.isLogin(txtUsername.getText(), txtPassword.getText())) {

                if(txtUsername.getText().equals("admin")){

                    AdministratorApplication administratorApplication = new AdministratorApplication();
                    administratorApplication.start(new Stage());
                    Stage stage = DBUtil.getStage();
                    stage.close();
                }

                else {
                    CustomerApplication customerApplication = new CustomerApplication();
                    customerApplication.start(new Stage());
                    Stage stage = DBUtil.getStage();
                    stage.close();
                }

                System.out.println("Connected succesfully");



            } else {
                txtUsername.setStyle("-fx-border-color:red; -fx-border-width:2px;");
                txtPassword.setStyle("-fx-border-color:red; -fx-border-width:2px;");
                System.out.println("Fail");

            }
        } catch (SQLException e) {
            System.out.println("Error occured while Login");
            e.printStackTrace();
            throw e;
        }
    }

    public void register(ActionEvent event) throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/RegistrationPackage/RegistrationView.fxml"));
            Scene reg = new Scene(root);
            //gets stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(reg);
            window.show();

        }catch (Exception e){
            System.out.println("Error occured while opening registration page");
            e.printStackTrace();
        }
    }
}
