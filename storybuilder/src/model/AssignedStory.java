/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Y0239881
 */
public class AssignedStory {
    private String _user;
    private String _feedback;
    private boolean _isDone;
    private String _story;

    /**
     * @return the _user
     */
    public String getUser() {
        return _user;
    }

    /**
     * @param user the _user to set
     */
    public void setUser(String user) {
        this._user = user;
    }

    /**
     * @return the _feedback
     */
    public String getFeedback() {
        return _feedback;
    }

    /**
     * @param feedback the _feedback to set
     */
    public void setFeedback(String feedback) {
        this._feedback = feedback;
    }

    /**
     * @return the _isDone
     */
    public boolean isIsDone() {
        return _isDone;
    }

    /**
     * @param isDone the _isDone to set
     */
    public void setIsDone(boolean isDone) {
        this._isDone = isDone;
    }

    /**
     * @return the _story
     */
    public String getStory() {
        return _story;
    }

    /**
     * @param story the _story to set
     */
    public void setStory(String story) {
        this._story = story;
    }
}
