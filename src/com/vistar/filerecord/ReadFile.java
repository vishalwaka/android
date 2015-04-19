package com.vistar.filerecord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ReadFile extends Activity implements OnClickListener {
Button bread;
Spinner spfilename;
TextView inside;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_read_file);
		bread = (Button)findViewById(R.id.b_load);
		spfilename = (Spinner)findViewById(R.id.sp_filename);
		inside = (TextView)findViewById(R.id.tv_datainfile);
		bread.setOnClickListener(this);
		getFileNames();
	}

	private void getFileNames() {
		// TODO Auto-generated method stub
		String[] filenames = getApplicationContext().fileList();
		List<String> list = new ArrayList<String>();
		for(int i=0;i<filenames.length; i++)
		{
			list.add(filenames[i]);
		}
		ArrayAdapter<String> filenameAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list);
	    spfilename.setAdapter(filenameAdapter);
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.read_file, menu);
		return true;
	}
    
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
	String selectedItem = String.valueOf(spfilename.getSelectedItem());
	openFile(selectedItem);
	
	}

	private void openFile(String selectedItem) {
		// TODO Auto-generated method stub
		String value = "";
		FileInputStream fis;
		try {
			fis = openFileInput(selectedItem);
			byte[] input = new byte[fis.available()];
			while(fis.read(input)!= -1)
			{
				value+=new String(input);
				
			}
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inside.setText(value);
	}

}
