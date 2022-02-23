package hu.yijun.springtutorial1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

// Lombok lets us skip the getter setter toString boilerplate

@Entity
@Data  // lombok
// equivalent to doing all the getter setter requiredArgsConstructor toString equalsAndHashcode
@NoArgsConstructor  // the other constructors
@AllArgsConstructor
@Builder  // also a BUILDER!?
public class Customer {

	@Id
	private Long id;

	@NotBlank
	private String names;

	@NotBlank
	private String surname;

	@NotBlank
	@Email
	private String email;

	private String phone;

	@NotBlank
	private String address;
}
