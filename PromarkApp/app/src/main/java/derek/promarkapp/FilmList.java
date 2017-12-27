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
    private Button sb20;
    private Button cl800;
    private Button backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_list);

        rs20 = (Button)
                findViewById(R.id.btnRS20);
        backToMain = (Button)
                findViewById(R.id.btnBack);
        sb20 = (Button)
                findViewById(R.id.btnSB20);
        cl800 = (Button)
                findViewById(R.id.btnCL800);

        backToMain.setOnClickListener(this);
        rs20.setOnClickListener(this);
        sb20.setOnClickListener(this);
        cl800.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnRS20) {
            setContentView(R.layout.activity_rs20_page);
            Intent rs20 = new Intent(FilmList.this, RS20Page.class);
            startActivity(rs20);
        }
        else if(view.getId() == R.id.btnSB20)
        {
            setContentView(R.layout.activity_sb20_page);
            Intent sb20 = new Intent(FilmList.this, SB20Page.class);
            startActivity(sb20);
        } else if (view.getId() == R.id.btnCL800) {
            setContentView(R.layout.activity_cl800);
            Intent cl800 = new Intent(FilmList.this, CL800.class);
            startActivity(cl800);

        } else {
            if (view.getId() == R.id.btnBack) {
                setContentView(R.layout.activity_navigation_page);
                Intent nav = new Intent(FilmList.this, NavigationPage.class);
                startActivity(nav);
            }
        }

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}