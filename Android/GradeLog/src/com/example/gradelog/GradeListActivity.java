package com.example.gradelog;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class GradeListActivity extends Activity {
	private int categoryId, courseId;
	private String courseName, categoryName;
	private List<Grade> grades = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grade_list);
		Intent intent = getIntent();
		categoryId = intent.getIntExtra("categoryId", 0);
		categoryName = intent.getStringExtra("categoryName");
		courseName = intent.getStringExtra("courseName");
		courseId = intent.getIntExtra("courseId", 0);

		getGradesFromCategory(this);
		
		setTitle(courseName + " - " + categoryName);
	}
	
    @Override
    protected void onResume() {
    	super.onResume();
    	getGradesFromCategory(this);
    }
    
    public void onClick(View view) {
    	switch (view.getId()) {
    	case R.id.add_grade:
    		// Launch the add course activity
    		Intent intent = new Intent(this, GradeAddActivity.class);
    		intent.putExtra("categoryId", categoryId);
    		intent.putExtra("courseId", courseId);
    		startActivity(intent);
    		break;
    	}
    }
    
    private void getGradesFromCategory(Context context) {
        GradeDataSource gradeDataSource = new GradeDataSource(context);
        gradeDataSource.open();
        
        grades = gradeDataSource.getGradesFromCourse(categoryId);
        
        GradeAdapter adapter = new GradeAdapter(
        		context,
        		R.layout.course_item,
        		grades);
        
        ListView lv = (ListView) findViewById(R.id.grade_list);
        lv.setAdapter(adapter);
        
        gradeDataSource.close();
        
        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				view.setBackgroundColor(Color.rgb(202, 225, 255));
				Intent i = new Intent(getApplicationContext(),
						GradeAddActivity.class);
				i.putExtra("gradeId", grades.get(position).getId());
				i.putExtra("gradeName", grades.get(position).getName());
				i.putExtra("gradeEarned", grades.get(position).getPoints_earned());
				i.putExtra("gradePossible", grades.get(position).getMax_points());
				i.putExtra("courseId", courseId);
				i.putExtra("categoryId", categoryId);
				startActivity(i);
			}
        });
    }
}
