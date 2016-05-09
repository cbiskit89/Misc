package com.example.gradelog;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CourseAddActivity extends Activity {
	
	private List<EditText> catNames = new ArrayList<EditText>();
	private List<EditText> catVals = new ArrayList<EditText>();
	private boolean weighted = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_add);
		
		CheckBox checkBox = (CheckBox) this.findViewById(R.id.course_weighted_checkbox);
		checkBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if (arg0.isChecked() == true) {
					weighted = true;
					// Show a button to add category fields
					findViewById(R.id.course_category_layout).setVisibility(View.VISIBLE);
					addEditTexts();
				}
				else if (arg0.isChecked() == false) {
					weighted = false;
					// Hide a button to add category fields
					findViewById(R.id.course_category_layout).setVisibility(View.GONE);
					for(int i = 0; i < catNames.size(); i++) {
						removeLastCategories();
					}
				}
			}			
		});
		
		Button saveButton = (Button) this.findViewById(R.id.course_add_save);
		saveButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				EditText courseName = (EditText) findViewById(R.id.course_name_edittext);
				
				if (!(TextUtils.isEmpty(courseName.getText().toString().trim()))) {
					if (!weighted) {
						Course course = addCourse(courseName.getText().toString());
						addCategory("unweighted", "100", course.getId());
						Toast.makeText(getApplicationContext(), 
								"Course successfully saved.", 
								Toast.LENGTH_SHORT).show();
						finish();
					}
					else if (validateCatVals()) {
						Course course = addCourse(courseName.getText().toString());
						for (int i = 0; i < catNames.size(); i++) {
							addCategory(catNames.get(i).getText().toString(), 
									catVals.get(i).getText().toString(), 
									course.getId());
						}
						Toast.makeText(getApplicationContext(), 
								"Course successfully saved.", 
								Toast.LENGTH_SHORT).show();
						finish();
					}		
				}
				else {
					Toast.makeText(getApplicationContext(), 
							"Please fill out the course name.", 
							Toast.LENGTH_LONG).show();
				}
			}
		});
		
		Button addCategory = (Button) this.findViewById(R.id.course_category_add_btn);
		addCategory.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// Dynamically add category name and weight EditText's
				if (!catNames.isEmpty()) {
					if (catNames.get(catNames.size() - 1).getText().toString().length() <= 0) {
						Toast.makeText(getApplicationContext(), "You must fill out the previous " 
								+ "weighted category before you can add another.", 
								Toast.LENGTH_LONG).show();
					}
					else {
						addEditTexts();
					}
				}
				else {
					addEditTexts();
				}
			}
		});
		
		Button removeLastCat = (Button) findViewById(R.id.course_category_remove_btn);
		removeLastCat.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				removeLastCategories();
			}
		});
	}
	
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.course_add_cancel:
			finish();
			break;
		}
	}
	
	private boolean validateCatVals() {
		boolean validated = false;
		float currPercent = 0.0f;
		String placeHolder;
		
		for (int i = 0; i < catVals.size(); i++) {
			placeHolder = catVals.get(i).getText().toString();
			try {
				currPercent += Float.parseFloat(placeHolder);
			} catch (Exception e){
				Toast.makeText(getApplicationContext(), 
						e.toString(), 
						Toast.LENGTH_LONG).show();
			}
		}
		
		if (currPercent == 100.0f) {
			validated = true;
		}
		else {
			Toast.makeText(getApplicationContext(), 
					"Your grade categories add up to " + currPercent + "%. It must add to 100%", 
					Toast.LENGTH_LONG).show();
		}
		
		return validated;			
	}
	
	private void addEditTexts() {
		LinearLayout layout = (LinearLayout) findViewById(R.id.course_category_layout);
		
		EditText catName = new EditText(getApplicationContext());
		catName.setHint("Weighted Grade Category Name");
		catName.setTextColor(Color.BLACK);
		catName.setSingleLine();
		
		EditText catVal = new EditText(getApplicationContext());
		catVal.setHint("% of Overall Grade");
		catVal.setTextColor(Color.BLACK);
		catVal.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
		
		layout.addView(catName);
		catNames.add(catName);
		
		layout.addView(catVal);
		catVals.add(catVal);
		
		if (findViewById(R.id.course_category_remove_btn).getVisibility() == View.GONE){
			findViewById(R.id.course_category_remove_btn).setVisibility(View.VISIBLE);
		}
	}
	
	private void removeLastCategories() {
		EditText lastCatName = catNames.get(catNames.size() - 1);
		EditText lastCatVal = catVals.get(catVals.size() - 1);
		LinearLayout layout = (LinearLayout) findViewById(R.id.course_category_layout);
		catNames.remove(lastCatName);
		layout.removeView(lastCatName);
		catVals.remove(lastCatVal);
		layout.removeView(lastCatVal);
		if (catNames.isEmpty() && catVals.isEmpty()) {
			findViewById(R.id.course_category_remove_btn).setVisibility(View.GONE);
		}
	}
	
	private Course addCourse(String courseName) {
		CourseDataSource courseDS = 
				new CourseDataSource(getApplicationContext());
		courseDS.open();
		Course course = courseDS.createCourse(courseName);
		courseDS.close();
		return course;
	}
	
	private void addCategory(String categoryName, String categoryWeightStr, int courseId) {
		try {
			float categoryWeight = Float.parseFloat(categoryWeightStr);
			CategoryDataSource catDS = new CategoryDataSource(getApplicationContext());
			catDS.open();
			catDS.createCategory(categoryName, categoryWeight, courseId);
			catDS.close();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), 
					e.toString(), 
					Toast.LENGTH_LONG).show();
			System.out.println(e.toString());
		}
	}
}
