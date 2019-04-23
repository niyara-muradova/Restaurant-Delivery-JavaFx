package AdministratorPackage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Restaurant {

    private StringProperty nameProperty;
    private StringProperty addressProperty;

    public Restaurant(){
        this.nameProperty = new SimpleStringProperty();
        this.addressProperty = new SimpleStringProperty();
    }

    //for name
    public String getName(){
        return nameProperty.get();
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    public StringProperty getRestaurantName(){
        return nameProperty;
    }

    //for address
    public String getAddress(){
        return addressProperty.get();
    }

    public void setAddress(String address) {
        this.addressProperty.set(address);
    }

    public StringProperty getRestaurantAddress(){
        return addressProperty;
    }
}
