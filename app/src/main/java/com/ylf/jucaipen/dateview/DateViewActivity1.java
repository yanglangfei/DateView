package com.ylf.jucaipen.dateview;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Administrator on 2015/11/2.
 */
public class DateViewActivity1 extends Activity {
    private LayoutInflater inflater;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_date1);
        tv1= (TextView) findViewById(R.id.tv1);
        parseHtml();
       // initView();

    }

    private void parseHtml() {
        String html="<div><p>Lorem ipsum.</p>";
        Document doc=Jsoup.parseBodyFragment(html);
        Element ps=doc.body();
        Log.i("111","p:"+ps.text());
        tv1.setText(ps.text());
    }

    private void initView(){
        try {
            Document doc= Jsoup.connect("http://36kr.com/").get(); //获取解析的文件URL
            Elements news= doc.getElementsByClass("headline__news"); //获取文件里的class
            for(Element n :news){
               Elements tage= n.getElementsByTag("a"); //从class获取a标签
               String link= tage.attr("href");   //a标签下获取href属性值
                Elements h_tag=n.getElementsByTag("h"); //获取h标签
                String text=h_tag.text(); //获取H标签下的文字
                Log.i("111","link:"+link+"   text:"+text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    };
}
