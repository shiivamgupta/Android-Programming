package in.cdac.desd.assignment1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText ename, eroll, ec, ecpp, ejava;
    TextView ttotal, tpercent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.bt1);
        ename = findViewById(R.id.et1);
        eroll = findViewById(R.id.et2);
        ec = findViewById(R.id.et3);
        ecpp = findViewById(R.id.et4);
        ejava = findViewById(R.id.et5);
        ttotal = findViewById(R.id.tv1);
        tpercent = findViewById(R.id.tv2);

    }

    public void submit_first(View view) {
        String name = ename.getText().toString();
        int roll = Integer.parseInt(eroll.getText().toString());
        int marks1 = Integer.parseInt(ec.getText().toString());
        int marks2 = Integer.parseInt(ecpp.getText().toString());
        int marks3 = Integer.parseInt(ejava.getText().toString());
        String action = "desdaction2";
        Intent intent = new Intent(action);
        intent.putExtra("KEY_NAME", name);
        intent.putExtra("KEY_ROLL", roll);
        intent.putExtra("KEY_MARKS1", marks1);
        intent.putExtra("KEY_MARKS2", marks2);
        intent.putExtra("KEY_MARKS3", marks3);

        startActivityForResult(intent, 11);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);//data from first activity to main

        if (requestCode == 11 && resultCode == RESULT_OK) {
            int tot = data.getIntExtra("KEY_TOTAL",0);
            float per = (tot/3);
            ttotal.setText("Total : "+tot);
            tpercent.setText("% : "+per);
            ttotal.setVisibility(View.VISIBLE);
            tpercent.setVisibility(View.VISIBLE);
        }
    }
}