package derek.promarkapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NavigationPage extends AppCompatActivity implements
        TextView.OnEditorActionListener, View.OnClickListener {

    private Button filmList;
    private Button contactUs;
    private Button gallery;
    private Button filmTimer;
    private Button backToLogin;
    private Button findUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_page);

        filmList = (Button)
                    findViewById(R.id.btnFilmList);
        contactUs = (Button)
                    findViewById(R.id.btnEmail);
        gallery = (Button)
                    findViewById(R.id.btnGallery);
        filmTimer = (Button)
                    findViewById(R.id.btnTimer);
        findUs = (Button)
                    findViewById(R.id.btnFindUs);
        backToLogin = (Button)
                    findViewById(R.id.btnBacktoLogin);

        filmTimer.setOnClickListener(this);
        filmList.setOnClickListener(this);
        contactUs.setOnClickListener(this);
        findUs.setOnClickListener(this);
        gallery.setOnClickListener(this);
        backToLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnFilmList){
            setContentView(R.layout.activity_film_list);
            Intent dealerLogin = new Intent(NavigationPage.this, FilmList.class);
            startActivity(dealerLogin);
        }
        else if(view.getId() == R.id.btnEmail) {

            Toast.makeText(getApplicationContext(), "Email us at: luke@promark.ca",
                    Toast.LENGTH_SHORT).show();

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            startActivity(emailIntent);
        }
        else if(view.getId() == R.id.btnGallery){
            setContentView(R.layout.activity_photo_gallery);
            Intent gallery = new Intent(NavigationPage.this, PhotoGallery.class);
            startActivity(gallery);
        }
        else if(view.getId() == R.id.btnTimer){
            setContentView(R.layout.activity_image_download);
            Intent timer = new Intent(NavigationPage.this, ImageDownload.class);
            startActivity(timer);
        }
        else if(view.getId() == R.id.btnFindUs){
            setContentView(R.layout.activity_find_us);
            Intent find = new Intent(NavigationPage.this, FindUs.class);
            startActivity(find);
        }
        else if(view.getId() == R.id.btnBacktoLogin){
            setContentView(R.layout.activity_main_page);
            Intent backToLogin = new Intent(NavigationPage.this, MainPage.class);
            startActivity(backToLogin);
        }

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
