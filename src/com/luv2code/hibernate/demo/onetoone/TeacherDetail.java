package com.luv2code.hibernate.demo.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teacher_detail")
public class TeacherDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="blog_website")
	private String blogWebsite;

	@Column(name="hobby")
	private String hobby;
	
	public TeacherDetail() {
		
	}

	public TeacherDetail(String blogWebsite, String hobby) {
		this.blogWebsite = blogWebsite;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBlogWebsite() {
		return blogWebsite;
	}

	public void setBlogWebsite(String blogWebsite) {
		this.blogWebsite = blogWebsite;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "TeacherDetail [id=" + id + ", blogWebsite=" + blogWebsite + ", hobby=" + hobby + "]";
	}
	
}
