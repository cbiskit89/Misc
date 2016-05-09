package com.example.gradelog;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class CategoryDataSource {
	private SQLiteDatabase db;
	private DatabaseConnect dbHelper;
	private String[] dbFields = {
			DatabaseConnect.CATEGORY_ID,
			DatabaseConnect.CATEGORY_NAME,
			DatabaseConnect.CATEGORY_WEIGHT,
			DatabaseConnect.CATEGORY_EARNED,
			DatabaseConnect.CATEGORY_MAX,
			DatabaseConnect.CATEGORY_COURSE
	};
	private String tableName = DatabaseConnect.CATEGORY_TABLE;
	
	public CategoryDataSource (Context context) {
		dbHelper = new DatabaseConnect(context);
	}
	
	public void open() {
		db = dbHelper.getWritableDatabase();
	}
	
	public void close() {
		dbHelper.close();
	}
	
	public Category createCategory(String name, float weight, int courseId) {
		ContentValues values = new ContentValues();
		values.put(DatabaseConnect.CATEGORY_NAME, name);
		values.put(DatabaseConnect.CATEGORY_WEIGHT, weight);
		values.put(DatabaseConnect.CATEGORY_COURSE, courseId);
		long insertId = db.insert(tableName, null, values);
		Cursor cursor = db.query(tableName, 
				dbFields, 
				DatabaseConnect.CATEGORY_ID + " = " + insertId, 
				null, 
				null, 
				null, 
				null);
		cursor.moveToFirst();
		Category category = cursorToCategory(cursor);
		cursor.close();
		return category;
	}
	
	public void deleteCategory(Category category) {
		long id = category.getId();
		db.delete(tableName, DatabaseConnect.CATEGORY_ID + " = " + id, null);
	}
	
	public List<Category> getAllCategories(int courseId) {
		List<Category> categories = new ArrayList<Category>();
		Cursor cursor = db.query(tableName, dbFields, "course_id = " + courseId, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Category category = cursorToCategory(cursor);
			categories.add(category);
			cursor.moveToNext();
		}
		
		return categories;
	}
	
	public Category getCategoryById(int categoryId) {
		Cursor cursor = db.query(
				tableName, 
				dbFields, 
				"_id = " + categoryId, 
				null, 
				null, 
				null, 
				null);
		cursor.moveToFirst();
		Category category = cursorToCategory(cursor);
		cursor.close();
		return category;
	}
	
	public void updatePointsById(int categoryId, float earned, float possible) {
		ContentValues values = new ContentValues();
		values.put(DatabaseConnect.CATEGORY_EARNED, earned);
		values.put(DatabaseConnect.CATEGORY_MAX, possible);
		db.update(tableName, values, "_id = " + categoryId, null);
	}
	
	private Category cursorToCategory(Cursor cursor) {
		Category category = new Category();
		category.setId(cursor.getInt(0));
		category.setName(cursor.getString(1));
		category.setWeight(cursor.getFloat(2));
		category.setPoints_earned(cursor.getFloat(3));
		category.setMax_points(cursor.getFloat(4));
		return category;
	}
}
