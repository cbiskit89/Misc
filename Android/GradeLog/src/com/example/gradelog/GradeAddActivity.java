package com.example.gradelog;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GradeAddActivity extends Activity {
	private int categoryId, courseId, gradeId;
	private List<Category> categories = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grade_add);
		
		Intent intent = getIntent();
		courseId = intent.getIntExtra("courseId", 0); 
		categoryId = intent.getIntExtra("categoryId", 0);
		gradeId = intent.getIntExtra("gradeId", 0);
		final String gradeName = intent.getStringExtra("gradeName");
		final float gradeEarned = intent.getFloatExtra("gradeEarned", 0);
		final float gradePossible = intent.getFloatExtra("gradePossible", 0);
		
		Button saveGrade = (Button) findViewById(R.id.grade_add_btn);
		
		if (intent.getIntExtra("gradeId", 0) != 0) {
			((EditText) findViewById(R.id.grade_add_grade_name)).setText(
					intent.getStringExtra("gradeName"));
			((EditText) findViewById(R.id.grade_add_grade_value)).setText(
					Float.toString(intent.getFloatExtra("gradeEarned", 0)));
			((EditText) findViewById(R.id.grade_add_grade_total)).setText(
					Float.toString(intent.getFloatExtra("gradePossible", 0)));
			saveGrade.setText("Delete");
		}
		
		if (saveGrade.getText() != "Delete") {		
			saveGrade.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					validateGrade();
				}
			});
		}
		else {
			saveGrade.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					deleteGrade(gradeId);
					updateCategory(gradeEarned * -1, gradePossible * -1);
					updateCourse();
					Toast.makeText(
							getApplicationContext(), 
							gradeName + " successfully deleted.", 
							Toast.LENGTH_SHORT).show();
					finish();
				}
			});
		}
	}
	
	private void validateGrade() {
		EditText gradeNameET = (EditText) findViewById(R.id.grade_add_grade_name);
		String gradeName = gradeNameET.getText().toString();
		
		EditText gradeEarnedET = (EditText) findViewById(R.id.grade_add_grade_value);
		String gradeEarned = gradeEarnedET.getText().toString();
		
		EditText gradeTotalET = (EditText) findViewById(R.id.grade_add_grade_total);
		String gradeTotal = gradeTotalET.getText().toString();
		
		if (gradeName.length() == 0) {
			Toast.makeText(getApplicationContext(), 
					"You must choose an assignment name.", 
					Toast.LENGTH_SHORT).show();
		}
		else if (gradeEarned.length() == 0) {
			Toast.makeText(getApplicationContext(), 
					"You must input your grade.", 
					Toast.LENGTH_SHORT).show();			
		}
		else if (gradeTotal.length() == 0) {
			Toast.makeText(getApplicationContext(), 
					"You must input the max assignment score.", 
					Toast.LENGTH_SHORT).show();
		}
		else {
			try {
				float gradePoints = Float.parseFloat(gradeEarned);
				float gradeMax = Float.parseFloat(gradeTotal);
				saveGrade(gradeName, gradePoints, gradeMax);
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), 
						e.toString(), 
						Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	private void saveGrade(String name, float points, float max) {
		Toast.makeText(getApplicationContext(), 
				"Grade successfully saved.", 
				Toast.LENGTH_SHORT).show();
		addGrade(name, points, max);
		updateCategory(points, max);
		updateCourse();
		finish();
	}
	
	private void addGrade(String name, float earned, float possible) {
		GradeDataSource gradeDS = new GradeDataSource(getApplicationContext());
		gradeDS.open();
		gradeDS.createGrade(name, earned, possible, categoryId);
		gradeDS.close();
	}
	
	private void updateCategory(float earned, float possible) {
		CategoryDataSource categoryDS = new CategoryDataSource(getApplicationContext());
		categoryDS.open();
		
		Category category = categoryDS.getCategoryById(categoryId);
		
		float newEarned = earned + category.getPoints_earned();
		float newPossible = possible + category.getMax_points();
		
		categoryDS.updatePointsById(categoryId, newEarned, newPossible);
		
		categoryDS.close();
	}
	
	private void updateCourse() {
		getCategoriesForCourse();
		
		CourseDataSource courseDS = new CourseDataSource(getApplicationContext());
		courseDS.open();
		
		float newEarned = 0;
		float newPossible = 0;
		float newEarnedInCourse = 0;
		float newMaxInCourse = 0;
		
		for (int i = 0; i < categories.size(); i++) {
			newEarned = categories.get(i).getPoints_earned();
			newPossible = categories.get(i).getMax_points();
			if (newPossible != 0) {
				newEarnedInCourse += newEarned / newPossible * categories.get(i).getWeight();
			}
			
			newMaxInCourse += categories.get(i).getWeight();
		}
		
		System.out.println("earned = " + newEarnedInCourse);
		System.out.println("possible = " + newMaxInCourse);
		courseDS.updatePointsById(courseId, newEarnedInCourse, newMaxInCourse);
		
		courseDS.close();
	}
	
	private void getCategoriesForCourse() {
		CategoryDataSource categoryDS = new CategoryDataSource(getApplicationContext());
		categoryDS.open();
		categories = categoryDS.getAllCategories(courseId);
		categoryDS.close();
	}
	
	private void deleteGrade(int gradeId) {
		GradeDataSource gradeDS = new GradeDataSource(getApplicationContext());
		gradeDS.open();
		gradeDS.deleteGrade(gradeId);
		gradeDS.close();
	}
}
