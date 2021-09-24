package com.example.GPA_Maaz_Calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button b;
    EditText et1, et2, et3, et4, et5;
    TextView t;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        b = (Button) findViewById(R.id.button1);
        et1 = (EditText) findViewById(R.id.textEdit1);
        et2 = (EditText) findViewById(R.id.textEdit2);
        et3 = (EditText) findViewById(R.id.textEdit3);
        et4 = (EditText) findViewById(R.id.textEdit4);
        et5 = (EditText) findViewById(R.id.textEdit5);

        t = (TextView) findViewById(R.id.gpaDisplay);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                float d1, d2, d3, d4 , d5;

                if(count %2 ==0){
                    if(et1.getText().toString().equals("") || et2.getText().toString().equals("") || et3.getText().toString().equals("") || et4.getText().toString().equals("") || et5.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        d1 = Float.parseFloat(et1.getText().toString());
                        d2 = Float.parseFloat(et2.getText().toString());
                        d3 = Float.parseFloat(et3.getText().toString());
                        d4 = Float.parseFloat(et4.getText().toString());
                        d5 = Float.parseFloat(et5.getText().toString());

                        float average = (d1 + d2 + d3 + d4 + d5)/5;

                        if(average < 60){
                            t.setText(Float.toString(average));
                            t.setBackgroundColor(Color.RED);
                        }
                        else if (average >= 60 && average < 80){
                            t.setText(Float.toString(average));
                            t.setBackgroundColor(Color.YELLOW);
                        }
                        else if (average >= 80 && average <= 100){
                            t.setText(Float.toString(average));
                            t.setBackgroundColor(Color.GREEN);
                        }
                        count++;
                        b.setText("Clear");
                    }
                }
                else{
                    et1.setText("");
                    et2.setText("");
                    et3.setText("");
                    et4.setText("");
                    et5.setText("");
                    t.setText("");
                    b.setText("Compute GPA");
                    t.setBackgroundColor(Color.WHITE);
                    count++;
                }
            }
        });
    }
}