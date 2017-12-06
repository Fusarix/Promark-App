package derek.promarkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FilmList extends AppCompatActivity implements
        TextView.OnEditorActionListener, View.OnClickListener {

    private Button rs20;
    private Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        rs20 = (Button)
                findViewById(R.id.btnRS20);
        backToMain = (Button)
                findViewById(R.id.btnBack);

        backToMain.setOnClickListener(this);
        rs20.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRS20) {
            setContentView(R.layout.activity_rs20_page);
            Intent filmSpecs = new Intent(FilmList.this, RS20Page.class);
            startActivity(filmSpecs);
        }
        else if(view.getId() == R.id.btnSB20)
        {

        }
        else if(view.getId()== R.id.btnBack){
            setContentView(R.layout.activity_navigation_page);
            Intent nav = new Intent(FilmList.this, NavigationPage.class);
            startActivity(nav);
        }

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}