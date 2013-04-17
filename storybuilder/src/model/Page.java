package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Page {

    private String text;
    private List<String> img = new ArrayList<>();
    private Color background;
    private String sound;


    public Page() {
    }

    public Page(String text) {
        this.text = text;
        this.background = Color.WHITE;
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
     * @return the img
     */
    public List<String> getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(List<String> img) {
        this.img = img;
    }

    /**
     * @return the sound
     */
    public String getSound() {
        return sound;
    }

}
