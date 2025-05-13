package org.isdb.DoctorBackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_medicine")
public class Medicine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String strength;
	private String generic;
	private String type;
	private String company;

	public Medicine(String name, String strength, String generic, String type, String company) {
		this.name = name;
		this.strength = strength;
		this.generic = generic;
		this.type = type;
		this.company = company;
	}

}
