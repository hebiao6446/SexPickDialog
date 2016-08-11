package com.hebiao.spd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    String sexString="男";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public  void  selectSexAction(View v){


        SexSelectDialog sexSelectDialog=new SexSelectDialog(this);
        sexSelectDialog.setSex(sexString);
        sexSelectDialog.setOnSexClickLister(new SexSelectDialog.OnSexSelectLister() {
            @Override
            public void sexSelectClick(String sex) {
                sexString=sex;
            }
        });

    }
}

