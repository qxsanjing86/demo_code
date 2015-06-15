package com.example.demoproject;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends ListActivity {
    static String[] demoActivities = {
            "com.example.demoproject.animation.AnimDemo"
            ,"com.example.demoproject.custom_view.ViewDemoAct"
            ,"com.example.demoproject.gesture.VelocityTrackerAct"
            ,"com.example.demoproject.content_provider.ProviderTestAct"
    };
    static List<Map<String,String>> data = new ArrayList<Map<String, String>>();
    static {
        for(int i=0;i< demoActivities.length;i++){
            Map<String,String> map = new HashMap<String, String>();
            map.put("activity", demoActivities[i]);
            data.add(map);
        }
    }

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        SimpleAdapter adapter = new SimpleAdapter(this,data,android.R.layout.simple_list_item_1,new String[]{"activity"},new int[]{android.R.id.text1});
        setListAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String activity = null;
                if(view instanceof TextView){
                    TextView textView = (TextView) view;
                    activity= (String) textView.getText();
                    Log.d("nqy", "activity:" + activity);
                }
                if(activity != null){
                    try {
                        Intent it = new Intent(MainActivity.this,Class.forName(activity));
                        adapterView.getContext().startActivity(it);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
