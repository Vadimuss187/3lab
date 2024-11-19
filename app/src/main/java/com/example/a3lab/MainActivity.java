package com.example.a3lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import db.DbContext;
import db.Human;

public class MainActivity extends AppCompatActivity {
    private DbContext dbContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbContext = new DbContext(this);
        dbContext.OpenDb();
        if(dbContext.GetHuman().isEmpty()){
            Human human1 = new Human();
            Human human2 = new Human();
            Human human3 = new Human();
            Human human4 = new Human();
            Human human5 = new Human();
            human1.setFull_name("Петр Петров Петрович");
            human2.setFull_name("Петр2 Петров Петрович");
            human3.setFull_name("Петр3 Петров Петрович");
            human4.setFull_name("Петр4 Петров Петрович");
            human5.setFull_name("Петр5 Петров Петрович");
            human1.setDate("06.11.2024");
            human2.setDate("06.11.2024");
            human3.setDate("06.11.2024");
            human4.setDate("06.11.2024");
            human5.setDate("06.11.2024");
            dbContext.Add(human1);
            dbContext.Add(human2);
            dbContext.Add(human3);
            dbContext.Add(human4);
            dbContext.Add(human5);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbContext.CloseDb();
    }

    public void GoScreen1(View v) {
        Intent intent = new Intent(this, ActivitySelect.class);
        startActivity(intent);
    }

    public void GoScreen2(View v) {
        Intent intent = new Intent(this, ActivityAdd.class);
        startActivity(intent);
    }

    public void Update (View v) {
        dbContext.UpdateLastHuman();
        Toast.makeText(this, "Пользователь обновлен", Toast.LENGTH_SHORT).show();
    }
}