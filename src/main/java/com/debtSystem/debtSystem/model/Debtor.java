package com.debtSystem.debtSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="table_debtor")
@Data
@NoArgsConstructor
public class Debtor {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int Id;
		private String Name;
		private String Phone;
		private String Addres;
		private int debt;
		
}
