package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_gift")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Gift {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int no;

	@Column(length = 20)
	String name;

	@Column(length = 20)
	String type;

	@Column
	int price;

}
