package com.jspiders.hibernatemanytomanybidirectional.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class SubDTO {
	@Id
	private int id;
	private String name;
	private int duration;
	@ManyToMany(mappedBy = "subj")
	private List<StudDTO> stud;
}
