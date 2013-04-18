/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoy.sb;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import javax.imageio.ImageIO;

/**
 *
 * @author Y0239881
 */
public class Common {

    public static final class ImageType {

        public final static String jpeg = "jpeg";
        public final static String jpg = "jpg";
        public final static String gif = "gif";
        public final static String tiff = "tiff";
        public final static String tif = "tif";
        public final static String png = "png";
    }

    public static final class SoundType {

        public final static String ogg = "ogg";
        public final static String mp3 = "mp3";
        public final static String wav = "wav";
    }

    public static final class Variables {
//        Database path

        public static final String DATABASE_NAME = "resources/database.xml";
        public static final String ROOT = "storybuilder";
        
//        Node names
        public static final String USER_IMAGE = "image";
        public static final String USER_AGE = "age";
//        adult
        public static final String ADULTS_NODE = "adults";
        public static final String ADULT_SINGLE_NODE = "adult";
        
//        page
        public static final String PAGES_NODE = "pages";
        public static final String PAGE_SINGLE_NODE = "page";
        public static final String PAGE_CONTENT = "content";
        public static final String PAGE_SOUND = "sound";
        public static final String PAGE_IMAGES = "images";
        public static final String PAGE_IMAGE = "image";
        
//        user
        public static final String USERS_NODE = "users";
        public static final String USER_SINGLE_NODE = "user";
        public static final String USER_NAME = "name";
        public static final String USER_PASSWORD = "password";
        public static final String USER_GROUP = "group";
//        story
        public static final String STORIES_NODE = "stories";
        public static final String STORY_SINGLE_NODE = "story";
        public static final String STORY_CREATED_BY = "createdby";
//        Story's Attributes
        public static final String STORY_BG_COLOR = "bgcolor";
        public static final String STORY_TEXT_COLOR = "textcolor";
        public static final String STORY_FONT = "font";
        public static final String STORY_FONT_SIZE = "fontsize";
        public static final String STORY_TITLE = "title";
        public static final String STORY_ID = "id";
        public static final String STORY_REQUIRE_FEEDBACK = "feedback_require";
        
        public static final String ASSIGNED_STORY = "item";
        public static final String ASSIGNED_STORY_STORY = "story";
        public static final String ASSIGNED_STORY_USER = "user";
        public static final String ASSIGNED_STORY_FEEDBACK = "feedback";
        public static final String ASSIGNED_STORY_DONE = "done";
    }

    public static class Security {

        /**
         * Generate hashed MD5 from plain string
         *
         * @param 
         * @return hashed string
         * http://m2tec.be/blog/2010/02/03/java-md5-hex-0093
         */
        public static String MD5(String plainText) {
            try {
                java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
                byte[] array = md.digest(plainText.getBytes());
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i < array.length; ++i) {
                    sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
                }
                return sb.toString();
            } catch (java.security.NoSuchAlgorithmException e) {
            }
            return null;
        }
    }

    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 && i < s.length() - 1) {
            ext = s.substring(i + 1).toLowerCase();
        }
        return ext;
    }
    
    public static Image readImage(String url)
	{
		try
		{
			return ImageIO.read(new File(url));
		}
		catch (IOException ex)
		{
		
                        return null;
		}
	}
}
