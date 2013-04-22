/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.uoy.sb.Global;
import com.uoy.sb.ImageFilter;
import com.uoy.sb.SoundFilter;
import controller.StoryController;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import model.Page;
import model.Story;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Y0239881
 */
public class CreatePage extends javax.swing.JPanel {

    private Page _page;
    private int _pageIndex = -1;
    private CreateStory _parent = null;

    /**
     * @return the _parent
     */
    public CreateStory getParentPanel() {
        return _parent;
    }

    /**
     * @param parentPanel the _parent to set
     */
    public void setParentPanel(CreateStory parent) {
        this._parent = parent;
    }

    /**
     * @return the _page
     */
    public Page getPage() {
        return _page;
    }

    /**
     * @param _page the _page to set
     */
    public void setPage(Page currentPage) {
        this._page = currentPage;

        if (currentPage != null) {
            List<String> images = currentPage.getImages();
            if (images != null && !images.isEmpty()) {
                if (images.size() == 1) {
                    txtImage1.setText(images.get(0));
                }
                if (images.size() == 2) {
                    txtImage1.setText(images.get(0));
                    txtImage2.setText(images.get(1));
                }
            }

            txtContent.setText(currentPage.getText());
            txtSound.setText(currentPage.getSound());
        }
    }

    /**
     * @return the _pageIndex
     */
    public int getPageIndex() {
        return _pageIndex;
    }

    /**
     * @param pageIndex the _pageIndex to set
     */
    public void setPageIndex(int pageIndex) {
        this._pageIndex = pageIndex;
    }

    /**
     * Creates new form CreatePage
     */
    public CreatePage() {
        initComponents();
    }

    /*
     * Create a new page or update an existing page
     */
    private boolean savePage() {
        if (txtContent.getText().equals("")) {
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "Please enter the page content");
            return false;
        }

        Page page = new Page();
//        page.setBackgroundImage(txtImage1.getText());

        if (!txtImage1.getText().equals("")) {
            page.addImage(txtImage1.getText());
        }
        if (!txtImage2.getText().equals("")) {
            page.addImage(txtImage2.getText());
        }

        page.setSound(txtSound.getText());
        page.setText(txtContent.getText());

        if (getParentPanel() == null) {
            JOptionPane.showMessageDialog(null, "null");
        }

        if (this.getPageIndex() == -1) {
            getParentPanel().addPage(page);
        } else {
            getParentPanel().updatePage(this.getPageIndex(), page);
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnSelectImage = new javax.swing.JButton();
        txtImage1 = new javax.swing.JTextField();
        txtSound = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSelectSound = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        btnCancel = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        btnSaveNCreate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtImage2 = new javax.swing.JTextField();
        btnSelectImage1 = new javax.swing.JButton();

        jLabel3.setText("Sound:");

        btnSelectImage.setText("Select Image");
        btnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImageActionPerformed(evt);
            }
        });

        jLabel1.setText("Page Content:");

        btnSelectSound.setText("Select sound");
        btnSelectSound.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectSoundActionPerformed(evt);
            }
        });

        jLabel2.setText("Image 1:");

        txtContent.setColumns(20);
        txtContent.setRows(5);
        jScrollPane1.setViewportView(txtContent);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnPlay.setText("Play");
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });

        btnSaveNCreate.setText("Save & Create new");
        btnSaveNCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveNCreateActionPerformed(evt);
            }
        });

        btnSave.setText("Save & Close");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel4.setText("Image 2:");

        btnSelectImage1.setText("Select Image");
        btnSelectImage1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImage1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel3)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel4))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(layout.createSequentialGroup()
                                    .add(txtImage1)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(btnSelectImage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(2, 2, 2))
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 494, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(txtImage2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 380, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btnSelectImage1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 24, Short.MAX_VALUE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(0, 0, Short.MAX_VALUE)
                                .add(btnSaveNCreate)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(btnSave)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(btnCancel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 69, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(txtSound)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(btnPlay)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(btnSelectSound, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 107, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(17, 17, 17)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(txtImage1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(jLabel2))
                            .add(btnSelectImage))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(txtImage2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnSelectImage1)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.CENTER)
                            .add(txtSound, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(btnPlay)
                            .add(btnSelectSound)
                            .add(jLabel3))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(btnSave)
                            .add(btnSaveNCreate)
                            .add(btnCancel)))
                    .add(layout.createSequentialGroup()
                        .add(jLabel1)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.close();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImageActionPerformed
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new ImageFilter());
        fc.setAcceptAllFileFilterUsed(false);

        //In response to a button click:
        int returnVal = fc.showOpenDialog(CreatePage.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            txtImage1.setText(file.getAbsolutePath());
        } else {
//            log.append("Open command cancelled by user." + newline);
        }
    }//GEN-LAST:event_btnSelectImageActionPerformed

    private void btnSelectSoundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectSoundActionPerformed
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new SoundFilter());
        fc.setAcceptAllFileFilterUsed(false);

        //In response to a button click:
        int returnVal = fc.showOpenDialog(CreatePage.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            txtSound.setText(file.getAbsolutePath());
        } else {
//            log.append("Open command cancelled by user." + newline);
        }
    }//GEN-LAST:event_btnSelectSoundActionPerformed

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if (!txtSound.getText().equals("")) {
            AudioInputStream audio;
            try {
                audio = AudioSystem.getAudioInputStream(new File(txtSound.getText()));

                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            } catch (IOException ex) {
                Logger.getLogger(CreatePage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(CreatePage.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(CreatePage.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (savePage()) {
            this.close();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveNCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveNCreateActionPerformed
        if (savePage()) {
            txtImage1.setText("");
            txtContent.setText("");
            txtSound.setText("");
        }
    }//GEN-LAST:event_btnSaveNCreateActionPerformed

    private void btnSelectImage1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImage1ActionPerformed
        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new ImageFilter());
        fc.setAcceptAllFileFilterUsed(false);

        //In response to a button click:
        int returnVal = fc.showOpenDialog(CreatePage.this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            txtImage2.setText(file.getAbsolutePath());
        } else {
//            log.append("Open command cancelled by user." + newline);
        }
    }//GEN-LAST:event_btnSelectImage1ActionPerformed

    private void close() {
        JDialog dialog = (JDialog) SwingUtilities.getWindowAncestor(this);
        dialog.dispose();
        dialog.setVisible(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveNCreate;
    private javax.swing.JButton btnSelectImage;
    private javax.swing.JButton btnSelectImage1;
    private javax.swing.JButton btnSelectSound;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtContent;
    private javax.swing.JTextField txtImage1;
    private javax.swing.JTextField txtImage2;
    private javax.swing.JTextField txtSound;
    // End of variables declaration//GEN-END:variables
}
