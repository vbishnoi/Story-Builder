/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.uoy.sb.Global;
import controller.UserStoryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Feedback;
import model.UserGroup;

/**
 *
 * @author Radical
 */
public class GiveFeedback extends javax.swing.JPanel implements ActionListener {

    private int _storyID = 0;
    private String _feedback = "";

    /**
     * @return the _storyID
     */
    public int getStoryID() {
        return _storyID;
    }

    /**
     * @param storyID the _storyID to set
     */
    public void setStoryID(int storyID) {
        this._storyID = storyID;
    }

    /**
     * Creates new form GiveFeedback
     */
    public GiveFeedback() {
        initComponents();

        btnGroup = new ButtonGroup();

        btnGroup.add(rdMad);
        btnGroup.add(rdConfused);
        btnGroup.add(rdHappy);
        btnGroup.add(rdSad);

        rdSad.setActionCommand("SAD");
        rdSad.addActionListener(this);

        rdMad.setActionCommand("MAD");
        rdMad.addActionListener(this);

        rdConfused.setActionCommand("CONFUSED");
        rdConfused.addActionListener(this);

        rdHappy.setActionCommand("HAPPY");
        rdHappy.addActionListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        btnFinish = new javax.swing.JButton();
        rdConfused = new javax.swing.JRadioButton();
        rdMad = new javax.swing.JRadioButton();
        rdSad = new javax.swing.JRadioButton();
        rdHappy = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();

        btnFinish.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFinish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybuilder/resources/ok3.png"))); // NOI18N
        btnFinish.setText("Close");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });

        rdConfused.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdConfused.setText("Confused");

        rdMad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdMad.setText("Mad");

        rdSad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdSad.setText("Sad");

        rdHappy.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdHappy.setText("Happy");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setText("How do you feel after reading the story?");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rdConfused)
                                .addComponent(rdSad)
                                .addComponent(rdHappy)
                                .addComponent(rdMad)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel1))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(rdHappy, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdSad, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdMad, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdConfused, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFinish)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed

        if (!_feedback.equals("")) {
            new UserStoryController().updateFeedback(this._storyID, Global.loggedInUser, _feedback);

            this.close();
        }
        else {
            JOptionPane.showMessageDialog(null, "Please select one of the options.");
        }
    }//GEN-LAST:event_btnFinishActionPerformed

    private void close() {
        JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(this);
        dialog.dispose();
        dialog.setVisible(false);

        if (Global.group.equals(UserGroup.Child)) {
            Global.container.setDisplay(new ChildHome());
        }
    }

    public void actionPerformed(ActionEvent e) {
        _feedback = e.getActionCommand();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinish;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton rdConfused;
    private javax.swing.JRadioButton rdHappy;
    private javax.swing.JRadioButton rdMad;
    private javax.swing.JRadioButton rdSad;
    // End of variables declaration//GEN-END:variables
}
