package com.example.gmailandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import io.bloco.faker.Faker;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ItemsMail> itemsMailArrayList;
    MailAdapter mailAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itemsMailArrayList = new ArrayList<>();
        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            itemsMailArrayList.add(new ItemsMail(faker.name.name(), faker.lorem.sentence()));
        }

        listView = (ListView) findViewById(R.id.listView);
        mailAdapter = new MailAdapter(this, R.layout.layout_item, itemsMailArrayList);
        listView.setAdapter(mailAdapter);
    }
}
