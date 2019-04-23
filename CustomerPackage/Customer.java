package CustomerPackage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {
    private StringProperty nameProperty;
    private StringProperty surnameProperty;
    private IntegerProperty cardProperty;

    public Customer(){
        this.nameProperty = new SimpleStringProperty();
        this.surnameProperty = new SimpleStringProperty();
        this.cardProperty = new SimpleIntegerProperty();
    }

    //for name
    public String getName(){
        return nameProperty.get();
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    public StringProperty getCustName(){
        return nameProperty;
    }

    //for surname
    public String getSurname(){
        return surnameProperty.get();
    }

    public void setSurname(String surname) {
        this.surnameProperty.set(surname);
    }

    public StringProperty getCustSurname(){
        return surnameProperty;
    }
}
