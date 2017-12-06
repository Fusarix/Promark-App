package derek.promarkapp;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class RS20Page extends AppCompatActivity implements View.OnClickListener, TextView.OnEditorActionListener {

    private Button btnBacktoList;
    private TextView txtfilmName;
    private TextView txtTseTransmitted;
    private TextView txtTseReflected;
    private TextView txtTseAbsorbed;
    private TextView txtVlTransmitted;
    private TextView txtVlReflected;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs20_page);

        txtfilmName = (TextView)
                findViewById(R.id.txtFilmName);
        txtTseTransmitted = (TextView)
                findViewById(R.id.txtTseTransmitted);
        txtTseReflected = (TextView)
                findViewById(R.id.txtTseReflected);
        txtTseAbsorbed = (TextView)
                findViewById(R.id.txtTseAbsorbed);
        txtVlTransmitted = (TextView)
                findViewById(R.id.txtVlTransmitted);
        txtVlReflected= (TextView)
                findViewById(R.id.txtVlReflected);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "promark").allowMainThreadQueries().build();

        Film film = new Film(1, "RS-20 Reflective Silver", 13, 52, 35, 19, 57);
        db.filmDao().insertAll(film);

        String filmName= "";
        int tseTransmitted;
        int tseReflected;
        int tseAbsorbed;
        int vlTransmitted;
        int vlReflected;

        filmName = db.filmDao().getFilmName(1);
        tseTransmitted = db.filmDao().getTseTransmitted(1);
        tseReflected = db.filmDao().getTseReflected(1);
        tseAbsorbed = db.filmDao().getTseAbsorbed(1);
        vlTransmitted = db.filmDao().getVlTransmitted(1);
        vlReflected = db.filmDao().getVlReflected(1);

        txtfilmName.setText(filmName);
        txtTseTransmitted.setText(String.valueOf(tseTransmitted));
        txtTseReflected.setText(String.valueOf(tseReflected));
        txtTseAbsorbed.setText(String.valueOf(tseAbsorbed));
        txtVlTransmitted.setText(String.valueOf(vlTransmitted));
        txtVlReflected.setText(String.valueOf(vlReflected));

        btnBacktoList = (Button)
                findViewById(R.id.btnBackToList);

        btnBacktoList.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnBackToList){
            setContentView(R.layout.activity_film_list);
            Intent backToFilmList = new Intent(RS20Page.this, FilmList.class);
            startActivity(backToFilmList);
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
