package application;
	
import java.io.IOException;

import org.hibernate.SessionFactory;

import application.hibernate.car;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	private Stage primaryStage;
	@FXML
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		try {
			this.primaryStage = primaryStage;
	        this.primaryStage.setTitle("CarRental");
	        this.primaryStage.getIcons().add(new Image("file:resources/images/logo.png"));
	        initRootLayout();
	        this.primaryStage.setOnCloseRequest(WindowEvent -> this.handle(WindowEvent));
	        showAdminOverview();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the c overview inside the root layout.
     */
    public void showAdminOverview() {
        try {
            // Load c overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AdminOverview.fxml"));
            AnchorPane cOverview = (AnchorPane) loader.load();
            // Set c overview into the center of root layout.
            rootLayout.setCenter(cOverview);   
            LoginController controller = loader.getController();
            controller.setMainApp(this);
            controller.setBorder(rootLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showAdminPanel() {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AdminPanel.fxml"));
            AnchorPane cPanel = (AnchorPane) loader.load();
            // Set c overview into the center of root layout.
            FXMLLoader rootloader = new FXMLLoader(Main.class.getResource("RootLayout.fxml"));
            BorderPane border = rootloader.load();
            System.out.println(border.getId());
            border.setCenter(null);
    	} catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Opens a dialog to edit details for the specified c. If the user
     * clicks OK, the changes are saved into the provided c object and true
     * is returned.
     * 
     * @param c the c object to be edited
     * @return true if the user clicked OK, false otherwise.
     */
    public boolean showCarEditDialog(car c) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("CarEditDialog.fxml"));
            AnchorPane page = (AnchorPane) loader.load();
            

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Car");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);

            // Set the c into the controller.
            CarEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCar(c);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    public void handle(WindowEvent event) {
      System.out.println("exiting");
      System.exit(0);
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
