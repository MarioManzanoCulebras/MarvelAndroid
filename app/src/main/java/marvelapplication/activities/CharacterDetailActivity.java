package marvelapplication.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import marvelapplication.model.ParceableCharacter;
import marvelapplication.usxmobile.es.marvelapplication.R;


public class CharacterDetailActivity extends AppCompatActivity {
    private ParceableCharacter pCharacter;
    private TextView charDescription;
    private ImageView charImage;


    private void findViewByIds(){
        charImage = findViewById(R.id.char_image);
        charDescription = findViewById(R.id.char_description);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        findViewByIds();
        pCharacter = getIntent().getParcelableExtra(MainActivity.SER_KEY);
        if (pCharacter!=null){
            setTitle(pCharacter.getName());
            charDescription.setText(!pCharacter.getDescription().isEmpty()?pCharacter.getDescription():"Sin descripción asociada.");
            Glide.with(this)
                    .load(pCharacter.getImageURI())
                    .into(charImage);
        }
    }


}
