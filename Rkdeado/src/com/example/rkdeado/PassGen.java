package com.example.rkdeado;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class PassGen implements OnClickListener {

	private EditText site;
	private EditText phrase;
	private TextView generated;
	
	public PassGen(EditText site, EditText phrase, TextView label) {
		this.site = site;
		this.phrase = phrase;
		this.generated = label;		
	}
	
	@Override
	public void onClick(View v) {
		System.out.println("site:" +site.getText()+ " Phrase:"+phrase.getText());		
		generated.setText(createPass(site.getText().toString(), phrase.getText().toString()));
	}


	private String createPass(String site, String phrase){
		String pass = "";
		String[] array = phrase.split(" ");
		System.out.println("Total de palavras:"+array.length);
		return pass;
	}
	

}
