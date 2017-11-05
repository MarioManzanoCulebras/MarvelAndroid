package marvelapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mario on 05/11/2017.
 */

public class ParceableCharacter implements Parcelable {

    private String name;
    private String description;
    private String imageURI;

    public ParceableCharacter(String name, String description, String imageURI) {
        this.name = name;
        this.description = description;
        this.imageURI = imageURI;
    }

    protected ParceableCharacter(Parcel in) {
        name = in.readString();
        description = in.readString();
        imageURI = in.readString();
    }

    public static final Parcelable.Creator<ParceableCharacter> CREATOR = new Parcelable.Creator<ParceableCharacter>() {
        @Override
        public ParceableCharacter createFromParcel(Parcel in) {
            return new ParceableCharacter(in);
        }

        @Override
        public ParceableCharacter[] newArray(int size) {
            return new ParceableCharacter[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURI() {
        return imageURI;
    }

    public void setImageURI(String imageURI) {
        this.imageURI = imageURI;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(imageURI);
    }
}
