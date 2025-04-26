package com.mysociety.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DeliveryApproval {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String note; // optional: "Grocery", "Food", etc.

	private LocalDateTime requestedAt;
	private LocalDateTime respondedAt;

	private Boolean approved; // null = pending, true = approved, false = rejected

	@ManyToOne
	private Flat flat;

	@ManyToOne
	private User requestedBy; // guard

	@ManyToOne
	private User respondedBy; // resident

	@Override
	public String toString() {
		return "DeliveryApproval [id=" + id + ", note=" + note + ", requestedAt=" + requestedAt + ", respondedAt="
				+ respondedAt + ", approved=" + approved + ", flat=" + flat + ", requestedBy=" + requestedBy
				+ ", respondedBy=" + respondedBy + "]";
	}

	public DeliveryApproval() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryApproval(Long id, String note, LocalDateTime requestedAt, LocalDateTime respondedAt,
			Boolean approved, Flat flat, User requestedBy, User respondedBy) {
		super();
		this.id = id;
		this.note = note;
		this.requestedAt = requestedAt;
		this.respondedAt = respondedAt;
		this.approved = approved;
		this.flat = flat;
		this.requestedBy = requestedBy;
		this.respondedBy = respondedBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public LocalDateTime getRequestedAt() {
		return requestedAt;
	}

	public void setRequestedAt(LocalDateTime requestedAt) {
		this.requestedAt = requestedAt;
	}

	public LocalDateTime getRespondedAt() {
		return respondedAt;
	}

	public void setRespondedAt(LocalDateTime respondedAt) {
		this.respondedAt = respondedAt;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Flat getFlat() {
		return flat;
	}

	public void setFlat(Flat flat) {
		this.flat = flat;
	}

	public User getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(User requestedBy) {
		this.requestedBy = requestedBy;
	}

	public User getRespondedBy() {
		return respondedBy;
	}

	public void setRespondedBy(User respondedBy) {
		this.respondedBy = respondedBy;
	}

}
