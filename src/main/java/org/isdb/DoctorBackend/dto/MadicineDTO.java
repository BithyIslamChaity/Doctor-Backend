package org.isdb.DoctorBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MadicineDTO {

	private String name;
	private String strength;
	private String generic;
	private String type;
	private String company;
}
