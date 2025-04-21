package com.mysociety.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminSignupRequest {

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

    @NotNull(message = "Society ID is required")
    private Long societyId;

	public AdminSignupRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminSignupRequest(@NotBlank(message = "Name is required") String name,
			@NotBlank(message = "Phone number is required") String phoneNumber,
			@Email(message = "Valid email is required") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters long") String password,
			@NotNull(message = "Society ID is required") Long societyId) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.societyId = societyId;
	}

	@Override
	public String toString() {
		return "AdminSignupRequest [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password="
				+ password + ", societyId=" + societyId + "]";
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

	public Long getSocietyId() {
		return societyId;
	}

	public void setSocietyId(Long societyId) {
		this.societyId = societyId;
	}

}