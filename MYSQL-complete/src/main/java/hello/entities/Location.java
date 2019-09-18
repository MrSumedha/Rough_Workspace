package hello.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Location {
	@Id
	@GeneratedValue
	private Integer id;

	private String cityName;

	private String countryName;
}
