package MainApplication;

import DBUtil.DBUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApplication extends Application {

    @Override

    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/LoginPackage/LoginView.fxml"));
        Scene scene = new Scene(root);
        DBUtil.setStage(primaryStage);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String []args){
        launch(args);
    }

}
