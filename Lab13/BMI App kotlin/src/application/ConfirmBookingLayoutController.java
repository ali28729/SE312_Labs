package application;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.hibernate.Session;

import application.hibernate.car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class ConfirmBookingLayoutController  implements Initializable  {
	@FXML
    private TableView<car> bookingTable;

    @FXML
    private TableColumn<car, String> userColumn;
    @FXML
    private TableColumn<car, String> carModelColumn;
	
	@FXML
	private Label VIN;
	@FXML
	private Label make;
	@FXML
	private Label model;
	@FXML
	private Label user;
	@FXML
	private Label status;
	@FXML
	private Label date;

	private Main mainApp;
	private BorderPane border;


	public ConfirmBookingLayoutController() {
		// TODO Auto-generated constructor stub
	}
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }


	public void setBorder(BorderPane rootLayout) {
		this.border = rootLayout;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Session session = null;
        try {
//            session = HibernateConnector.getInstance().getSession();
//            car category = new car("Hibernate Framework", null, null, null, null, null, null, null, null);
//            
//            user articleOne = new Article("One-to-One Mapping",
//                    "One-to-One XML Mapping Tutorial", "Hibernate,One-to-One",
//                    "Content of One-to-One XML Mapping Tutorial");
//            Article articleTwo = new Article("One-to-Many Mapping",
//                    "One-to-Many XML Mapping Tutorial", "Hibernate,One-to-Many",
//                    "Content of One-to-Many XML Mapping Tutorial");
//            Article articleThree = new Article("Many-to-Many Mapping",
//                    "Many-to-Many XML Mapping Tutorial", "Hibernate,Many-to-Many",
//                    "Content of Many-to-Many XML Mapping Tutorial");
//     
//            Set<user> articles = new HashSet<user>();
//            articles.add(articleOne);
//            articles.add(articleTwo);
//            articles.add(articleThree);
//     
//            category.setArticles(articles);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            session.close();
        }
	}
  	

}
