package com.jspiders.hibernatemanytomanybidirectional.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class StudDTO {
	@Id
	private int id;
	private String name;
	private String email;
	private String address;
	@ManyToMany
	private List<SubDTO> subj;
}
