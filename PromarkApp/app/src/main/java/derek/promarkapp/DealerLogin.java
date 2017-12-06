package derek.promarkapp;

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
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import java.util.Objects;


public class DealerLogin extends AppCompatActivity implements
        OnEditorActionListener, OnClickListener {

    private EditText user;
    private EditText pass;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dealer_login);

        user = (EditText)
                findViewById(R.id.userName);
        pass = (EditText)
                findViewById(R.id.password);

        login = (Button)
                findViewById(R.id.btnLogin);

        login.setOnClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {

        String userText = user.getText().toString();
        String passText = pass.getText().toString();


        if (v.getId() == R.id.btnLogin) {
            if ((Objects.equals(userText, "lukerduker99")) && (Objects.equals(passText, "password"))) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Login Successful");
                builder.setMessage("Welcome Luke.");

                builder.setPositiveButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();

                setContentView(R.layout.activity_navigation_page);
                Intent dealerLogin = new Intent(DealerLogin.this, NavigationPage.class);
                startActivity(dealerLogin);

            }
            else {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Login Not Successful");
                builder.setMessage("Please enter a correct username / password");

                builder.setPositiveButton("OK", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}

