package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bn=(Button)findViewById(R.id.button);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.putExtra("name","wy");
                intent.putExtra("age",18);
                intent.setAction("Main2Activity");//要执行的动作
                intent.addCategory("android.intent.category.DEFAULT");//标记组件
                startActivityForResult(intent,0);
            }
        });
    }
    protected void onActivityResult(int req,int res,Intent a) {//重写
        super.onActivityResult(req, res, a);
        if (req == 0 && res == 0) {
            String date = a.getStringExtra("result");
            Toast.makeText(MainActivity.this, date, Toast.LENGTH_SHORT).show();
        }
    }
}
