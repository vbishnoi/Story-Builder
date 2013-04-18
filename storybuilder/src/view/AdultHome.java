/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.uoy.sb.Global;
import com.uoy.sb.ImageComponent;
import controller.StoryController;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import model.Story;

/**
 *
 * @author Y0239881
 */
public class AdultHome extends javax.swing.JPanel {

    private LinkedList<Story> allStories = null;
    private LinkedList<Story> createdByMe = null;

    /**
     * Creates new form AdultHome
     */
    public AdultHome() {
        initComponents();

        StoryController sc = new StoryController();
        allStories = sc.getAllStories();
        createdByMe = sc.getStoriesByUser(Global.loggedInUser);

        final DefaultListModel model = new DefaultListModel();
        for (Story s : allStories) {
            model.addElement(s.getTitle());

            // print out to test
//            System.out.println(s.getTitle());
        }

        allStoryList.setModel(model);

        final DefaultListModel createdByMeModel = new DefaultListModel();
        for (Story s : createdByMe) {
            createdByMeModel.addElement(s.getTitle());

            // print out to test
//            System.out.println(s.getTitle());
        }

        createdByMeList.setModel(createdByMeModel);

        allStoryList.addMouseListener(new StoryListMouseListener());
        createdByMeList.addMouseListener(new StoryListMouseListener());
    }

    class StoryListMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JList list = (JList) e.getSource();

            // double click
            if (e.getClickCount() == 2) {
                int selectedIndex = list.getSelectedIndex();

//                CreatePage pe = null;
                CreateStory story = null;

                if (jTabs.getSelectedIndex() == 0) {
                    story = new CreateStory(createdByMe.get(selectedIndex).getId());
                } else {
                    story = new CreateStory(allStories.get(selectedIndex).getId());
                }

                Global.container.setDisplay(story);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseEntered(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void mouseExited(MouseEvent e) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

//    @Override
//    public void addNotify() {
//        getParent().revalidate();
//        repaint();
//        super.addNotify();
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelUserImage = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabsPanel = new javax.swing.JPanel();
        jTabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        createdByMeList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        allStoryList = new javax.swing.JList();
        buttonPanel = new javax.swing.JPanel();
        btnNewStory = new javax.swing.JButton();
        btnManageChildren = new javax.swing.JButton();
        buttonDeleteStory = new javax.swing.JButton();
        buttonViewFeedback = new javax.swing.JButton();
        buttonPrintStory = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(650, 650));

        panelUserImage.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        org.jdesktop.layout.GroupLayout panelUserImageLayout = new org.jdesktop.layout.GroupLayout(panelUserImage);
        panelUserImage.setLayout(panelUserImageLayout);
        panelUserImageLayout.setHorizontalGroup(
            panelUserImageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 98, Short.MAX_VALUE)
        );
        panelUserImageLayout.setVerticalGroup(
            panelUserImageLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 97, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel1.setText("Welcome, user");

        createdByMeList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(createdByMeList);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 457, Short.MAX_VALUE)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 397, Short.MAX_VALUE)
            .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );

        jTabs.addTab("My Stories", jPanel1);

        allStoryList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(allStoryList);

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );

        jTabs.addTab("All stories", jPanel2);

        org.jdesktop.layout.GroupLayout tabsPanelLayout = new org.jdesktop.layout.GroupLayout(tabsPanel);
        tabsPanel.setLayout(tabsPanelLayout);
        tabsPanelLayout.setHorizontalGroup(
            tabsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jTabs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 478, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        tabsPanelLayout.setVerticalGroup(
            tabsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tabsPanelLayout.createSequentialGroup()
                .add(jTabs, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 443, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );

        btnNewStory.setText("Create new story");
        btnNewStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewStoryActionPerformed(evt);
            }
        });

        btnManageChildren.setText("Manage Children");
        btnManageChildren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageChildrenActionPerformed(evt);
            }
        });

        buttonDeleteStory.setText("Delete Story");
        buttonDeleteStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteStoryActionPerformed(evt);
            }
        });

        buttonViewFeedback.setText("Vied Feedback");

        buttonPrintStory.setText("Print Story");
        buttonPrintStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintStoryActionPerformed(evt);
            }
        });

        jButton1.setText("View Story");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout buttonPanelLayout = new org.jdesktop.layout.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(buttonDeleteStory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(buttonViewFeedback, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(buttonPrintStory, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(btnManageChildren, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
            .add(buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(buttonPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .add(btnNewStory)
                    .addContainerGap(20, Short.MAX_VALUE)))
        );

        buttonPanelLayout.linkSize(new java.awt.Component[] {btnManageChildren, btnNewStory, buttonDeleteStory, buttonPrintStory, buttonViewFeedback}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .add(jButton1)
                .add(38, 38, 38)
                .add(btnManageChildren)
                .add(18, 18, 18)
                .add(buttonDeleteStory)
                .add(18, 18, 18)
                .add(buttonViewFeedback)
                .add(18, 18, 18)
                .add(buttonPrintStory)
                .add(7, 7, 7))
            .add(buttonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(buttonPanelLayout.createSequentialGroup()
                    .add(18, 18, 18)
                    .add(btnNewStory)
                    .addContainerGap(232, Short.MAX_VALUE)))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(14, 14, 14)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(panelUserImage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(14, 14, 14)
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 320, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(tabsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(buttonPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(panelUserImage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 99, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(tabsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(buttonPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewStoryActionPerformed
        Global.container.setDisplay(new CreateStory());
    }//GEN-LAST:event_btnNewStoryActionPerformed

    private void btnManageChildrenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageChildrenActionPerformed
        Global.container.setDisplay(new ChildList());

    }//GEN-LAST:event_btnManageChildrenActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedIndex = -1;
        Story s = null;

        if (jTabs.getSelectedIndex() == 0) {
            selectedIndex = createdByMeList.getSelectedIndex();
            if (selectedIndex != -1) {
                s = createdByMe.get(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Please select story to view");
            }
        } else {
            selectedIndex = allStoryList.getSelectedIndex();
            if (selectedIndex != -1) {
                s = allStories.get(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(this, "Please select story to view");
            }
        }

        if (s != null) {
            Global.container.setDisplay(new ReadStory(s.getId()));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonDeleteStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteStoryActionPerformed
        JPanel panel = new JPanel();
//        panel.add(new ImageComponent("/Users/tuanva/Pictures/IMAG0020.jpg"));

        Image image = null;
        try {
            image = ImageIO.read(new File("/Users/tuanva/Pictures/IMAG0020.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(AdultHome.class.getName()).log(Level.SEVERE, null, ex);
        }

        JLabel lblimage = new JLabel(new ImageIcon(image));

        panel.add(lblimage);

        Global.container.setDisplay(panel);
    }//GEN-LAST:event_buttonDeleteStoryActionPerformed

    private void buttonPrintStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintStoryActionPerformed
        Global.container.showModalDialog(new printPanel(), "Print story");
    }//GEN-LAST:event_buttonPrintStoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList allStoryList;
    private javax.swing.JButton btnManageChildren;
    private javax.swing.JButton btnNewStory;
    private javax.swing.JButton buttonDeleteStory;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton buttonPrintStory;
    private javax.swing.JButton buttonViewFeedback;
    private javax.swing.JList createdByMeList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabs;
    private javax.swing.JPanel panelUserImage;
    private javax.swing.JPanel tabsPanel;
    // End of variables declaration//GEN-END:variables
}
