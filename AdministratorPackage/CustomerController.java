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

public class CustomerController {

    @FXML private TextField searchName;
    @FXML private TextField searchSurname;
    @FXML private TextArea resultConsole;

    @FXML private TableColumn<Customer,String> colCustName;
    @FXML private TableColumn<Customer,String> colCustSurname;
    @FXML private TableView custTable;

    @FXML
    private void searchCustomer(ActionEvent event) throws ClassNotFoundException, SQLException {
        ObservableList<Customer> list = CustomerDAO.searchCust(searchName.getText());

        if (list.size()>0){
            populateTable(list);
            resultConsole.setText("Record has been found");
        }else{
            resultConsole.setText("No such records ");
        }
    }

    @FXML
    private void searchAllCustomers(ActionEvent event) throws ClassNotFoundException,SQLException{
        ObservableList<Customer> custList = CustomerDAO.getAllRecords();
        populateTable(custList);
    }

    private void populateTable(ObservableList<Customer> custList){
        custTable.setItems(custList);
    }

    @FXML
    private void initialize() throws Exception{
        colCustName.setCellValueFactory(cellData -> cellData.getValue().getCustomerName());
        colCustSurname.setCellValueFactory(cellData -> cellData.getValue().getCustomerSurname());
        ObservableList<Customer> custList = CustomerDAO.getAllRecords();
        populateTable(custList);

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
