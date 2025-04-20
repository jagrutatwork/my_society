package com.mysociety.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flats")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flatNumber;

    @ManyToOne
    @JoinColumn(name = "floor_id")
    private Floor floor;

    @ManyToOne
    @JoinColumn(name = "wing_id")
    private Wing wing;

    @ManyToOne
    @JoinColumn(name = "society_id")
    private Society society; // ✅ Direct Society ID

    @Enumerated(EnumType.STRING)
    private FlatStatus flatStatus = FlatStatus.VACANT;

	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flat(Long id, String flatNumber, Floor floor, Wing wing, Society society,
			com.mysociety.model.entity.FlatStatus flatStatus) {
		super();
		this.id = id;
		this.flatNumber = flatNumber;
		this.floor = floor;
		this.wing = wing;
		this.society = society;
		this.flatStatus = flatStatus;
	}

	@Override
	public String toString() {
		return "Flat [id=" + id + ", flatNumber=" + flatNumber + ", floor=" + floor + ", wing=" + wing + ", society="
				+ society + ", flatStatus=" + flatStatus + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public Floor getFloor() {
		return floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
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

	public FlatStatus getFlatStatus() {
		return flatStatus;
	}

	public void setFlatStatus(FlatStatus flatStatus) {
		this.flatStatus = flatStatus;
	}

}
