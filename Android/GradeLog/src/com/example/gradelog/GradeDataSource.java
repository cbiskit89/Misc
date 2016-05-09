package com.example.gradelog;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class GradeDataSource {
	private SQLiteDatabase db;
	private DatabaseConnect dbHelper;
	private String[] dbFields = {
			DatabaseConnect.GRADE_ID,
			DatabaseConnect.GRADE_NAME,
			DatabaseConnect.GRADE_EARNED,
			DatabaseConnect.GRADE_MAX,
			DatabaseConnect.GRADE_CATEGORY
	};
	
	public GradeDataSource(Context context) {
		dbHelper = new DatabaseConnect(context);
	}
	
	public void open() {
		db = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public Grade createGrade(String gradeName, float pointsEarned, float pointsPossible, int categoryId) {
		Grade grade;
		ContentValues values = new ContentValues();
		values.put(DatabaseConnect.GRADE_NAME, gradeName);
		values.put(DatabaseConnect.GRADE_EARNED, pointsEarned);
		values.put(DatabaseConnect.GRADE_MAX, pointsPossible);
		values.put(DatabaseConnect.GRADE_CATEGORY, categoryId);
		long insertId = db.insert(DatabaseConnect.GRADE_TABLE, null, values);
		Cursor cursor = db.query(
				DatabaseConnect.GRADE_TABLE, 
				dbFields, 
				DatabaseConnect.GRADE_ID + " = " + insertId, 
				null, 
				null, 
				null, 
				null);
		cursor.moveToFirst();
		grade = cursorToGrade(cursor);
		return grade;
	}
	
	public void deleteGrade(int id) {
		db.delete(
				DatabaseConnect.GRADE_TABLE, 
				DatabaseConnect.GRADE_ID + " = " + id, 
				null);
	}
	
	public List<Grade> getGradesFromCourse(int categoryId) {
		List<Grade> grades = new ArrayList<Grade>();
		Cursor cursor = db.query(
				DatabaseConnect.GRADE_TABLE, 
				dbFields, 
				"category_id = " + categoryId, 
				null, 
				null, 
				null, 
				null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Grade grade = cursorToGrade(cursor);
			grades.add(grade);
			cursor.moveToNext();
		}
		return grades;
	}
	
	private Grade cursorToGrade(Cursor cursor) {
		Grade grade = new Grade();
		grade.setId(cursor.getInt(0));
		grade.setName(cursor.getString(1));
		grade.setPoints_earned(cursor.getFloat(2));
		grade.setMax_points(cursor.getFloat(3));
		grade.setCategory_id(cursor.getInt(4));
		return grade;
	}
}
