package com.example.newtravel2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    //선언
    ImageButton image_pen;
    ImageButton image_user;
    ImageButton image_plus;

    //액티비티 끌고옴
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //뷰페이저 세팅
        ViewPager viewPager = findViewById(R.id.viewPager);
        fragmentPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //id 받기
        //tv_id = findViewById(R.id.tv_id); //연결
        //Intent intent = getIntent(); //intent받기
        //String id = intent.getStringExtra("id"); //intent에서 id받아서 저장
        //tv_id.setText(id); //id로 설정

        //유저 페이지창 띄우기
        image_user = findViewById(R.id.image_user);
        image_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });

        //블로그 글쓰기(펜)창 띄우기
        image_pen = findViewById(R.id.image_pen);
        image_pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WriteActivity.class);
                startActivity(intent);
            }
        });

        //여정 추가(플러스)창 띄우기
        image_plus = findViewById(R.id.image_plus);
        image_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

    }
}