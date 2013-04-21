/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoy.interfaces;

import java.util.LinkedList;
import model.Page;

/**
 *
 * @author Y0239881
 */
public interface StoryInterface {

    /**
     * @return the _backgroundColor
     */
    String getBackgroundColor();

    /**
     * @return the _createdBy
     */
    String getCreatedBy();

    /**
     * @return the _font
     */
    String getFont();

    /**
     * @return the _fontSize
     */
    int getFontSize();

    /**
     * @return the _id
     */
    int getId();

    /**
     * @return the _pages
     */
    LinkedList<Page> getPages();

    /**
     * @return the _textColor
     */
    String getTextColor();

    /**
     * @return the _title
     */
    String getTitle();

    /**
     * @return the _feedbackRequired
     */
    boolean isFeedbackRequired();

    /**
     * @param backgroundColor the _backgroundColor to set
     */
    void setBackgroundColor(String backgroundColor);

    /**
     * @param createdBy the _createdBy to set
     */
    void setCreatedBy(String createdBy);

    /**
     * @param feedbackRequired the _feedbackRequired to set
     */
    void setFeedbackRequired(boolean feedbackRequired);

    /**
     * @param font the _font to set
     */
    void setFont(String font);

    /**
     * @param fontSize the _fontSize to set
     */
    void setFontSize(int fontSize);

    /**
     * @param id the _id to set
     */
    void setId(int id);

    /**
     * @param pages the _pages to set
     */
    void setPages(LinkedList<Page> pages);

    /**
     * @param textColor the _textColor to set
     */
    void setTextColor(String textColor);

    /**
     * @param title the _title to set
     */
    void setTitle(String title);
    
}
