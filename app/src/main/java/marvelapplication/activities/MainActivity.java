package marvelapplication.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.trey.marvel.model.api.MarvelApi;
import com.trey.marvel.model.api.manager.CharacterManager;
import com.trey.marvel.model.api.request.CharacterRequest;
import com.trey.marvel.model.api.request.RequestSignature;
import com.trey.marvel.model.api.response.ServiceResponse;
import com.trey.marvel.model.api.vo.Character;

import java.util.List;

import marvelapplication.adapters.ListAdapter;
import marvelapplication.model.ParceableCharacter;
import marvelapplication.usxmobile.es.marvelapplication.R;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {
  public static String SER_KEY = "character";

  private ListView listView;
  private Context mainActivityContext;
  private TextView charging_textview;
  private List<Character> characterList;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    MarvelApi.create("74df4d68319995712a351977df04ce64c3657460", "d3b82d4b24b6568a5e075cdd5e7c5c35",
        getApplicationContext(), 5 * 1024 * 1024);
    mainActivityContext = this;
    listView = findViewById(R.id.characters_list);
    charging_textview = findViewById(R.id.charging_textView);
    final CharacterRequest characterRequest = new CharacterRequest(RequestSignature.create());
    characterRequest.setLimit(50);
    characterRequest.setOffset(0);

    CharacterManager client = new CharacterManager();
    client.listCharacters(characterRequest, new Callback<ServiceResponse<Character>>() {
      @Override
      public void success(ServiceResponse<Character> characterServiceResponse, Response response) {
        Toast.makeText(getApplicationContext(), "Conexion with Marvel Success", Toast.LENGTH_LONG)
            .show();
        charging_textview.setVisibility(View.INVISIBLE);
        characterList = characterServiceResponse.data.results;
        listView.setAdapter(new ListAdapter(mainActivityContext, characterList));
      }

      @Override
      public void failure(RetrofitError error) {
        Toast.makeText(getApplicationContext(), error.getResponse().getReason(), Toast.LENGTH_LONG)
            .show();
        charging_textview.setText("Error");
      }
    });

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Character character = characterList.get(position);
        ParceableCharacter pCharacter =
            new ParceableCharacter(character.name, character.description,
                character.thumbnail.path + "/landscape_large." + character.thumbnail.extension);
        Intent intent = new Intent(MainActivity.this, CharacterDetailActivity.class);
        Bundle mBundle = new Bundle();
        mBundle.putParcelable(SER_KEY, pCharacter);
        intent.putExtras(mBundle);
        startActivity(intent);
      }
    });
  }
}
