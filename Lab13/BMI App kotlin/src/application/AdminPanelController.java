package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
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
    private Main mainApp;
    @FXML
    private TextField searchBar;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


	public void setBorder(BorderPane rootLayout) {
		this.border = rootLayout;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	    AdminPanelController ops = new AdminPanelController();
		// TODO Auto-generated method stub
        List<car> carList = ops.getCarList();
        VINColumn.setCellValueFactory(new PropertyValueFactory<car, String>("VIN"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<car, String>("model"));
        showCarDetails(null);
        carTable.setItems((ObservableList<car>) carList);
        // Listen for selection changes and show the car details when changed.
        carTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCarDetails(newValue));
	}
  	
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new car.
     */
    @FXML
    private void promptConfirmBooking() {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("ConfirmBookingLayout.fxml"));
            AnchorPane bookingPanel = (AnchorPane) loader.load();
            border.setCenter(bookingPanel);
            ConfirmBookingLayoutController panelB = loader.getController();
            panelB.setBorder(border);
            panelB.setMainApp(mainApp);

    	} catch (IOException e) {
            e.printStackTrace();
        }
    }

	
    @FXML
    private void handleNewCar() {
        car tempCar = new car();
        boolean okClicked = mainApp.showCarEditDialog(tempCar);
        if (okClicked) {
            carDAO.addCar(tempCar);
            System.out.println("Car Added!");
            carTable.getItems().add(tempCar);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected car.
     */
    @FXML
    private void handleEditCar() {
        AdminPanelController ops = new AdminPanelController();
        car selectedCar = carTable.getSelectionModel().getSelectedItem();
        if (selectedCar != null) {
            boolean okClicked = mainApp.showCarEditDialog(selectedCar);
            if (okClicked) {
                ops.updateCarDialog(selectedCar);
                List<car> carList = ops.getCarList();
                carTable.setItems((ObservableList<car>) carList);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Car Selected");
            alert.setContentText("Please select a car in the table.");
            alert.showAndWait();
        }
    }
       
    @FXML
    private void handleDeleteCar() {
        AdminPanelController ops = new AdminPanelController();
        car c = carTable.getSelectionModel().getSelectedItem();
        System.out.print(c.getId());
        if (c.getId() >= 0) {
        	ops.deleteCar(c.getId());
            carTable.getItems().remove(carTable.getSelectionModel().getSelectedIndex());
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No car Selected");
            alert.setContentText("Please select a car in the table.");
            alert.showAndWait();
        }
    }
    
    @FXML
    public void searchModels() {
    	System.out.println(searchBar.getText());
        carTable.setItems(carDAO.searchCarByModels(searchBar.getText()));
    }
	
	/**
	 * Fills all text fields to show details about the car.
	 * If the specified car is null, all text fields are cleared.
	 * 
	 * @param car the car or null
	 */
	private void showCarDetails(car c) {
	    if (c != null) {
			VIN.setText(c.getVIN());
			make.setText(c.getMake());
			model.setText(c.getModel());
			model_year.setText(Integer.toString(c.getModel_year()));
			body_class.setText(c.getBody_class());
			regno.setText(c.getRegno());
			rent.setText(Double.toString(c.getRent()));
			availability.setText(c.getAvailability());
			city.setText(c.getCity());

	    } else {
	        // car is null, remove all the text.
			VIN.setText("");
			make.setText("");
			model.setText("");
			model_year.setText("");
			body_class.setText("");
			regno.setText("");
			rent.setText("");
			availability.setText("");
			city.setText("");
	    }
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

    public void updateCarDialog(car ucar) {
        car u = carDAO.findCarById(ucar.getId());
        u = ucar;
        carDAO.updateCar(u);
        System.out.println("Car Updated Success");
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