package com.example.desafiobc.desafiobc.dto;

import java.io.Serializable;
import java.time.Instant;

import com.example.desafiobc.desafiobc.entities.Client;

public class ClientDTO implements Serializable {	
	private static final long serialVersionUID = 1L;
	
	public Long id;
	public String name;
	public String cpf;
	public Double income;	
	public Instant birthDate;
	public Integer children;
	
	
	public ClientDTO() {		
	}


	public ClientDTO(Long id, String name, String cpf, Double income, Instant birthDate, Integer children) {		
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.birthDate = birthDate;
		this.children = children;
	}

	
	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.income = entity.getIncome();
		this.birthDate = entity.getBirthDate();
		this.children = entity.getChildren();
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Double getIncome() {
		return income;
	}


	public void setIncome(Double income) {
		this.income = income;
	}


	public Instant getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}


	public Integer getChildren() {
		return children;
	}


	public void setChildren(Integer children) {
		this.children = children;
	}
	
}
