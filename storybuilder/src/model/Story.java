package model;

import java.util.LinkedList;


public class Story {
    private String _title;
    private String _backgroundColor;
    private String _font;
    private int _fontSize;
    private String _textColor;
    private LinkedList<Page> _pages;

    /**
     * @return the _title
     */
    public String getTitle() {
        return _title;
    }

    /**
     * @param title the _title to set
     */
    public void setTitle(String title) {
        this._title = title;
    }

    /**
     * @return the _backgroundColor
     */
    public String getBackgroundColor() {
        return _backgroundColor;
    }

    /**
     * @param backgroundColor the _backgroundColor to set
     */
    public void setBackgroundColor(String backgroundColor) {
        this._backgroundColor = backgroundColor;
    }

    /**
     * @return the _font
     */
    public String getFont() {
        return _font;
    }

    /**
     * @param font the _font to set
     */
    public void setFont(String font) {
        this._font = font;
    }

    /**
     * @return the _fontSize
     */
    public int getFontSize() {
        return _fontSize;
    }

    /**
     * @param fontSize the _fontSize to set
     */
    public void setFontSize(int fontSize) {
        this._fontSize = fontSize;
    }

    /**
     * @return the _textColor
     */
    public String getTextColor() {
        return _textColor;
    }

    /**
     * @param textColor the _textColor to set
     */
    public void setTextColor(String textColor) {
        this._textColor = textColor;
    }

    /**
     * @return the _pages
     */
    public LinkedList<Page> getPages() {
        return _pages;
    }

    /**
     * @param pages the _pages to set
     */
    public void setPages(LinkedList<Page> pages) {
        this._pages = pages;
    }
    
    public Story() {
        
    }
    
    /**
     *
     * @param title
     * @param backgroundColor
     * @param textColor
     * @param font
     * @param fontSize
     */
    public Story(String title, String backgroundColor, String textColor, String font, int fontSize) {
        this._title = title;
        this._backgroundColor = backgroundColor;
        this._textColor = textColor;
        this._font = font;
        this._fontSize = fontSize;
    }
}
