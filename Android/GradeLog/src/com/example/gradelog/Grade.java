package com.example.gradelog;

public class Grade {
	private int id;
	private String name;
	private float points_earned;
	private float max_points;
	private int category_id;
	
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
	
	public int getCategory_id() {
		return category_id;
	}
	
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
}
