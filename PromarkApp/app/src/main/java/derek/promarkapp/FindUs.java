package derek.promarkapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FindUs extends AppCompatActivity implements
        TextView.OnEditorActionListener, View.OnClickListener{

    private Button findUs;
    private Button back;
    private EditText location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_us);

        findUs = (Button)
                findViewById(R.id.btnFindLocation);
        back = (Button)
                findViewById(R.id.btnBak);
        location = (EditText)
                findViewById(R.id.txtAddress);

        findUs.setOnClickListener(this);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        String address = location.getText().toString();

        if(view.getId() == R.id.btnFindLocation){
            if(address == ""){
                Toast.makeText(getApplicationContext(), "Please enter an address.",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                String uri = "http://maps.google.com/maps?saddr=" + address + "&daddr=" + "Promark Window Film and Blinds";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        }
        else if(view.getId() == R.id.btnBak){
            setContentView(R.layout.activity_navigation_page);
            Intent backToMenu = new Intent(FindUs.this, NavigationPage.class);
            startActivity(backToMenu);
        }
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
