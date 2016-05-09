package com.example.gradelog;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseConnect extends SQLiteOpenHelper {
	// The name of the db
	private static final String DATABASE_NAME = "gradelog";
	
	// The version of the db (specific to this app)
	private static final int DATABASE_VERSION = 1;
	
	// Define the names of the tables
	public static final String COURSE_TABLE = "course";
	public static final String CATEGORY_TABLE = "category";
	public static final String GRADE_TABLE = "grade";
	
	// Define the fields of the course table
	public static final String COURSE_ID = "_id";
	public static final String COURSE_NAME = "course_name";
	public static final String COURSE_EARNED = "course_earned_points";
	public static final String COURSE_MAX = "course_max_points";	
	
	// Define the fields of the category table
	public static final String CATEGORY_ID = "_id";
	public static final String CATEGORY_NAME = "category_name";
	public static final String CATEGORY_WEIGHT = "category_weight";
	public static final String CATEGORY_EARNED = "category_earned_points";
	public static final String CATEGORY_MAX = "category_max_points";
	public static final String CATEGORY_COURSE = "course_id";
	
	// Define the fields of the grade table
	public static final String GRADE_ID = "_id";
	public static final String GRADE_NAME = "grade_name";
	public static final String GRADE_EARNED = "grade_earned_points";
	public static final String GRADE_MAX = "grade_max_points";
	public static final String GRADE_CATEGORY = "category_id";
	
	public DatabaseConnect(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		createCourseTable(db);
		createCategoryTable(db);
		createGradeTable(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int prevVers, int currVers) {
	    Log.w(DatabaseConnect.class.getName(),
            "Upgrading database from version " + prevVers + " to "
                + currVers + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + COURSE_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + GRADE_TABLE);
        onCreate(db);
	}
	
	private void createCourseTable(SQLiteDatabase db) {
		// Create the query string
		String query = "create table " + COURSE_TABLE + "("
				+ COURSE_ID + " integer primary key autoincrement, "
				+ COURSE_NAME + " text not null, "
				+ COURSE_EARNED + " decimal not null default 0, "
				+ COURSE_MAX + " decimal not null default 0"
				+ ");";
		
		// Execute the query
		db.execSQL(query);
	}
	
	private void createCategoryTable(SQLiteDatabase db) {
		// Create the query string
		String query = "create table " + CATEGORY_TABLE + "("
				+ CATEGORY_ID + " integer primary key autoincrement, "
				+ CATEGORY_NAME + " text not null, "
				+ CATEGORY_WEIGHT + " decimal not null default 100, "
				+ CATEGORY_EARNED + " decimal not null default 0, "
				+ CATEGORY_MAX + " decimal not null default 0, "
				+ CATEGORY_COURSE + " integer, "
				+ "foreign key (" + CATEGORY_COURSE + ") references "
				+ COURSE_TABLE + "(" + COURSE_ID + ")"
				+ "on delete cascade);";
		
		// Execute the query
		db.execSQL(query);
	}
	
	private void createGradeTable(SQLiteDatabase db) {
		// Create the query string
		String query = "create table " + GRADE_TABLE + "("
				+ GRADE_ID + " integer primary key autoincrement, "
				+ GRADE_NAME + " text not null, "
				+ GRADE_EARNED + " decimal not null default 0, "
				+ GRADE_MAX + " decimal not null default 0, "
				+ GRADE_CATEGORY + " integer, "
				+ "foreign key (" + GRADE_CATEGORY + ") references "
				+ CATEGORY_TABLE + "(" + CATEGORY_ID + ")"
				+ "on delete cascade);";
		
		// Execute the query
		db.execSQL(query);		
	}
}
