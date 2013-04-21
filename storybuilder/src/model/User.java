package model;

import com.uoy.interfaces.UserInterface;

/**
 *
 * @author Y0239881
 */

public class User implements UserInterface {
    
    private String _name;
    private String _password;
    private UserGroup _group;
    private String _image;
    private int _age = 0;

    /**
     * @return the _name
     */
    @Override
    public String getName() {
        return _name;
    }

    /**
     * @param name the _name to set
     */
    @Override
    public void setName(String name) {
        this._name = name;
    }

    /**
     * @return the _password
     */
    @Override
    public String getPassword() {
        return _password;
    }

    /**
     * @param password the _password to set
     */
    @Override
    public void setPassword(String password) {
        this._password = password;
    }
    
    public User(String name, String password, UserGroup group) {
        this._name = name;
        this._password = password;
        this._group = group;
    }
    
    public User() {
        
    }

    /**
     * @return the _group
     */
    @Override
    public UserGroup getGroup() {
        return _group;
    }

    /**
     * @param group the _group to set
     */
    @Override
    public void setGroup(UserGroup group) {
        this._group = group;
    }

    /**
     * @return the _image
     */
    @Override
    public String getImage() {
        return _image;
    }

    /**
     * @param image the _image to set
     */
    @Override
    public void setImage(String image) {
        this._image = image;
    }

    /**
     * @return the _age
     */
    @Override
    public int getAge() {
        return _age;
    }

    /**
     * @param age the _age to set
     */
    @Override
    public void setAge(int age) {
        this._age = age;
    }
    
}
