package tk.malekaltaf.form1.heythere;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView text34 = (TextView) findViewById(R.id.text34);
                        text34.setText("Hello");
                    }
                }
        );
        Button clear = (Button) findViewById(R.id.btn2);
        clear.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView text34 = (TextView) findViewById(R.id.text34);
                        text34.setText("BYE");
                    }
                }
        );

    }
}