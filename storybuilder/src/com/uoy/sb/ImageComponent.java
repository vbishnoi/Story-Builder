/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoy.sb;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Y0239881
 */
public class ImageComponent extends JComponent {

    private static final long serialVersionUID = 1L;
    private Image image;

    public ImageComponent(String path) {
        try {
            File image2 = new File(path);
            image = ImageIO.read(image2);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        if (image == null) {
            return;
        }
        
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        g.drawImage(image, 100, 100, this);

        for (int i = 0; i * imageWidth <= getWidth(); i++) {
            for (int j = 0; j * imageHeight <= getHeight(); j++) {
                if (i + j > 0) {
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
                }
            }
        }
    }
}
