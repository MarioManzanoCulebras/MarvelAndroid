package marvelapplication.usxmobile.es.marvelapplication.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.character_item_list, parent, false);
        TextView textView = rowView.findViewById(R.id.character_name);
        ImageView imageView = rowView.findViewById(R.id.character_icon);
        textView.setText(characterList.get(position).name);
        //Todo: imageView.setImageURI(Uri.parse(characterList.get(position).resourceURI));
        //imageView.setImageURI(characterList.get(position).);
        return rowView;
    }
}
