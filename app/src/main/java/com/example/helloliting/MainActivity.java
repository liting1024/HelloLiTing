package com.example.helloliting;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG,"李挺verbose");
        Log.d(TAG,"李挺debug");
        Log.w(TAG,"李挺warning");
        Log.e(TAG,"李挺error");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.button) {
                    String inputText = editText.getText().toString();
                    Toast.makeText(MainActivity.this, inputText,
                    Toast.LENGTH_SHORT).show();

                    imageView.setImageResource(R.drawable.img_2);
                    /*进度条*/
                    if (progressBar.getVisibility() == View.GONE) {
                        progressBar.setVisibility(View.VISIBLE);
                        int progress = progressBar.getProgress();
                        progress  = progress + 10;
                        progressBar.setProgress(progress);
                    } else {
                        progressBar.setVisibility(View.GONE); // 不可见不占用空间
                    }
                    /*确认对话框*/
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("警告");
                    dialog.setMessage("重要信息");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    dialog.show();
                    /*进度条对话框 已弃用*/
                   /* ProgressDialog progressDialog =  new ProgressDialog (MainActivity.this);
                    progressDialog.setTitle("This is ProgressDialog");
                    progressDialog.setMessage("Loading...");
                    progressDialog.setCancelable(true); // false时需要用dismiss恢复操作
                    progressDialog.show();*/
                    /*替代：ProgressBar+交互禁用*/
                    // 禁用交互
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    // 恢复交互
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                }
            }
        });
    }
}