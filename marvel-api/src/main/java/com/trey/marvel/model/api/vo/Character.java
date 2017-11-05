package com.trey.marvel.model.api.vo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Trey Robinson on 2/12/14.
 */
public class Character implements Parcelable {

    public int id;
    public String name;
    public String description;
    public Date modified;
    public String resourceURI;
    public List<Url> urls;
    public ImageInfo thumbnail;
    public ItemList comics;
    public ItemList stories;
    public ItemList events;
    public ItemList series;

    protected Character(Parcel in) {
        id = in.readInt();
        name = in.readString();
        description = in.readString();
        resourceURI = in.readString();
    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

    public ImageInfo getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(ImageInfo thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ItemList getComics() {
        return comics;
    }

    public void setComics(ItemList comics) {
        this.comics = comics;
    }

    public ItemList getStories() {
        return stories;
    }

    public void setStories(ItemList stories) {
        this.stories = stories;
    }

    public ItemList getEvents() {
        return events;
    }

    public void setEvents(ItemList events) {
        this.events = events;
    }

    public ItemList getSeries() {
        return series;
    }

    public void setSeries(ItemList series) {
        this.series = series;
    }

    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(thumbnail.path);
    }
}
