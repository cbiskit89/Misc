package com.example.gradelog;

public class Course {
	private int id;
	private String name;
	float points_earned;
	float max_points;

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

}
