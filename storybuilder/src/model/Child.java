package model;

public class Child extends User {
    private String _image;
    private int _age;
    
    public Child() {
        
    }
    
    /**
     *
     * @param name
     * @param password
     * @param image
     * @param age
     */
    public Child(String name, String password, String image, int age) {
//        super(name, password);
        this._age = age;
        this._image = image;
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

    /**
     * @return the _age
     */
    public int getAge() {
        return _age;
    }

    /**
     * @param age the _age to set
     */
    public void setAge(int age) {
        this._age = age;
    }
}
