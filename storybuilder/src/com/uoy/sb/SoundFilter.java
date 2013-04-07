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
public class SoundFilter extends FileFilter {

    //Accept all directories and all mp3, wav or ogg files.
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String extension = Common.getExtension(f);
        if (extension != null) {
            if (extension.equals(Common.SoundType.wav) 
                    //                    || extension.equals(Common.SoundType.ogg)
                    //                    || extension.equals(Common.SoundType.pm3)
                    ) {
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    //The description of this filter
    public String getDescription() {
        return "Select Sound files";
    }
}
