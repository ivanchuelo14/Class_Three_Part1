package com.example.class_three;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    Button button;
    CheckBox getChckAnime1, getChckAnime2, getChckAnime3;
    RadioGroup radioGroup;
    TextView txtInicio, txtProgreso, txtFinal;
    SeekBar sckBar;
    String[] elementos = {"Ivan","Julian", "Lady", "Yohanna", "CandyAce", "Beatriz"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getChckAnime1 = (CheckBox) findViewById(R.id.checkBox);
        getChckAnime2 = (CheckBox) findViewById(R.id.checkBox2);
        getChckAnime3 = (CheckBox) findViewById(R.id.checkBox3);
        button = (Button) findViewById(R.id.button);
        radioGroup = (RadioGroup) findViewById(R.id.RadioG);
        txtInicio = (TextView) findViewById(R.id.txtStart);
        txtProgreso = (TextView) findViewById(R.id.txtProgress);
        txtFinal = (TextView) findViewById(R.id.txtStop);
        sckBar = (SeekBar)findViewById(R.id.seekBar);
        sckBar.setOnSeekBarChangeListener(this);
        listView = (ListView) findViewById(R.id.usuarios);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, elementos);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), listView.getItemAtPosition(i).toString(), Toast.LENGTH_LONG).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer result = new StringBuffer();
                result.append("El anime Haikyuu! esta seleccionado!").append(getChckAnime1.isChecked());
                result.append("El anime One Piece esta seleccionado!").append(getChckAnime2.isChecked());
                result.append("El anime Steins;Gate esta seleccionado!").append(getChckAnime3.isChecked());
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int idChecked) {
                if (idChecked == R.id.radioButton) {
                    Toast.makeText(getApplicationContext(), "Respondiste Si", Toast.LENGTH_LONG).show();
                } else if (idChecked == R.id.radioButton2) {
                    Toast.makeText(getApplicationContext(), "Respondiste No", Toast.LENGTH_LONG).show();
                } else if (idChecked == R.id.radioButton3) {
                    Toast.makeText(getApplicationContext(), "Respondiste En blanco", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int valor, boolean b) {
        txtProgreso.setText("valor actual => " + valor);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        txtInicio.setText("Inicio en => " + seekBar.getProgress());
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        txtFinal.setText("Finalizo en => " + seekBar.getProgress());
    }
}