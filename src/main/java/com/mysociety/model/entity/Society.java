package com.mysociety.model.entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "societies")
public class Society {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address; // ✅ Added address

    @OneToMany(mappedBy = "society")
    private List<Wing> wings;

	@Override
	public String toString() {
		return "Society [id=" + id + ", name=" + name + ", address=" + address + ", wings=" + wings + "]";
	}

	public Society(Long id, String name, String address, List<Wing> wings) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.wings = wings;
	}

	public Society() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Wing> getWings() {
		return wings;
	}

	public void setWings(List<Wing> wings) {
		this.wings = wings;
	}
}
