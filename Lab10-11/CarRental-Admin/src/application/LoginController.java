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

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import application.hibernate.*;

public class LoginController {
	@FXML
	private Button login;
	@FXML
	private PasswordField pass;
	@FXML
	private TextField username;
	private static SessionFactory sessionf; 
	private BorderPane border;

	public void setBorder(BorderPane rootLayout) {
		this.border = rootLayout;
	}
	public void loginButtonClick(ActionEvent event){
		try {
			sessionf =  new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) { 
		     System.err.println("Failed to create sessionFactory object." + ex);
		     throw new ExceptionInInitializerError(ex); 
		}
		checkUser();
	
//		user u = new user();
//		u.setCnic(61154654);
//		u.setPhone(61154654);
//		u.setPassword(pass.getText());
//		u.setUsername(username.getText());	
//		SessionFactory sessionf =  new Configuration().configure().buildSessionFactory();
//		Session session = sessionf.openSession();
//		session.beginTransaction();
//		session.save(u);
//		session.getTransaction().commit();
//		session.close();
//		sessionf.close();	      
//		System.out.println(pass.getText());
//		System.out.println(username.getText());
	}
	
	public void checkUser() {
		Session session = sessionf.openSession();
	    Transaction tx = null; 
	    boolean flag = false;
		try {
		    tx = session.beginTransaction();
		    List user = session.createQuery("FROM user").list(); 
		    for (Iterator iterator = user.iterator(); iterator.hasNext();){
			    user u = (user) iterator.next(); 
			    if(u.getUsername().equals(username.getText()) && u.getPassword().equals(pass.getText()) ) {
			    	if(u.getPrivilege().equals("admin")) {
				    	System.out.println("logged in!");
				    	try {
					    	FXMLLoader loader = new FXMLLoader();
				            loader.setLocation(Main.class.getResource("AdminPanel.fxml"));
				            AnchorPane personPanel = (AnchorPane) loader.load();
				            border.setCenter(personPanel);
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
		    tx.commit();
		} catch (HibernateException e) {
		     if (tx!=null) tx.rollback();
		     e.printStackTrace(); 
		} finally {
		     session.close(); 
		}
	}

}
