package com.example.helloliting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class RecycleViewTest extends AppCompatActivity {
    
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycle_view_test);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
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