package dev.rathod.harsh.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String statement;

	@Column(name = "option_1", nullable = false, length = 255)
	private String option1;

	@Column(name = "option_2", nullable = false, length = 255)
	private String option2;

	@Column(name = "option_3", nullable = false, length = 255)
	private String option3;

	@Column(name = "option_4", nullable = false, length = 255)
	private String option4;

	@Column(name = "correct_option", nullable = false)
	private byte correctOption;

	@Column(name = "date_created", columnDefinition = "TIMESTAMP DEFAULT now()")
	private Timestamp dateCreated;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public byte getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(byte correctOption) {
		this.correctOption = correctOption;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
}
