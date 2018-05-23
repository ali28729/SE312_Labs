package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.List;

import application.hibernate.*;

public class LoginController {
	@FXML
	private Button login;
	@FXML
	private PasswordField pass;
	@FXML
	private TextField username;
	private BorderPane border;
    userDAO UserDAO = new userDAO();
    private Main mainApp;

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
	public void setBorder(BorderPane rootLayout) {
		this.border = rootLayout;
	}
	
	public void loginButtonClick(ActionEvent event){
        LoginController ops = new LoginController();
        boolean flag = false;
        List<user> userList = ops.getUserList();
        
        if (userList != null) {
            for (user u : userList) {
        	    if(u.getUsername().equals(username.getText()) && u.getPassword().equals(pass.getText()) ) {
        	    	if(u.getPrivilege().equals("admin")) {
        		    	try {
        			    	FXMLLoader loader = new FXMLLoader();
        		            loader.setLocation(Main.class.getResource("AdminPanel.fxml"));
        		            AnchorPane personPanel = (AnchorPane) loader.load();
        		            border.setCenter(personPanel);
        		            AdminPanelController panelC = loader.getController();
        		            panelC.setBorder(border);
        		            panelC.setMainApp(mainApp);

        		    	} catch (IOException e) {
        		            e.printStackTrace();
        		        }
        		    	return;
        	    	}
        	    	else {
        	    		flag = true;
        	    		break;
        	    	}
        	    }
        	}
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Login Error");
            if(flag)
            	alert.setHeaderText("User doesn't have this privelege level!");
            else 
            	alert.setHeaderText("Invalid Username or Password!");
            alert.showAndWait();
        }
	}

    public user createUser() {
        user s = new user();
        s.setUsername("Ali yo");
        s.setPassword("John");
        s.setPhone(12);
        s.setCnic(007);
        s.setPrivilege("Available");
        UserDAO.addUser(s);
        return s;
    }

    public void updateUser(Integer id) {
        user u = UserDAO.findUserById(id);
        u.setUsername("online tutorials point");
        UserDAO.updateUser(u);
        System.out.println("User Updated Success");
    }

    public void deleteUser(Integer id) {
    	UserDAO.deleteUser(id);
        System.out.println("User Deleted Success");
    }

    public List<user> getUserList() {
        return UserDAO.listUser();
    }

    public user getUser(Integer id) {
        return UserDAO.findUserById(id);
    }

}
