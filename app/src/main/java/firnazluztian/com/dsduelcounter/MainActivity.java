package firnazluztian.com.dsduelcounter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int mScore, mGoal;
    TextView value;
    EditText mEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //welcome message
        Toast toast = Toast.makeText(MainActivity.this,"praise the sun!! \\(^^)/ ",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 100);
        toast.show();
        Toast toast2 = Toast.makeText(MainActivity.this,"caution: dont put empty value here!",Toast.LENGTH_SHORT);
        toast2.setGravity(Gravity.TOP,0,0);
        toast2.show();

        // buttons
        Button win = (Button) findViewById(R.id.win);
        Button lose = (Button) findViewById(R.id.lose);
        Button reset = (Button) findViewById(R.id.reset);
        Button goal = (Button) findViewById(R.id.goal);

        //display score
        value = (TextView) findViewById(R.id.score);

        //enter value
        mEdit = (EditText) findViewById(R.id.edit);

        mEdit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_DPAD_CENTER:
                        case KeyEvent.KEYCODE_ENTER:
                            // input users value
                            mScore = Integer.valueOf(mEdit.getText().toString());
                            // display

                            if (mScore <= 500) {
                                value.setText(mScore + "");
                                mEdit.setText("");
                            } else {
                                Toast toast = Toast.makeText(MainActivity.this, "value must be under or equal to 500 scrub!", Toast.LENGTH_SHORT);
                                toast.setGravity(Gravity.TOP, 0, 100);
                                toast.getView().setBackgroundColor(Color.RED);
                                toast.show();
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return false;

            }
        });

        win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calculate winning
                mScore = mScore + 1;
                value.setText(mScore + "");
                Toast toast = Toast.makeText(MainActivity.this, "Not bad, casul!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 100);
                toast.show();

            }
        });

        lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calculate losing
                mScore = mScore - 1;
                value.setText(mScore + "");
                Toast toast = Toast.makeText(MainActivity.this, "Git Gud Scrub!",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 100);
                toast.show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // reset value
                mScore = 0;
                value.setText(mScore + "");
                Toast toast = Toast.makeText(MainActivity.this, "Score has been returned back to zero",Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 100);
                toast.show();
            }
        });

        goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGoal = 500 - mScore;
                Toast toast = Toast.makeText(MainActivity.this, "You need " + mGoal + " more duels to get rank3", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP, 0, 100);
                toast.getView().setBackgroundColor(Color.BLUE);
                toast.show();

            }
        });
    }
}
