package ud1;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;


public class prPersonTableUtil {
    /* Returns an observable list of persons */
    public static ObservableList<prPerson> getPersonList() {
        prPerson p1 = new prPerson("Ashwin", "Sharan", LocalDate.of(2012, 10, 11));
        prPerson p2 = new prPerson("Advik", "Sharan", LocalDate.of(2012, 10, 11));
        prPerson p3 = new prPerson("Layne", "Estes", LocalDate.of(2011, 12, 16));
        prPerson p4 = new prPerson("Mason", "Boyd", LocalDate.of(2003, 4, 20));
        prPerson p5 = new prPerson("Babalu", "Sharan", LocalDate.of(1980, 1, 10));
        return FXCollections.<prPerson>observableArrayList(p1, p2, p3, p4, p5);
    }
    
    /* Returns Person Id TableColumn */ 
    public static TableColumn<prPerson, Integer> getIdColumn() {
        TableColumn<prPerson, Integer> personIdCol = new TableColumn<>("Id");
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("personId"));
        return personIdCol;
    }
    
    /* Returns First Name TableColumn */ 
    public static TableColumn<prPerson, String> getFirstNameColumn() {
        TableColumn<prPerson, String> fNameCol = new TableColumn<>("First Name");
        fNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        return fNameCol;
    }
    
    /* Returns Last Name TableColumn */ 
    public static TableColumn<prPerson, String> getLastNameColumn() {
        TableColumn<prPerson, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        return lastNameCol;
    }
    
    /* Returns Birth Date TableColumn */ 
    public static TableColumn<prPerson, LocalDate> getBirthDateColumn() {
        TableColumn<prPerson, LocalDate> bDateCol = new TableColumn<>("Birth Date");
        bDateCol.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        return bDateCol;
    }
}

