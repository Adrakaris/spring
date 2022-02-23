package hu.yijun.springtutorial1.entity;

import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Builder  // lombok
// see Customer.java for a full lombok thing, I dont want to remove code
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long departmentID;
	@NotBlank(message = "ERROR: department name must not be blank")  // spring-starter-hibernate validation
	private String departmentName;
	private String departmentAddress;
	@Length(max=7, min=5)
	private String departmentCode;

	/*
	Other @Validations
	@Size(max, min)
	@Email
	@Positive
	@Negative
	@PositiveOrZero
	...
	@Past
	@Future
	@PastOrPresent
	 */

	// Note: intellij alt+ins is magic
	public Department(Long departmentID, String departmentName, String departmentAddress, String departmentCode) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
		this.departmentAddress = departmentAddress;
		this.departmentCode = departmentCode;
	}

	public Department() {}

	public Long getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(Long departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentAddress() {
		return departmentAddress;
	}

	public void setDepartmentAddress(String departmentAddress) {
		this.departmentAddress = departmentAddress;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	@Override
	public String toString() {
		return "Department{" +
				"departmentID=" + departmentID +
				", departmentName='" + departmentName + '\'' +
				", departmentAddress='" + departmentAddress + '\'' +
				", departmentCode='" + departmentCode + '\'' +
				'}';
	}
}
