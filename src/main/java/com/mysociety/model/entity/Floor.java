package com.mysociety.model.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "floors")
public class Floor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer floorNumber;

    @ManyToOne
    @JoinColumn(name = "wing_id")
    private Wing wing;

    @ManyToOne
    @JoinColumn(name = "society_id")
    private Society society; // ✅ Added society link here for fast access!

    @OneToMany(mappedBy = "floor")
    private List<Flat> flats;

	public Floor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Floor(Long id, Integer floorNumber, Wing wing, Society society, List<Flat> flats) {
		super();
		this.id = id;
		this.floorNumber = floorNumber;
		this.wing = wing;
		this.society = society;
		this.flats = flats;
	}

	@Override
	public String toString() {
		return "Floor [id=" + id + ", floorNumber=" + floorNumber + ", wing=" + wing + ", society=" + society
				+ ", flats=" + flats + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public Wing getWing() {
		return wing;
	}

	public void setWing(Wing wing) {
		this.wing = wing;
	}

	public Society getSociety() {
		return society;
	}

	public void setSociety(Society society) {
		this.society = society;
	}

	public List<Flat> getFlats() {
		return flats;
	}

	public void setFlats(List<Flat> flats) {
		this.flats = flats;
	}

    
}
