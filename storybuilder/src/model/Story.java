package model;

import com.uoy.interfaces.StoryInterface;
import java.util.LinkedList;


public class Story implements StoryInterface {
    private int _id;
    private String _title;
    private String _backgroundColor;
    // Default font naem
    private String _font = "Arial";
    // Default font size 14
    private int _fontSize = 14;
    private String _textColor;
    private LinkedList<Page> _pages;
    private String _createdBy;
    private boolean _feedbackRequired = Boolean.FALSE;

    /**
     * @return the _id
     */
    @Override
    public int getId() {
        return _id;
    }

    /**
     * @param id the _id to set
     */
    @Override
    public void setId(int id) {
        this._id = id;
    }
    
    /**
     * @return the _title
     */
    @Override
    public String getTitle() {
        return _title;
    }

    /**
     * @param title the _title to set
     */
    @Override
    public void setTitle(String title) {
        this._title = title;
    }

    /**
     * @return the _backgroundColor
     */
    @Override
    public String getBackgroundColor() {
        return _backgroundColor;
    }

    /**
     * @param backgroundColor the _backgroundColor to set
     */
    @Override
    public void setBackgroundColor(String backgroundColor) {
        this._backgroundColor = backgroundColor;
    }

    /**
     * @return the _font
     */
    @Override
    public String getFont() {
        return _font;
    }

    /**
     * @param font the _font to set
     */
    @Override
    public void setFont(String font) {
        this._font = font;
    }

    /**
     * @return the _fontSize
     */
    @Override
    public int getFontSize() {
        return _fontSize;
    }

    /**
     * @param fontSize the _fontSize to set
     */
    @Override
    public void setFontSize(int fontSize) {
        this._fontSize = fontSize;
    }

    /**
     * @return the _textColor
     */
    @Override
    public String getTextColor() {
        return _textColor;
    }

    /**
     * @param textColor the _textColor to set
     */
    @Override
    public void setTextColor(String textColor) {
        this._textColor = textColor;
    }

    /**
     * @return the _pages
     */
    @Override
    public LinkedList<Page> getPages() {
        return _pages;
    }

    /**
     * @param pages the _pages to set
     */
    @Override
    public void setPages(LinkedList<Page> pages) {
        this._pages = pages;
    }
    
    /**
     * @return the _createdBy
     */
    @Override
    public String getCreatedBy() {
        return _createdBy;
    }

    /**
     * @param createdBy the _createdBy to set
     */
    @Override
    public void setCreatedBy(String createdBy) {
        this._createdBy = createdBy;
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

    /**
     * @return the _feedbackRequired
     */
    @Override
    public boolean isFeedbackRequired() {
        return _feedbackRequired;
    }

    /**
     * @param feedbackRequired the _feedbackRequired to set
     */
    @Override
    public void setFeedbackRequired(boolean feedbackRequired) {
        this._feedbackRequired = feedbackRequired;
    }

    

    
}
