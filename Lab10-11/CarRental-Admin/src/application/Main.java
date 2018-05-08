package application;
	
import java.io.IOException;

import org.hibernate.SessionFactory;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
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
	        initRootLayout();
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
     * Shows the person overview inside the root layout.
     */
    public void showAdminOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AdminOverview.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);   
            LoginController controller = loader.getController();
            controller.setBorder(rootLayout);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void showAdminPanel() {
    	try {
	    	FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("AdminPanel.fxml"));
            AnchorPane personPanel = (AnchorPane) loader.load();
            // Set person overview into the center of root layout.
            FXMLLoader rootloader = new FXMLLoader(Main.class.getResource("RootLayout.fxml"));
            BorderPane border = rootloader.load();
            System.out.println(border.getId());
            border.setCenter(null);
    	} catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
	
	public static void main(String[] args) {
		launch(args);
	}
}
