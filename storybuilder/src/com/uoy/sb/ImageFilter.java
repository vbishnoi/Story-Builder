/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoy.sb;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author Y0239881
 */

/* ImageFilter.java */

public class ImageFilter extends FileFilter {

    //Accept all directories and all gif, jpg, tiff, or png files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Common.getExtension(f);
        if (extension != null) {
            if (extension.equals(Common.ImageType.tiff)
                    || extension.equals(Common.ImageType.tif)
                    || extension.equals(Common.ImageType.gif)
                    || extension.equals(Common.ImageType.jpeg)
                    || extension.equals(Common.ImageType.jpg)
                    || extension.equals(Common.ImageType.png)) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Select Images";
    }
}