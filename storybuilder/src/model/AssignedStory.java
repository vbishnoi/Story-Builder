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

    private Story _story;
    private Child _child;
    private Feedback _feedback;
    private int _completed;

    /**
     * @return the _story
     */
    public Story getStory() {
        return _story;
    }

    /**
     * @param story the _story to set
     */
    public void setStory(Story story) {
        this._story = story;
    }

    /**
     * @return the _child
     */
    public Child getChild() {
        return _child;
    }

    /**
     * @param child the _child to set
     */
    public void setChild(Child child) {
        this._child = child;
    }

    /**
     * @return the _feedback
     */
    public Feedback getFeedback() {
        return _feedback;
    }

    /**
     * @param feedback the _feedback to set
     */
    public void setFeedback(Feedback feedback) {
        this._feedback = feedback;
    }

    /**
     * @return the _completed
     */
    public int getCompleted() {
        return _completed;
    }

    /**
     * @param completed the _completed to set
     */
    public void setCompleted(int completed) {
        this._completed = completed;
    }

    /**
     *
     * @param story
     * @param child
     * @param feedback
     * @param completed
     */
    public AssignedStory(Story story, Child child, Feedback feedback, int completed) {
        this._child = child;
        this._story = story;
        this._feedback = feedback;
        this._completed = completed;
    }
}
