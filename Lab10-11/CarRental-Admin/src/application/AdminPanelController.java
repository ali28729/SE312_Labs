package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import application.hibernate.*;

public class AdminPanelController implements Initializable {
	@FXML
    private TableView<car> carTable;

    @FXML
    private TableColumn<car, String> VINColumn;
    @FXML
    private TableColumn<car, String> modelColumn;
	
	@FXML
	private Label VIN;
	@FXML
	private Label make;
	@FXML
	private Label model;
	@FXML
	private Label model_year;
	@FXML
	private Label body_class;
	@FXML
	private Label regno;
	@FXML
	private Label rent;
	@FXML
	private Label availability;
	@FXML
	private Label city;
	private BorderPane border;
    CarDAO carDAO = new CarDAO();


	public void setBorder(BorderPane rootLayout) {
		this.border = rootLayout;
	}
	public void loginButtonClick(ActionEvent event){
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
        AdminPanelController ops = new AdminPanelController();
        List<car> carList = ops.getCarList();
        VINColumn.setCellValueFactory(new PropertyValueFactory<car, String>("VIN"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<car, String>("model"));
        carTable.setItems((ObservableList<car>) carList);
	}
  
    public car createCar() {
        car s = new car();
        s.setAvailability("available");
        s.setBody_class("Sedan");
        s.setCity("Islamabad");
        s.setMake("Toyota");
        s.setModel("Aqua");
        s.setModel_year(2014);
        s.setRegno("AXX654");
        s.setRent(654654.13);
        carDAO.addCar(s);
        return s;
    }

    public void updateCar(Integer id) {
        car u = carDAO.findCarById(id);
        u.setBody_class("Hatchback");
        carDAO.updateCar(u);
        System.out.println("Car Updated Success");
    }

    public void deleteCar(Integer id) {
    	carDAO.deleteCar(id);
        System.out.println("Car Deleted Success");
    }

    public List<car> getCarList() {
        return carDAO.listCar();
    }

    public car getCar(Integer id) {
        return carDAO.findCarById(id);
    }
}