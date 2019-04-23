package AdministratorPackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdministratorController {

    public void admDish(ActionEvent event)throws Exception{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/AdministratorPackage/AdministratorDish.fxml"));
            Scene admDish = new Scene(root);
            //gets stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(admDish);
            window.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Dish page");
            e.printStackTrace();
            throw e;
        }

    }

    public void admRestaurant(ActionEvent event) throws Exception{
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/AdministratorPackage/AdministratorRestaurant.fxml"));
            Scene admRest = new Scene(root);
            //gets stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(admRest);
            window.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Restaurants page");
            e.printStackTrace();
            throw e;
        }
    }

    public void admCustomer(ActionEvent event) throws Exception{
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/AdministratorPackage/AdministratorCustomer.fxml"));
            Scene admCust = new Scene(root);
            //gets stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(admCust);
            window.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Restaurants page");
            e.printStackTrace();
            throw e;
        }
    }

    public void admOrders(ActionEvent event) throws Exception{
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/AdministratorPackage/OrdersView.fxml"));
            Scene admCust = new Scene(root);
            //gets stage information
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(admCust);
            window.show();

        }catch (Exception e){
            System.out.println("Error occured while opening Restaurants page");
            e.printStackTrace();
            throw e;
        }
    }

    public void admLogout(ActionEvent event)throws Exception{
        try{
            System.exit(1);
        }catch (Exception e){
            System.out.println("Error occured while logging out");
            e.printStackTrace();
            throw e;
        }
    }
}
