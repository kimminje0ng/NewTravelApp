package com.example.newtravel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MakeTravelActivity extends FragmentActivity {

    ListView listView1;
    ArrayAdapter<String> adapter;
    ArrayList<String> listitem;

    EditText editText1;
    EditText editText2;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1=findViewById(R.id.editText1);
        editText2=findViewById(R.id.editText2);
        button1=findViewById(R.id.button4);

        listitem=new ArrayList<String>();
        listitem.add("동화가든       순두부");
        listitem.add("잘되나용??");

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                String s=editText1.getText().toString()+"       "+editText2.getText().toString();
                listitem.add(s);
                adapter.notifyDataSetChanged();
                editText1.setText("");
                editText2.setText("");
            }
        });

        adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,listitem);listView1=findViewById(R.id.listView1);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),listitem.get(i).toString()+"삭제되었습니다.",Toast.LENGTH_SHORT).show();
                listitem.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
    }
}