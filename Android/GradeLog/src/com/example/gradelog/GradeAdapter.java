package com.example.gradelog;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class GradeAdapter extends ArrayAdapter<Grade> {
	/*
	 * Extends the array adapter class to insert the grade name and score
	 * into the ListView.
	 */
	private Context context;
	private int resource;
	private List<Grade> grades;

	public GradeAdapter(Context context, int resource, List<Grade> grades) {
		super(context, resource, grades);
		
		this.context = context;
		this.resource = resource;
		this.grades = grades;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
		
		row = inflater.inflate(resource, parent, false);
		
		TextView categoryName = (TextView)row.findViewById(R.id.course_item_name);
		TextView categoryGrade = (TextView)row.findViewById(R.id.course_item_grade);
		
		categoryName.setText(grades.get(position).getName());
		categoryGrade.setText(currentGrade(position));
		setGradeColor(categoryGrade);
		
		return row;
	}
	
	public String currentGrade(int position) {
		String currentGradeToStr;
		/* 
		 * Since you can't divide by zero, this prevents NaN.
		 * It should be fixed for instances where you can get bonus points.
		 */
		if (grades.get(position).getMax_points() == 0.0f) {
			currentGradeToStr = "0%";
		}
		else {
			float currentGrade = grades.get(position).getPoints_earned() / 
					grades.get(position).getMax_points();
			
			currentGrade *= 100;
			currentGradeToStr = MyCommonFunctions.formatStringTwoDecPercent(currentGrade);
		}

		return currentGradeToStr;
	}

    private void setGradeColor(TextView tv) {
    	String gradeText = tv.getText().toString();
    	float grade = Float.parseFloat(gradeText.substring(0, gradeText.length() - 1));
		tv.setTextColor(MyCommonFunctions.setGradeColor(grade));
    }
}
