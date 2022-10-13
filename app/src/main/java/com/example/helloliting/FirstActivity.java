package com.example.helloliting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends BaseActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.add_item) {
            Toast.makeText(this, "点了添加", Toast.LENGTH_SHORT).show();
        }
        else if (id == R.id.remove_item) {
            Toast.makeText(this, "点了删除", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is "+getTaskId());
        setContentView(R.layout.activity_first);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*显示Intent*/
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

                /*传递数据*/
                /*String data = "Hello SecondActivity";
                intent.putExtra("extra_data",data);
                startActivity(intent);*/

                /*返回数据*/
                /*startActivityForResult(intent,1);*/

                /*隐式Intent*/
                /*Intent intent = new Intent("com.example.helloliting.ACTION_START");
                intent.addCategory("com.example.helloliting.MY_CATEGORY"); // 自定义category
                startActivity(intent);
                Toast.makeText(FirstActivity.this,"销毁活动First，打开隐式的Second",
                        Toast.LENGTH_SHORT).show();
                finish();*/

                /*启动活动并传递数据最佳写法*/
                String data = "最佳的Hello SecondActivity";
                SecondActivity.actionStart(FirstActivity.this,data);
            }
        });
        Button button_url = (Button) findViewById(R.id.button_url);
        button_url.setOnClickListener(new View.OnClickListener() {
//            final String URL = "http://119.75.217.109";
            final String URL = "http://www.baidu.com";
            final String TEL = "tel:10086";
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(TEL)); // 打开其他活动
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode)  {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:
        }
    }
}