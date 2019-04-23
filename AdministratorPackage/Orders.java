package AdministratorPackage;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Orders {
    private IntegerProperty idProperty;
    private StringProperty nameProperty;
    private IntegerProperty priceProperty;
    private IntegerProperty ridProperty;

    public Orders(){
        this.idProperty = new SimpleIntegerProperty();
        this.nameProperty = new SimpleStringProperty();
        this.priceProperty = new SimpleIntegerProperty();
        this.ridProperty = new SimpleIntegerProperty();
    }

    //for id
    public int getId(){
        return idProperty.get();
    }

    public void setId(int id) {
        this.idProperty.set(id);
    }
    public IntegerProperty getDishId(){
        return idProperty;
    }

    //for name
    public String getName(){
        return nameProperty.get();
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    public StringProperty getDishName(){
        return nameProperty;
    }

    //for price
    public int getPrice(){
        return priceProperty.get();
    }

    public void setPrice(int price) {
        this.priceProperty.set(price);
    }

    public IntegerProperty getDishPrice(){
        return priceProperty;
    }

    //for r_id
    public int getRid(){
        return ridProperty.get();
    }

    public void setRid(int rid) {
        this.ridProperty.set(rid);
    }

    public IntegerProperty getDishRid(){
        return ridProperty;
    }

}
