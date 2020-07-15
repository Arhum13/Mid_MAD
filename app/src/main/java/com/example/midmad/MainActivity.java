package com.example.midmad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.btn1);
        b2=(Button)findViewById(R.id.btn2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager f=getSupportFragmentManager();
                f.beginTransaction().replace(R.id.holder,new Record()).addToBackStack(null).commit();
                b1.setVisibility(view.VISIBLE);
                b2.setVisibility(view.GONE);
                Myservice s1=new Myservice();

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager f=getSupportFragmentManager();
                f.beginTransaction().replace(R.id.holder,new View()).addToBackStack(null).commit();
                b1.setVisibility(view.GONE);
                b2.setVisibility(view.VISIBLE);
            }
        });
    }
    }
}