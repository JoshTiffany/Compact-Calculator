package io.github.joshtiffany.ultimatecalculator.SettingsMisc;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import io.github.joshtiffany.ultimatecalculator.R;

public class ThemesActivity extends AppCompatActivity {

    ListView simpleList;
    String[] colors = {"Default", "Pink", "Blue", "Green", "Orange", "Yellow", "Black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themes2);
        simpleList = findViewById(R.id.themeListView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.listview, R.id.textView, colors);
        simpleList.setAdapter(arrayAdapter);


    }

}
