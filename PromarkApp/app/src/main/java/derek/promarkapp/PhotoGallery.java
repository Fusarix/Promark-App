package derek.promarkapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhotoGallery extends AppCompatActivity implements
        TextView.OnEditorActionListener, View.OnClickListener {

    private Button backButton;

    String[] listviewTitle = new String[]{
            "Solar Control Film", "Solar Control Film", "Solar Control Film", "Solar Control Film",
            "Solar Control Film", "Computer Cut Film"
    };


    int[] listviewImage = new int[]{
            R.drawable.gallery1, R.drawable.gallery2, R.drawable.gallery3,
            R.drawable.gallery4, R.drawable.gallery5, R.drawable.gallery6
    };

    String[] listviewShortDescription = new String[]{
            " ", " ", " ", " ",
            " ", " "
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_gallery);

        backButton = (Button)
                findViewById(R.id.btnBackToMenu);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 6; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview_activity, from, to);
        ListView androidListView = (ListView) findViewById(R.id.listView);
        androidListView.setAdapter(simpleAdapter);

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        return false;
    }
}
