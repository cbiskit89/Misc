package com.example.gradelog;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CourseDataSource {
	private SQLiteDatabase db;
	private DatabaseConnect dbHelper;
	private String[] dbFields = { 
		DatabaseConnect.COURSE_ID, 
		DatabaseConnect.COURSE_NAME,
		DatabaseConnect.COURSE_EARNED,
		DatabaseConnect.COURSE_MAX 
	};
	private String tableName = DatabaseConnect.COURSE_TABLE;
	
	public CourseDataSource (Context context) {
		dbHelper = new DatabaseConnect(context);
	}
	
	public void open() {
		db = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public Course createCourse(String name) {
		ContentValues values = new ContentValues();
		values.put(DatabaseConnect.COURSE_NAME, name);
		long insertId = db.insert(tableName, null, values);
		Cursor cursor = db.query(DatabaseConnect.COURSE_TABLE, 
				dbFields,
				DatabaseConnect.COURSE_ID + " = " + insertId,
				null,
				null,
				null,
				null);
		cursor.moveToFirst();
		Course course = cursorToCourse(cursor);
		cursor.close();
		return course;
	}
	
	public void deleteCourse(int courseId) {
		db.delete(tableName, DatabaseConnect.COURSE_ID + " = " + courseId, null);
	}
	
	public List<Course> getAllCourses() {
		List<Course> courses = new ArrayList<Course>();
		Cursor cursor = db.query(tableName, dbFields, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Course course = cursorToCourse(cursor);
			courses.add(course);
			cursor.moveToNext();
		}
		
		return courses;
	}
	
	public Course getCourseById(int courseId) {
		Course course = new Course();
		Cursor cursor = db.query(
				tableName, 
				dbFields, 
				"_id = " + courseId, 
				null, 
				null, 
				null, 
				null);
		cursor.moveToFirst();
		course = cursorToCourse(cursor);
		return course;
	}
	
	public void updatePointsById(int courseId, float earned, float possible) {
		ContentValues values = new ContentValues();
		values.put(DatabaseConnect.COURSE_EARNED, earned);
		values.put(DatabaseConnect.COURSE_MAX, possible);
		db.update(tableName, values, "_id = " + courseId, null);
	}
	
	private Course cursorToCourse(Cursor cursor) {
		Course course = new Course();
		course.setId(cursor.getInt(0));
		course.setName(cursor.getString(1));
		course.setPoints_earned(cursor.getFloat(2));
		course.setMax_points(cursor.getFloat(3));
		return course;
	}
}
