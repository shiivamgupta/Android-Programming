package in.cdac.desd.assignment3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnsub1;
    Button btback;
    EditText namee,agee;
    EditText tvdisFB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnsub1=findViewById(R.id.btnsub);
        btback=findViewById(R.id.btnback);
        namee=findViewById(R.id.name);
        agee=findViewById(R.id.age);
        tvdisFB=findViewById(R.id.disFB);

        btnsub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = namee.getText().toString();
                // namee.setText("");
                int a = Integer.parseInt(agee.getText().toString());
                //agee.setText("");
                String action = "DESD";    // user defined name for our intent.
                Intent intent=new Intent(action);
                intent.putExtra("KEY_NAME",n);
                intent.putExtra("KEY_AGE",a);
                //startActivity(intent);
                startActivityForResult(intent,11);
            }

        });
        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==11&&resultCode==RESULT_OK){
            String fb=data.getStringExtra("KEY_FB");
            tvdisFB.setVisibility(View.VISIBLE);
            tvdisFB.setTextColor(Color.BLUE);
            tvdisFB.setText("Feedback:"+fb);

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(
                    MainActivity.this,
                    "The button is disabled",
                    Toast.LENGTH_SHORT
            ).show();
            return true;
        }
        if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN)
        {
            Toast.makeText(
                    MainActivity.this,
                    "The button is disabled",
                    Toast.LENGTH_SHORT
            ).show();
            return true;
        }
        if(keyCode==KeyEvent.KEYCODE_VOLUME_UP)
        {
            Toast.makeText(
                    MainActivity.this,
                    "The button is disabled",
                    Toast.LENGTH_SHORT
            ).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}