package com.luv2code.demo.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Entity
@Table(name="instructor")
public class Instructor {

		// column names and define names of the params
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int Id;
		
		@Column(name="first_name")
		private String firstName;
		
		@Column(name="last_name")
		private String lastName;
		
		@Column(name="email")
		private String email;
		
		
		// Foreign key relation ship mapping
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="instructor_detail_id")
		private InstructorDetail instructorDetail;
		
		
		
		// create constructors
		public Instructor() {
			
		}

		// Arg based constructor
		public Instructor(String firstName, String lastName, String email) {
			
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
		}

		// Setter and getters 
		
		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}
		
		public InstructorDetail getInstructorDetail() {
			return instructorDetail;
		}

		public void setInstructorDetail(InstructorDetail instructorDetail) {
			this.instructorDetail = instructorDetail;
		}
		

		// To-String
		@Override
		public String toString() {
			return "Instructor [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
					+ ", instructorDetail=" + instructorDetail + "]";
		}

		
		

		
}