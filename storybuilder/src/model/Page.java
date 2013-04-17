package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Page {

    private String text;
    private List<String> _images = new ArrayList<>();
    private String sound;

    public Page() {
    }

    public Page(String text) {
        this.text = text;
        this.sound = "";
    }

    public void setSound(String url) {
        sound = url;
    }

    @Override
    public String toString() {
        return this.getText();
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the _images
     */
    public List<String> getImages() {
        return _images;
    }

    /**
     * @param _images the _images to set
     */
    public void setImages(List<String> img) {
        this._images = img;
    }

    public void addImage(String image) {
        if (this._images != null) {
            this._images.add(image);
        }
    }

    /**
     * @return the sound
     */
    public String getSound() {
        return sound;
    }
}
