package in.cdac.desd.assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class firstActivity extends AppCompatActivity {
    Button btback;
    TextView tvname;
    TextView tvage;
    EditText etFb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        btback=findViewById(R.id.btnback);
        tvname=findViewById(R.id.name1);
        tvage=findViewById(R.id.age1);
        etFb=findViewById(R.id.editFB);

        Intent revIntent=getIntent();

        String recName=revIntent.getStringExtra("KEY_NAME");
        int recAge = revIntent.getIntExtra("KEY_AGE",0); // 0 is the default value of age.

        tvname.setText("NAME: "+recName);
        tvage.setText("AGE: "+recAge);

        btback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fb=etFb.getText().toString();
                Intent retintent=new Intent();
                retintent.putExtra("KEY_FB",fb);
                setResult(RESULT_OK,retintent);
                firstActivity.this.finish();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            Toast.makeText(
                    firstActivity.this,
                    "The button is disabled",
                    Toast.LENGTH_LONG
            ).show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}