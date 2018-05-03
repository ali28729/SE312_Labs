package application.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user {
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phoneno;
	}
	public void setPhone(long phoneno) {
		this.phoneno = phoneno;
	}
	public long getCnic() {
		return cnic;
	}
	public void setCnic(long cnic) {
		this.cnic = cnic;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	@Id
	private int id;
	private String username;
	private String password;
	private long phoneno;
	private long cnic;
	private String privilege;
}
