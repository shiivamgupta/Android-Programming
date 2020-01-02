package in.cdac.desd.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    TextView total,tname,troll,tc,tcpp,tjava;
    TextView percent;
    int totalput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        total=findViewById(R.id.t6);
        tname=findViewById(R.id.t1);
        troll=findViewById(R.id.t2);
        tc=findViewById(R.id.t3);
        tcpp=findViewById(R.id.t4);
        tjava=findViewById(R.id.t5);
        percent=findViewById(R.id.t7);
        Intent recIntent=getIntent();

        String name=recIntent.getStringExtra("KEY_NAME");
        int roll = recIntent.getIntExtra("KEY_ROLL",0);
        int markc = recIntent.getIntExtra("KEY_MARKS1",0);
        int markcp = recIntent.getIntExtra("KEY_MARKS2",0);
        int markjava = recIntent.getIntExtra("KEY_MARKS3",0);

        totalput=totalxx(markc,markcp,markjava);

        tname.setText("NAME : "+name);
        troll.setText("ROLL NO :"+roll);
        tc.setText("C : "+markc);
        tcpp.setText("C++: "+markcp);
        tjava.setText("JAVA : "+markjava);
        total.setText("TOTAL : "+totalput);
        percent.setText("% : "+percentxx(markc,markcp,markjava));


    }

    private float percentxx(int m1, int m2, int m3) {
        return ((m1+m2+m3)/3);
    }


    public int totalxx(int m1, int m2, int m3){
        return (m1+m2+m3);
    }


    public void return_back(View view) {

//        int totalx=Integer.parseInt(total.getText().toString());
        Intent retIntent = new Intent();
        retIntent.putExtra("KEY_TOTAL",totalput);
        setResult(RESULT_OK,retIntent);
        FirstActivity.this.finish();
    }

}