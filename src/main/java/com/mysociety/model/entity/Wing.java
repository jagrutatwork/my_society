package com.mysociety.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "wings")
public class Wing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "society_id")
    private Society society; // ✅ Society ID

    @OneToMany(mappedBy = "wing")
    private List<Floor> floors;


	public Wing(Long id, String name, Society society, List<Floor> floors) {
		super();
		this.id = id;
		this.name = name;
		this.society = society;
		this.floors = floors;
	}

	public Wing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Wing [id=" + id + ", name=" + name + ", society=" + society + ", floors=" + floors + "]";
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

	public Society getSociety() {
		return society;
	}

	public void setSociety(Society society) {
		this.society = society;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}  
	
    
}
