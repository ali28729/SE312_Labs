package application.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class user implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private long phoneno;
	private long cnic;
	private String privilege;
	
	public user() {
    }

    public user(String username, String password, long phoneno, long cnic, String privilege) {
        this.username = username;
        this.password = password;
        this.phoneno = phoneno;
        this.cnic = cnic;
        this.privilege = privilege;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username", length = 30)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password", length = 100)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    @Column(name = "phoneno", length = 20)
	public long getPhone() {
		return phoneno;
	}
	public void setPhone(long phoneno) {
		this.phoneno = phoneno;
	}
	
	@Column(name = "cnic", length = 20)
	public long getCnic() {
		return cnic;
	}
	public void setCnic(long cnic) {
		this.cnic = cnic;
	}
	
	@Column(name = "privilege", length = 255)
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
}
