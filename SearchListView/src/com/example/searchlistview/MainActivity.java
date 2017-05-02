package com.example.searchlistview;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	EditText txtSearch;
	ListView lv;
	
	//data holder
	ArrayList<Student>list=new ArrayList<Student>();
	ArrayList<Student>source=new ArrayList<Student>();
	
	ItemAdapter adapter;
	
	//adaptersadasd
	//ArrayAdapter<String> adapter;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       this.txtSearch=(EditText) this.findViewById(R.id.editText1);
       this.lv=(ListView) this.findViewById(R.id.listView1);
       this.adapter=new ItemAdapter(this,list);
       this.lv.setAdapter(adapter);
       //poputalte my data
       
       //this.source.add("a");
      //this.source.add(R.drawable.img1);
       
       source.add(new Student(R.drawable.img1,"Name","BSIT"));
       source.add(new Student(R.drawable.img2,"Bravo","BSED"));
       source.add(new Student(R.drawable.img3,"Bravo","BSCRIM"));
       source.add(new Student(R.drawable.img4,"Bravo","BSEE"));
       source.add(new Student(R.drawable.img5,"Bravo","BSHRM"));
       source.add(new Student(R.drawable.img6,"Bravo","BSME"));
       source.add(new Student(R.drawable.img7,"Bravo","BSAC"));
       source.add(new Student(R.drawable.img8,"Bravo","BSA"));
       source.add(new Student(R.drawable.img9,"Bravo","BSS"));
      
   
       
      
       
       
       this.txtSearch.addTextChangedListener(new TextWatcher(){

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
			list.clear();
			
			Pattern p = Pattern.compile(arg0.toString());
			for(int i=0;i<source.size();i++){
				Matcher m = p.matcher(source.get(i).getName());
				Matcher n = p.matcher(source.get(i).getCourse());
					if(m.find()|| n.find()){
						list.add(source.get(i));
					}
				adapter.notifyDataSetChanged();
			}
			
			
		}});
       
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
