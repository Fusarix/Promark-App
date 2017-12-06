package derek.promarkapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.app.Activity;
import java.util.Objects;
import java.util.List;

public class MainPage extends AppCompatActivity implements OnClickListener, OnEditorActionListener{

    private EditText firstName;
    private EditText lastName;
    private Button btnStart;
    private Button btnDealer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        firstName = (EditText)
                findViewById(R.id.firstName);
        lastName = (EditText)
                findViewById(R.id.lastName);
        btnStart = (Button)
                findViewById(R.id.btnStart);
        btnDealer = (Button)
                findViewById(R.id.btnDealer);

        btnStart.setOnClickListener(this);
        btnDealer.setOnClickListener(this);

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        String name = firstName.getText().toString();
        String last = lastName.getText().toString();


        if(v.getId() == R.id.btnStart){
            if(Objects.equals(name, "")){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Error");
                builder.setMessage("Please enter your first name.");

                builder.setPositiveButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
            if(Objects.equals(last, "")){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Error");
                builder.setMessage("Please enter your last name.");

                builder.setPositiveButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
            else{

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Welcome");
                builder.setMessage("Welcome to our promark application, " + name + " " + last);

                builder.setPositiveButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();

                setContentView(R.layout.activity_film_list);
                Intent filmList = new Intent(MainPage.this, FilmList.class);
                startActivity(filmList);
            }
        }
        else if(v.getId() == R.id.btnDealer){
            setContentView(R.layout.activity_dealer_login);
            Intent dealerLogin = new Intent(MainPage.this, DealerLogin.class);
            startActivity(dealerLogin);
        }
    }

        @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        return false;
    }
}

