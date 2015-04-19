package com.vistar.filerecord;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WriteFile extends Activity implements OnClickListener {
Button bsave;
EditText etfilename;
EditText etdata;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write_file);
		bsave = (Button)findViewById(R.id.b_save);
		etfilename = (EditText)findViewById(R.id.et_filename);
		etdata = (EditText)findViewById(R.id.et_data);
		bsave.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.write_file, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	String filename = etfilename.getText().toString();
	if(filename.contentEquals("")){filename = "UNTITLED";}
	String datainfile = etdata.getText().toString();
	try {
		FileOutputStream fos = openFileOutput(filename,Context.MODE_PRIVATE);
		fos.write(datainfile.getBytes());
		fos.close();
		finish();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
