package com.luv2code.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;


import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	// column names and define names of the params
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	

	
	
	// create constructors
	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	
	// getter and setter
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	// to - string
	@Override
	public String toString() {
		return "InstructorDetail [Id=" + Id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + ", "
				// required at end
				+"]";
	}
	
	// ----------------------- Bi directional code added here ---------------------------------------
	
	// This is explicit for Bidirection -- remove if unidirection required
		// This was done to modify from CascadeType.ALL to make sure we save the instructor when we delete the detail
		@OneToOne(mappedBy="instructorDetail", cascade= {CascadeType.DETACH , CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
		private Instructor instructor;

	// This is explicit for Bidirection -- remove if unidirection required
		public Instructor getInstructor() {
			return instructor;
		}
		
	// This is explicit for Bidirection -- remove if unidirection required
		public void setInstructor(Instructor instructor) {
			this.instructor = instructor;
		}
		
		

	
	
	
}
