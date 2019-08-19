package com.example.feelme;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class Imageuploading {
    String name;
    Bitmap url;

    public Imageuploading(String name, Bitmap url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public Bitmap getUrl() {
        return url;
    }
}
