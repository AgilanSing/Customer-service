package com.customerservice.entity;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by IntelliJ IDEA.
 * Project : Customer Service
 * User: Agilan 
 * Email: agilan92@gmail.com
 */
@Entity
@Table(name = "CUST_TABLE")
@ApiModel(description = "Customer data")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Customer {
	@Column(name = "ID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "Unique identifier of the Customer.", example = "1", required = true, position = 0)
	private Integer id;

	@NotEmpty(message = "FirstName should not allowed empty values")
	@Column(name = "First_Name", nullable = false)
	@Size(max = 10, min = 5, message = "The First Name '${validatedValue}' must be between {min} and {max} characters long")
	@ApiModelProperty(notes = "Customer first Name", example = "Agilan", required = true, position = 1)
	private String firstName;

	@NotEmpty(message = "lastName should not allowed empty values")
	@ApiModelProperty(notes = "Customer Last Name", example = "Agilan", required = true, position = 2)
	@Size(max = 10, min = 5, message = "The Last Name '${validatedValue}' must be between {min} and {max} characters long")
	@Column(name = "Last_Name", nullable = false)
	private String lastName;

	@Column(name = "Gender", nullable = true, length = 1)
	@Size(max = 1, min = 1)
	@Pattern(regexp = "M|F|T|O", message = "Gender value '${validatedValue}' must be M- Male F- Female T-Transgenders O-Others")
	@ApiModelProperty(notes = "Customer Gender. M- Male F- Female T-Transgenders O-Others", example = "M", required = false, position = 3)
	private String gender;

	@Column(name = "Age", nullable = true, length = 3)
	@Min(value = 1)
	@Max(value = 140)
	@ApiModelProperty(notes = "Customer Age", example = "22", required = true, position = 4)
	@NotNull(message = "age should not allowed null value")
	private Integer age;

	@Column(name = "PhoneNumber", nullable = true, length = 10)
	@Size(max = 10, min = 10)
	@ApiModelProperty(notes = "Customer Phone Number", example = "9876543210", required = true, position = 5)
	@NotEmpty(message = "phone number should not allowed empty")
	private String phoneNumber;

	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@ApiModelProperty(notes = "Customer Creation date", required = false, position = 6)
	private Date createdAt;

	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	@ApiModelProperty(notes = "Customer data updation date", required = false, position = 7)
	private Date updatedAt;

	public Customer(String firstName, String lastName, String gender, int age, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public Customer() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}