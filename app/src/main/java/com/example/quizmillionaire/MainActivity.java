package com.example.quizmillionaire;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizmillionaire.adapter.SectionsStatePagerAdapter;
import com.example.quizmillionaire.customviewpager.NonSwipeableViewPager;
import com.example.quizmillionaire.fragment.MenuFragment;
import com.example.quizmillionaire.model.Question;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    private NonSwipeableViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.container);
        setupViewPager(viewPager);

        Thread thread = new Thread(() -> {
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                URL url = new URL("http://192.168.0.100:8080/questions");
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                ResponseBody responseBody = okHttpClient.newCall(request).execute().body();
                if(responseBody != null) {
                    Question[] questions = objectMapper.readValue(responseBody.string(), Question[].class);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    private void setupViewPager(NonSwipeableViewPager viewPager) {
        SectionsStatePagerAdapter adapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        viewPager.setPagingEnabled(true);
        adapter.addFragment(new MenuFragment(), "Menu fragment");
        adapter.addFragment(new MenuFragment(), "Menu fragment");
        adapter.addFragment(new MenuFragment(), "Menu fragment");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        viewPager.setCurrentItem(fragmentNumber);
    }
}