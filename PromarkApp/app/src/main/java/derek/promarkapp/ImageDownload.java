package derek.promarkapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;

public class ImageDownload extends AppCompatActivity {

    String URL = "https://www.somfysystems.com/common/img/minisites/nam_v4/nam_v4_032768-2081/logo/341x130/promark_logo_png_-_colour.png";
    ImageView image;
    Button button;
    Button back;
    ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_download);

        image = (ImageView) findViewById(R.id.imgView);
        button = (Button) findViewById(R.id.btnDownload);
        back = (Button) findViewById(R.id.btnBacktoNav);


        button.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                new DownloadImage().execute(URL);
            }
        });

        back.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                setContentView(R.layout.activity_navigation_page);
                Intent nav = new Intent(ImageDownload.this, NavigationPage.class);
                startActivity(nav);
            }
        });
    }

    private class DownloadImage extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            mProgressDialog = new ProgressDialog(ImageDownload.this);
            mProgressDialog.setTitle("Download Image Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Bitmap doInBackground(String... URL) {

            String imageURL = URL[0];

            Bitmap bitmap = null;
            try {

                InputStream input = new java.net.URL(imageURL).openStream();

                bitmap = BitmapFactory.decodeStream(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }
        @Override
        protected void onPostExecute(Bitmap result) {
            image.setImageBitmap(result);
            mProgressDialog.dismiss();
        }
    }
}
