package com.jspiders.hibernateonetoone.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AdharDTO {
		@Id
		private int id;
		private long aadhar_no;
		private String doj;
}
