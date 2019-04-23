package AdministratorPackage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

    private StringProperty nameProperty;
    private StringProperty surnameProperty;

    public Customer(){
        this.nameProperty = new SimpleStringProperty();
        this.surnameProperty = new SimpleStringProperty();
    }

    //for name
    public String getName(){
        return nameProperty.get();
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    public StringProperty getCustomerName(){
        return nameProperty;
    }

    //for surname
    public String getSurname(){
        return surnameProperty.get();
    }

    public void setSurname(String surname) {
        this.surnameProperty.set(surname);
    }

    public StringProperty getCustomerSurname(){
        return surnameProperty;
    }
}
