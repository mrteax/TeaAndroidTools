package com.tea.android.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class KeyboardHeightDetector extends Activity implements InputMethodRelativeLayout.OnSizeChangedListener {

	private InputMethodRelativeLayout layout;
	
	private InputMethodManager imMgr;
	private TextView dashboard;
	private float density;
	private float screenHeight;
	private float screenWidth;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		layout = new InputMethodRelativeLayout(this);
		this.setContentView(layout);
		
		LinearLayout panel = new LinearLayout(this);
		panel.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		panel.setOrientation(LinearLayout.VERTICAL);
		layout.addView(panel);
		
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		EditText editor = new EditText(this);
		editor.setLayoutParams(lp);
		panel.addView(editor);
		
		dashboard = new TextView(this);
		dashboard.setLayoutParams(lp);
		panel.addView(dashboard);
		
		layout.setOnSizeChangedListener(this);
		
		density = getResources().getDisplayMetrics().density;
		screenHeight = getResources().getDisplayMetrics().heightPixels;
		screenWidth = getResources().getDisplayMetrics().widthPixels;
		imMgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	}

	@Override
	public void onSizeChange(boolean flag) {
		if(flag){
			layout.setPadding(0, 0, 0, 0);
		}else
			layout.setPadding(0, 0, 0, 0);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getAction() == MotionEvent.ACTION_UP){
			imMgr.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),0);
		}
		return super.onTouchEvent(event);
	}

	@Override
	public void onSizeChange(int w, int h, int oldw, int oldh) {
		dashboard.setText("Keyboard Height: " + Math.abs(h - oldh) + "\n" + "Screen Height: " + screenHeight + "\n" + "Screen Width: " + screenWidth);
	}
}
