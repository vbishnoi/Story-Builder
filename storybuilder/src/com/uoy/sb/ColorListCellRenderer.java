/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uoy.sb;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.lang.reflect.Field;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Y0239881
 */
public class ColorListCellRenderer extends JPanel implements ListCellRenderer {
    private JLabel lblName = new JLabel();
    private JPanel preview = new JPanel();

    public ColorListCellRenderer() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        preview.setPreferredSize(new Dimension(15, 15));
        add(preview);
        add(lblName);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

        Color color;
        try {
            Field field = Class.forName("java.awt.Color").getField(String.valueOf(value));
            color = (Color) field.get(null);
            
            preview.setBackground(color);
            lblName.setText(String.valueOf(value));
        } catch (Exception e) {
            color = null; // Not defined
        }
        
        return this;
    }
}
