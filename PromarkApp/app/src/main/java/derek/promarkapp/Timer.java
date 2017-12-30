package derek.promarkapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Timer extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {

    private Button startButton;

    private TextView timerValue;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        startButton = (Button)
                findViewById(R.id.btnStart);
        timerValue = (TextView)
                findViewById(R.id.txtTime);

        startButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnStart){
            new CountDownTimer(3600000, 1000) {

                public void onTick(long timeUntilFinished) {
                    timerValue.setText("Seconds Remaining: " + timeUntilFinished / 1000);
                }

                public void onFinish() {
                    timerValue.setText("Done!");
                }
            }.start();
        }

        else if(view.getId() == R.id.btnBackToNav){
            setContentView(R.layout.activity_navigation_page);
            Intent backtoMain = new Intent(Timer.this, NavigationPage.class);
            startActivity(backtoMain);
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}






