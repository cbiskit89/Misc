package com.example.gradelog;

import java.text.NumberFormat;

import android.graphics.Color;

public class MyCommonFunctions {
	public static int setGradeColor(float grade) {
    	if (grade >= 90) {
    		return Color.GREEN;
    	}
    	else if (grade >= 80) {
    		// Yellow-Green
    		return Color.rgb(173, 255, 47);
    	}
    	else if (grade >= 70) {
    		// Dark Yellow
    		return Color.rgb(255, 215, 0);
    	}
    	else if (grade >= 60) {
    		// Orange
    		return Color.rgb(255, 140, 0);
    	}
    	else {
    		return Color.RED;
    	}
    }
	
	public static String formatStringTwoDecPercent (float number) {
		NumberFormat formatter = NumberFormat.getNumberInstance();
		formatter.setMinimumFractionDigits(0);
		formatter.setMaximumFractionDigits(2);
		
		return String.valueOf(formatter.format(number) + "%");
	}
}
