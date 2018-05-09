package application.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class car implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String VIN;
	private String make;
	private String model;
	private Integer model_year;
	private String body_class;
	private String regno;
	private Double rent;
	private String availability;
	private String city;
	
    public car (String vin, String make, String model, Integer model_year, String body_class, String regno, Double rent, String availability, String city) {
        this.VIN = vin;
        this.model = model;
        this.make = make;
        this.model_year = model_year;
        this.city = city;
        this.availability = availability;
        this.rent = rent;
        this.regno = regno;
        this.body_class = body_class;
    }

    public car() {
		// TODO Auto-generated constructor stub
    	this("Enter VIN of your car", "Maker of the car", "Model of the Car",2018,"Body category of the car e.g. Sedan","XXX000",(double) 564,"available","Registration City");
	}

	@Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
    @Column(name = "VIN", length = 100)
	public String getVIN() {
		return VIN;
	}
	public void setVIN(String vIN) {
		VIN = vIN;
	}
	
    @Column(name = "make", length = 30)
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	
    @Column(name = "model", length = 50)
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	
    @Column(name = "model_year", length = 10)
	public Integer getModel_year() {
		return model_year;
	}
	public void setModel_year(Integer model_year) {
		this.model_year = model_year;
	}
	
    @Column(name = "body_class", length = 50)
	public String getBody_class() {
		return body_class;
	}
	public void setBody_class(String body_class) {
		this.body_class = body_class;
	}
	
    @Column(name = "regno", length = 50)
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	
    @Column(name = "rent")
	public Double getRent() {
		return rent;
	}
	public void setRent(Double rent) {
		this.rent = rent;
	}
	
    @Column(name = "availability", length = 50)
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	
    @Column(name = "city", length = 30)
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}