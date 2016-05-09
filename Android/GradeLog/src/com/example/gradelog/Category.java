package com.example.gradelog;

public class Category {
	private int id;
	private String name;
	private float weight;
	private float points_earned;
	private float max_points;
	private int course_id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getWeight() {
		return weight;
	}
	
	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	public float getPoints_earned() {
		return points_earned;
	}
	
	public void setPoints_earned(float points_earned) {
		this.points_earned = points_earned;
	}
	
	public float getMax_points() {
		return max_points;
	}
	
	public void setMax_points(float max_points) {
		this.max_points = max_points;
	}
	
	public int getCourse_id() {
		return course_id;
	}
	
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
}
