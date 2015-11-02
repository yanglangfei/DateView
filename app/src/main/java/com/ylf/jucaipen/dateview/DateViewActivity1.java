package com.ylf.jucaipen.dateview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2015/11/2.
 */
public class DateViewActivity1 extends Activity {
    private Button btn_born;
    private LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_date1);
        initView();

    }

    private void initView() {
        btn_born= (Button) findViewById(R.id.btn_born);
        inflater=LayoutInflater.from(this);
        btn_born.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog d=new Dialog(DateViewActivity1.this);
                View dateView=inflater.inflate(R.layout.ui_date_dialog,null);
                d.setContentView(dateView);
                d.show();

            }
        });
    }
}
