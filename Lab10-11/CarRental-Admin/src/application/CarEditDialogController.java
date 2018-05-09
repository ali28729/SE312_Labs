package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import application.hibernate.CarDAO;
import application.hibernate.car;


public class CarEditDialogController {

	@FXML
	private TextField VIN;
	@FXML
	private TextField make;
	@FXML
	private TextField model;
	@FXML
	private TextField model_year;
	@FXML
	private TextField body_class;
	@FXML
	private TextField regno;
	@FXML
	private TextField rent;
	@FXML
	private TextField availability;
	@FXML
	private TextField city;


    private Stage dialogStage;
    private car c;
    private boolean okClicked = false;
	private BorderPane border;
	CarDAO carDAO = new CarDAO();
    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }

    
	public void setBorder(BorderPane rootLayout) {
		this.border = rootLayout;
	}
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Sets the stage of this dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    

    /**
     * Sets the person to be edited in the dialog.
     * 
     * @param person
     */
    public void setCar(car c) {
        this.c = c;
		VIN.setText(c.getVIN());
		make.setText(c.getMake());
		model.setText(c.getModel());
		model_year.setText(Integer.toString(c.getModel_year()));
		body_class.setText(c.getBody_class());
		regno.setText(c.getRegno());
		rent.setText(Double.toString(c.getRent()));
		availability.setText(c.getAvailability());
		city.setText(c.getCity());
        regno.setPromptText("XXX000");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            c.setVIN(VIN.getText());
            c.setMake(make.getText());
            c.setModel(model.getText());
            c.setModel_year(Integer.parseInt(model_year.getText()));
            c.setBody_class(body_class.getText());
            c.setRegno(regno.getText());
            c.setRent(Double.parseDouble(rent.getText()));
            c.setAvailability(availability.getText());
            c.setCity(city.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     * 
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";



        if (VIN.getText() == null || VIN.getText().length() == 0) {
            errorMessage += "No valid VIN!\n"; 
        }
        if (make.getText() == null || make.getText().length() == 0) {
            errorMessage += "No valid make!\n"; 
        }
        if (model.getText() == null || model.getText().length() == 0) {
            errorMessage += "No valid model!\n"; 
        }

        if (model_year.getText() == null || model_year.getText().length() == 0) {
            errorMessage += "No valid Model Year!\n"; 
        } else {
            // try to parse the model year into an int.
            try {
                Integer.parseInt(model_year.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid Model Year (must be an integer)!\n"; 
            }
        }

        if (body_class.getText() == null || body_class.getText().length() == 0) {
            errorMessage += "No valid Body Class!\n"; 
        }
        
        if (regno.getText() == null || regno.getText().length() == 0) {
            errorMessage += "No valid Reg no!\n"; 
        }

        if (rent.getText() == null || rent.getText().length() == 0) {
            errorMessage += "No valid rent!\n";
        } else {
            // try to parse the rent into a double.
            try {
                Double.parseDouble(rent.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid rent (must be a Double)!\n"; 
            }
        }

        if (availability.getText() == null || availability.getText().length() == 0) {
            errorMessage += "No valid availability!\n"; 
        }
        
        if (city.getText() == null || city.getText().length() == 0) {
            errorMessage += "No valid city!\n"; 
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}