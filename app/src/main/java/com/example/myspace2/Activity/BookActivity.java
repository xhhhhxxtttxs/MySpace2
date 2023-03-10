package com.example.myspace2.Activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myspace2.R;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class BookActivity extends AppCompatActivity {
    TextView mainText;
    Button title_btn;
    Button textView1,textView2;
    int flag;
    ScrollView scrollView;
    Handler handler =new Handler(Looper.getMainLooper())
    {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case 1:mainText.setText((String)msg.obj);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        mainText = findViewById(R.id.text);
        title_btn = findViewById(R.id.title_btn);
        textView1=findViewById(R.id.last_zhang);
        textView2=findViewById(R.id.next_zhang);
        scrollView=findViewById(R.id.scr_text);
        mainText.setMovementMethod(ScrollingMovementMethod.getInstance());

//        sendRequest();
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (flag){
                    case 1:
                        Toast.makeText(BookActivity.this,"?????????????????????",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:scrollView.smoothScrollTo(0,0);
                        sendRequest("http://book.zongheng.com/chapter/1028707/61764491.html");
                        flag--;
                        break;
                    case 3:scrollView.smoothScrollTo(0,0);
                        sendRequest("http://book.zongheng.com/chapter/1028707/61764498.html");
                        flag--;
                        break;
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (flag){

                    case 1:
                        scrollView.smoothScrollTo(0,0);
                        sendRequest("http://book.zongheng.com/chapter/1028707/61764498.html");
                        flag++;
                        break;
                    case 2:
                        scrollView.smoothScrollTo(0,0);
                        sendRequest("http://book.zongheng.com/chapter/1028707/61764524.html");
                        flag++;
                        break;
                    case 3:
                        Toast.makeText(BookActivity.this,"?????????????????????",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        title_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu =new PopupMenu(BookActivity.this,title_btn);
                popupMenu.getMenuInflater().inflate(R.menu.title_menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.text_1:
                                flag=1;
                                scrollView.smoothScrollTo(0,0);
                                sendRequest("http://book.zongheng.com/chapter/1028707/61764491.html");
                                Toast.makeText(BookActivity.this,"?????????",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.text_2:
                                flag=2;
                                scrollView.smoothScrollTo(0,0);
                                sendRequest("http://book.zongheng.com/chapter/1028707/61764498.html");
                                Toast.makeText(BookActivity.this,"?????????",Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.text_3:
                                flag=3;
                                scrollView.smoothScrollTo(0,0);
                                sendRequest("http://book.zongheng.com/chapter/1028707/61764524.html");
                                Toast.makeText(BookActivity.this,"?????????",Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });
            }
        });
    }


    private void sendRequest(String uurl) {
        OkHttpClient client=new OkHttpClient();
        final Request request=new Request.Builder()
                .url(uurl)
                .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.w("fail","fail to ask");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String str=response.body().string();

                Document document= Jsoup.parse(str);
                Element element=document.getElementsByClass("content").first();
                Elements element1 =element.getElementsByTag("p");
                String text="";
                for(int i=0;i<element1.size();i++){
                    text+=element1.get(i).text()+"\n";
                }
//                final String finalText = text;
//                MainActivity.this.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mainText.setText(finalText);
//                    }
//                });
                Message message =Message.obtain();
                message.what=1;
                message.obj=text;
                text="";
                handler.sendMessage(message);
            }




        });
    }
}

