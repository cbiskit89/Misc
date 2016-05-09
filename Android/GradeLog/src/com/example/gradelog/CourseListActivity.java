package com.example.gradelog;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CourseListActivity extends Activity {
	private CourseDataSource courseDataSource;
	private List<Course> courses = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_list);
        
        getAllCourses(this);
    }
    
    @Override
    protected void onResume() {
    	super.onResume();
    	getAllCourses(this);
    }
    
    public void onClick(View view) {
    	switch (view.getId()) {
    	case R.id.add_course:
    		// Launch the add course activity
    		Intent intent = new Intent(this, CourseAddActivity.class);
    		startActivity(intent);
    		break;
    	}
    }
    
    private void getAllCourses(Context context) {
        courseDataSource = new CourseDataSource(this);
        courseDataSource.open();
        
        courses = courseDataSource.getAllCourses();
        
        CourseAdapter adapter = new CourseAdapter(
        		context,
        		R.layout.course_item,
        		courses);
        ListView lv = (ListView) findViewById(R.id.course_list);
        lv.setAdapter(adapter);
        courseDataSource.close();
        
        lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				view.setBackgroundColor(Color.rgb(202, 225, 255));
				Intent i = new Intent(getApplicationContext(),
						CategoryListActivity.class);
				i.putExtra("courseId", courses.get(position).getId());
				i.putExtra("courseName", courses.get(position).getName());
				startActivity(i);
			}
        });
    }
}
