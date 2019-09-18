package hello.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	@Id
	private Integer ssn;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	private Integer deptId;
}
