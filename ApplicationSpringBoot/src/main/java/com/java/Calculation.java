package com.java;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calculations")
public class Calculation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "user")
	private String user;

	@Column(name = "first_value")
	private String first_value;

	@Column(name = "second_value")
	private String second_value;

	@Column(name = "operation_type")
	private String operation_type;

	@Column(name = "operation_answer")
	private String operation_answer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getFirst_value() {
		return first_value;
	}

	public void setFirst_value(String first_value) {
		this.first_value = first_value;
	}

	public String getSecond_value() {
		return second_value;
	}

	public void setSecond_value(String second_value) {
		this.second_value = second_value;
	}

	public String getOperation_answer() {
		return operation_answer;
	}

	public void setOperation_answer(String operation_answer) {
		this.operation_answer = operation_answer;
	}

	public Calculation() {
	}

	public String getOperation_type() {
		return operation_type;
	}

	public void setOperation_type(String operation_type) {
		this.operation_type = operation_type;
	}

	public Calculation(int id, String user, String first_value, String second_value, String operation_type,
			String operation_answer) {
		super();
		this.id = id;
		this.user = user;
		this.first_value = first_value;
		this.second_value = second_value;
		this.operation_type = operation_type;
		this.operation_answer = operation_answer;
	}

	@Override
	public String toString() {
		return "Calculation [id=" + id + ", user=" + user + ", first_value=" + first_value + ", second_value="
				+ second_value + ", operation_type=" + operation_type + ", operation_answer=" + operation_answer + "]";
	}
}
