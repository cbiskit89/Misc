package com.example.gradelog;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CategoryAdapter extends ArrayAdapter<Category> {
	private Context context;
	private int resource;
	private List<Category> categories = null;

	public CategoryAdapter(Context context, int resource, List<Category> categories) {
		super(context, resource, categories);
		this.context = context;
		this.resource = resource;
		this.categories = categories;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		LayoutInflater inflater = ((Activity)context).getLayoutInflater();

		row = inflater.inflate(resource, parent, false);
		
		TextView categoryName = (TextView)row.findViewById(R.id.course_item_name);
		TextView categoryGrade = (TextView)row.findViewById(R.id.course_item_grade);	
		
		categoryName.setText(categories.get(position).getName());
		categoryGrade.setText(currentGrade(position));
		setGradeColor(categoryGrade);
		
		return row;
	}
	
	public String currentGrade(int position) {
		String currentGradeToStr;
		if (categories.get(position).getPoints_earned() == 0.0f) {
			currentGradeToStr = "0%";
		}
		else {
			float currentGrade = categories.get(position).getPoints_earned() / 
					categories.get(position).getMax_points();
			
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
