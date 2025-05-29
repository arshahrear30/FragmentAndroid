package com.example.splashss;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        button1 =findViewById(R.id.button1);
        button2 =findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // FragmentManager তৈরি করা হলো — এটি ফ্র্যাগমেন্ট নিয়ন্ত্রণ করে
                FragmentManager fManager = getSupportFragmentManager();

                // FragmentTransaction শুরু করা হলো — এটি ফ্র্যাগমেন্ট যোগ/সরানো ইত্যাদি কাজ করে
                FragmentTransaction fragmentTransaction = fManager.beginTransaction();

                // R.id.frameLayout হল host layout (FrameLayout), যেখানে ফ্র্যাগমেন্ট দেখানো হবে
                // FirstFragment কে ওই জায়গায় add করা হলো
                fragmentTransaction.add(R.id.frameLayout, new FirstFragment());

                // ট্রানজ্যাকশন কমিট করে কাজ সম্পন্ন করা হলো
                fragmentTransaction.commit();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =fManager.beginTransaction();
                fragmentTransaction.add(R.id.frameLayout,new SecondFragment() );//conteinerViewId মানে host এর id ,fragment (যেটাকে Transaction করাবো )
                fragmentTransaction.commit();

            }
        });





        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
