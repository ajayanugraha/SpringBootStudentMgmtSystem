package com.example.demo.model;


	import java.io.Serializable;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="internalreport")

	public class InternalReport implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		
		@Column(name = "roll")
		private int roll;
		
		@Column(name="physicsMarks")
		private int physicsMarks;
		

		@Column(name="chemistryMarks")
		private int chemistryMarks;

		@Column(name="mathsMarks")
		private int mathsMarks;
		
		@Column(name="internalNumber")
		private int internalNumber;

		
		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public int getRoll() {
			return roll;
		}


		public void setRoll(int roll) {
			this.roll = roll;
		}


		public int getPhysicsMarks() {
			return physicsMarks;
		}


		public void setPhysicsMarks(int physicsMarks) {
			this.physicsMarks = physicsMarks;
		}


		public int getChemistryMarks() {
			return chemistryMarks;
		}


		public void setChemistryMarks(int chemistryMarks) {
			this.chemistryMarks = chemistryMarks;
		}


		public int getMathsMarks() {
			return mathsMarks;
		}


		public void setMathsMarks(int mathsMarks) {
			this.mathsMarks = mathsMarks;
		}


		public int getInternalNumber() {
			return internalNumber;
		}


		public void setInternalNumber(int internalNumber) {
			this.internalNumber = internalNumber;
		}


		public InternalReport(){
			
		}


		public InternalReport(int roll, int physicsMarks, int chemistryMarks, int mathsMarks, int internalNumber) {
			super();
			this.roll = roll;
			this.physicsMarks = physicsMarks;
			this.chemistryMarks = chemistryMarks;
			this.mathsMarks = mathsMarks;
			this.internalNumber = internalNumber;
		}

		
		

}
