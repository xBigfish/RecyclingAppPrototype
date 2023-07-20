package LoginPage;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");

    public StringProperty firstNameProperty(){
        return firstName;
    }
    public String getFirstName(){
        return firstName.get();
    }
    public void setName(String Name){
        this.firstName.set(Name);
    }
}
