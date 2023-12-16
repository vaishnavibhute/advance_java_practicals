package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class PersonDTO {
	@Id
		private int id;
		private String name;
		private long contact;
		private String DOB;
		private String address;
		
		@OneToOne
		private AdharDTO aadhar;
}
