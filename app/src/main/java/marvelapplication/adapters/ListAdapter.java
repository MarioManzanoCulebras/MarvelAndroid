package marvelapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.trey.marvel.model.api.vo.Character;

import java.util.List;

import marvelapplication.usxmobile.es.marvelapplication.R;

/**
 * Created by Mario on 04/11/2017.
 */

public class ListAdapter extends ArrayAdapter<Character> {

  private final Context context;
  private final List<Character> characterList;

  public ListAdapter(Context context, List<Character> values) {
    super(context, -1, values);
    this.context = context;
    this.characterList = values;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

    View rowView;
    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context
          .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      rowView = inflater.inflate(R.layout.character_item_list, parent, false);
    } else {
      rowView = convertView;
    }

    TextView textView = rowView.findViewById(R.id.character_name);
    textView.setText(characterList.get(position).name);
    ImageView imageView = rowView.findViewById(R.id.character_icon);
    Glide.with(context)
        .load(characterList.get(position).thumbnail.path + "/portrait_small." + characterList.get(
            position).thumbnail.extension)
        .into(imageView);
    notifyDataSetChanged();
    return rowView;
  }
}
