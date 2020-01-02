package in.cdac.desd.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvmain;
    float i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvmain=findViewById(R.id.text1);
        i=tvmain.getTextSize();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode==KeyEvent.KEYCODE_VOLUME_DOWN)
        {
            tvmain.setTextSize(i--);
            return true;
        }
        if(keyCode==KeyEvent.KEYCODE_VOLUME_UP)
        {
            tvmain.setTextSize(i++);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}