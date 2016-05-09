package com.example.gradelog;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class CategoryListActivity extends Activity {
	private int courseId;
	private String courseName;
	private List<Category> categories = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.category_list);
		Intent intent = getIntent();
		courseId = intent.getIntExtra("courseId", 0);
		courseName = intent.getStringExtra("courseName");
		
		getAllCategories(this);
		
		setTitle(courseName);
	}
	
    @Override
    protected void onResume() {
    	super.onResume();
    	getAllCategories(this);
    }
    
    public void onClick(View view) {
    	switch (view.getId()) {
    	case R.id.course_delete_btn:
	    	CourseDataSource courseDS = new CourseDataSource(getApplicationContext());
	    	courseDS.open();
	    	courseDS.deleteCourse(courseId);
	    	Toast.makeText(getApplicationContext(), 
	    			courseName + " successfully deleted.", 
	    			Toast.LENGTH_SHORT).show();
	    	finish();
	    	break;
    	}
    }
	
	private void getAllCategories(Context context) {
		CategoryDataSource catDS = new CategoryDataSource(context);
		catDS.open();
		categories = catDS.getAllCategories(courseId);
		
		CategoryAdapter adapter = new CategoryAdapter(
				context,
				R.layout.course_item,
				categories);
		
		ListView lv = (ListView) findViewById(R.id.category_list);
		lv.setAdapter(adapter);
		catDS.close();
		
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				view.setBackgroundColor(Color.rgb(202, 225, 255));
				Intent i = new Intent(getApplicationContext(),
						GradeListActivity.class);
				i.putExtra("categoryId", categories.get(position).getId());
				i.putExtra("categoryName", categories.get(position).getName());
				i.putExtra("courseId", courseId);
				i.putExtra("courseName", courseName);
				startActivity(i);
			}
        });
	}
}
