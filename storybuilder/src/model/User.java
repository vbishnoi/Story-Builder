package model;

/**
 *
 * @author Y0239881
 */

public class User {
    
    private String _name;
    private String _password;
    private String _image;

    /**
     * @return the _name
     */
    public String getName() {
        return _name;
    }

    /**
     * @param name the _name to set
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * @return the _password
     */
    public String getPassword() {
        return _password;
    }

    /**
     * @param password the _password to set
     */
    public void setPassword(String password) {
        this._password = password;
    }

    /**
     * @return the _image
     */
    public String getImage() {
        return _image;
    }

    /**
     * @param image the _image to set
     */
    public void setImage(String image) {
        this._image = image;
    }
    
    public User(String name, String password, String image) {
        this._image = image;
        this._name = name;
        this._password = password;
        
    }
    
    public User() {
        
    }
    
}
