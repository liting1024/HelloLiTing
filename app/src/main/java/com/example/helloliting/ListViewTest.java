package com.example.helloliting;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ListViewTest extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view_test);
        initFruits();

        /*ListView listView = (ListView) findViewById(R.id.listView);
        FruitAdapter adapter = new FruitAdapter(ListViewTest.this,R.layout.fruit_item,fruitList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewTest.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    private void initFruits() {
        for (int i = 1; i < 11; i++) {
            String imgName = "apple_pic"+ i;
            Field resId = null;
            try {
                resId = R.drawable.class.getField(imgName);
                Fruit apple = new Fruit("Apple"+i,resId.getInt(resId));
                fruitList.add(apple);
            } catch (Exception ignored) {}
        }
    }
}