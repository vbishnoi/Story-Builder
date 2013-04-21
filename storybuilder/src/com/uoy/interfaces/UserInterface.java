/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoy.interfaces;

import model.UserGroup;

/**
 *
 * @author Y0239881
 */
public interface UserInterface {

    /**
     * @return the _age
     */
    int getAge();

    /**
     * @return the _group
     */
    UserGroup getGroup();

    /**
     * @return the _image
     */
    String getImage();

    /**
     * @return the _name
     */
    String getName();

    /**
     * @return the _password
     */
    String getPassword();

    /**
     * @param age the _age to set
     */
    void setAge(int age);

    /**
     * @param group the _group to set
     */
    void setGroup(UserGroup group);

    /**
     * @param image the _image to set
     */
    void setImage(String image);

    /**
     * @param name the _name to set
     */
    void setName(String name);

    /**
     * @param password the _password to set
     */
    void setPassword(String password);
    
}
