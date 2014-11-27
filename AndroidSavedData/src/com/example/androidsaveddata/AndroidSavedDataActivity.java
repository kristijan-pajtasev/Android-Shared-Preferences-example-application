package com.example.androidsaveddata;

import android.content.SharedPreferences;
import android.content.Context;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;

public class AndroidSavedDataActivity extends Activity
{

    private int counter;
    SharedPreferences preferences;
    TextView textView;
    
    public static final String PREFERENCES_NAME = "com.example.androidsaveddata.SHARED_PREFERENCES";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
	textView = (TextView) findViewById(R.id.counterTextView);
	preferences = getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);

        counter = preferences.getInt("counter", 0);
	textView.setText(counter + "");
    }

    public void restart(View view) {
	counter = 0;
	textView.setText(counter + "");
    }

    public void increment(View view) {
	counter++;
	textView.setText(counter + "");
    }

    @Override
    public void onStop() {
	SharedPreferences.Editor editor = preferences.edit();
	editor.putInt("counter", counter);
	editor.commit();
	super.onStop();
    }

}
