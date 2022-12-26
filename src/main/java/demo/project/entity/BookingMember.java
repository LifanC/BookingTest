package demo.project.entity;

import javax.persistence.*;

@Entity
@Table(name = "bookingMember")
public class BookingMember {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="client_name")
	private String clientName;
	@Column(name="email")
	private String email;
	@Column(name="phone_number")
	private String phoneNumber;
	public BookingMember() {}
	public BookingMember(String clientName) {
		this.clientName = clientName;
	}
	
	
	public BookingMember(String clientName, String phoneNumber, Integer id) {
		this.clientName = clientName;
		this.phoneNumber = phoneNumber;
		this.id = id;
	}
	public BookingMember(Integer id, String clientName, String email, String phoneNumber) {
		this.id = id;
		this.clientName = clientName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "BookingMember [id=" + id + ", clientName=" + clientName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
}
