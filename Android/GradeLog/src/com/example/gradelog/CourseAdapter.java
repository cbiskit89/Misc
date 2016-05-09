package com.example.gradelog;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CourseAdapter extends ArrayAdapter<Course> {
	Context context;
	int resourceId;
	List<Course> data = null;

	public CourseAdapter(Context context, int resource, List<Course> data) {
		super(context, resource, data);
		this.context = context;
		this.resourceId = resource;
		this.data = data;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		
		LayoutInflater inflater = ((Activity)context).getLayoutInflater();
		row = inflater.inflate(resourceId, parent, false);
		
		TextView courseName = (TextView)row.findViewById(R.id.course_item_name);
		TextView courseGrade = (TextView)row.findViewById(R.id.course_item_grade);
		courseName.setText(data.get(position).getName());
		courseGrade.setText(currentGrade(position));
		setGradeColor(courseGrade);
		
		return row;
	}
	
	public String currentGrade(int position) {
		String currentGradeToStr;
		if (data.get(position).getPoints_earned() == 0.0f) {
			currentGradeToStr = "0%";
		}
		else {
			float currentGrade = data.get(position).getPoints_earned() / 
					data.get(position).getMax_points();
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
