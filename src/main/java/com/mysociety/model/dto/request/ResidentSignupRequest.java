package com.mysociety.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ResidentSignupRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @Email(message = "Valid email is required")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @NotBlank(message = "Wing name is required")
    private String wingName; // Wing Name, not ID

    @NotNull(message = "Floor number is required")
    private Integer floorNumber; // Floor Number, not ID

    @NotBlank(message = "Flat number is required")
    private String flatNumber; // Flat number like "203", "B-204"

    @NotNull(message = "Society ID is required")
    private Long societyId;

    @NotNull(message = "Ownership flag is required")
    private Boolean isOwner;

	@Override
	public String toString() {
		return "ResidentSignupRequest [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", password=" + password + ", wingName=" + wingName + ", floorNumber=" + floorNumber + ", flatNumber="
				+ flatNumber + ", societyId=" + societyId + ", isOwner=" + isOwner + "]";
	}

	public ResidentSignupRequest(@NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Phone number is required") String phoneNumber,
			@Email(message = "Valid email is required") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters long") String password,
			@NotBlank(message = "Wing name is required") String wingName,
			@NotNull(message = "Floor number is required") Integer floorNumber,
			@NotBlank(message = "Flat number is required") String flatNumber,
			@NotNull(message = "Society ID is required") Long societyId,
			@NotNull(message = "Ownership flag is required") Boolean isOwner) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.wingName = wingName;
		this.floorNumber = floorNumber;
		this.flatNumber = flatNumber;
		this.societyId = societyId;
		this.isOwner = isOwner;
	}

	public ResidentSignupRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWingName() {
		return wingName;
	}

	public void setWingName(String wingName) {
		this.wingName = wingName;
	}

	public Integer getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(Integer floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public Long getSocietyId() {
		return societyId;
	}

	public void setSocietyId(Long societyId) {
		this.societyId = societyId;
	}

	public Boolean getIsOwner() {
		return isOwner;
	}

	public void setIsOwner(Boolean isOwner) {
		this.isOwner = isOwner;
	}
	
	
    // --- Getters and Setters ---
    // (generate via IDE)
    

}
