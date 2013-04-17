/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.uoy.sb.ColorListCellRenderer;
import com.uoy.sb.Global;
import controller.StoryController;
import controller.UserController;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import model.Page;
import model.Story;

import model.User;

/**
 *
 * @author Y0199223
 */
public class CreateStory extends javax.swing.JPanel {

    private StoryController sc = null;
    private int _storyID = 0;
    private DefaultListModel model;
    private LinkedList<Page> _pages;
    private Story story = null;

    /**
     * Creates new form CreateStory
     */
    public CreateStory() {
        initComponents();
        init();
    }

    /**
     * Creates new form CreateStory and display the content of a particular
     * story
     */
    public CreateStory(int StoryID) {
        initComponents();
        init();

        this.setStoryID(StoryID);

        sc = new StoryController();
        _pages = new LinkedList<>();

        // load story data
        story = sc.getStory(getStoryID());

        if (story != null) {
            model = new DefaultListModel();
            txtTitle.setText(story.getTitle());
            _pages = story.getPages();

            for (Page p : getPages()) {
                model.addElement(p.getText());
            }

            pageList.setModel(model);
        }
    }

    private void init() {
        _pages = new LinkedList<>();
        pageList.addMouseListener(new PageListMouseListener());

        DefaultComboBoxModel fontSize = new DefaultComboBoxModel();
        for (int i = 10; i < 32; i++) {
            fontSize.addElement(i);
        }

        jcbFontSize.setModel(fontSize);

        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = e.getAvailableFontFamilyNames(); // Get the fonts
        jcbFonts.setModel(new DefaultComboBoxModel(fonts));

        UserController uc = new UserController();
        LinkedList<User> children = uc.getAllChildren();

        DefaultListModel childrenModel = new DefaultListModel();
        for (User u : children) {
            childrenModel.addElement(u.getName());
        }

        lstChildren.setModel(childrenModel);

        String[] colors = {"RED", "CYAN", "BLUE", "GREEN", "YELLOW", "DARK_GRAY", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "WHITE", "BLACK"};
        jcbTextColor.setRenderer(new ColorListCellRenderer());
        jcbTextColor.setModel(new DefaultComboBoxModel<>(colors));
        jcbTextColor.setSelectedIndex(colors.length - 1);

        jcbBgColor.setRenderer(new ColorListCellRenderer());
        jcbBgColor.setModel(new DefaultComboBoxModel<>(colors));
        jcbBgColor.setSelectedIndex(colors.length - 2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pagePanel = new javax.swing.JPanel();
        deletePage = new javax.swing.JButton();
        newPage = new javax.swing.JButton();
        editPage = new javax.swing.JButton();
        pageListScrollPane = new javax.swing.JScrollPane();
        pageList = new javax.swing.JList();
        pagesLabel = new javax.swing.JLabel();
        colorPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcbFonts = new javax.swing.JComboBox();
        jcbFontSize = new javax.swing.JComboBox();
        jcbTextColor = new javax.swing.JComboBox();
        jcbBgColor = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        assignstoryPanel = new javax.swing.JPanel();
        AssignStory = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstChildren = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        saveStory = new javax.swing.JButton();
        feedback = new javax.swing.JCheckBox();
        cancel = new javax.swing.JButton();
        storyNamePanel = new javax.swing.JPanel();
        txtTitle = new javax.swing.JTextField();
        storyTitleLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(650, 650));

        deletePage.setText("Delete Page");
        deletePage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePageActionPerformed(evt);
            }
        });

        newPage.setText("New Page");
        newPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPageActionPerformed(evt);
            }
        });

        editPage.setText("Edit Page");
        editPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPageActionPerformed(evt);
            }
        });

        pageList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        pageListScrollPane.setViewportView(pageList);

        pagesLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pagesLabel.setText("Pages:");

        javax.swing.GroupLayout pagePanelLayout = new javax.swing.GroupLayout(pagePanel);
        pagePanel.setLayout(pagePanelLayout);
        pagePanelLayout.setHorizontalGroup(
            pagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pagesLabel)
                .addGap(43, 43, 43)
                .addComponent(pageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(newPage)
                        .addComponent(deletePage, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(editPage))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pagePanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deletePage, editPage, newPage});

        pagePanelLayout.setVerticalGroup(
            pagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pagePanelLayout.createSequentialGroup()
                        .addComponent(newPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deletePage))
                    .addComponent(pagesLabel)
                    .addComponent(pageListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Choose Font:");

        jLabel2.setText("Choose Font Size:");

        jcbTextColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jcbBgColor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Text color:");

        jLabel5.setText("Background color:");

        javax.swing.GroupLayout colorPanelLayout = new javax.swing.GroupLayout(colorPanel);
        colorPanel.setLayout(colorPanelLayout);
        colorPanelLayout.setHorizontalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, colorPanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jcbBgColor, 0, 91, Short.MAX_VALUE)
                    .addComponent(jcbTextColor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbFontSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(colorPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jcbFonts, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        colorPanelLayout.setVerticalGroup(
            colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbTextColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jcbFonts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(colorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbBgColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jcbFontSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        AssignStory.setText("Assign this story to: ");

        lstChildren.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstChildren.setToolTipText("");
        jScrollPane1.setViewportView(lstChildren);

        jLabel3.setText("Tip: Press and hold Control key for multiple selection");

        javax.swing.GroupLayout assignstoryPanelLayout = new javax.swing.GroupLayout(assignstoryPanel);
        assignstoryPanel.setLayout(assignstoryPanelLayout);
        assignstoryPanelLayout.setHorizontalGroup(
            assignstoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assignstoryPanelLayout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(assignstoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(assignstoryPanelLayout.createSequentialGroup()
                        .addGroup(assignstoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AssignStory)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 90, Short.MAX_VALUE)))
                .addContainerGap())
        );
        assignstoryPanelLayout.setVerticalGroup(
            assignstoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(assignstoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AssignStory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        saveStory.setText("Save Story");
        saveStory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveStoryActionPerformed(evt);
            }
        });

        feedback.setText("Ask for feedback?");

        cancel.setText("Cancel");

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(feedback, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveStory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addGap(22, 22, 22))
        );

        buttonPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancel, saveStory});

        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(saveStory)
                        .addComponent(cancel))
                    .addComponent(feedback, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        storyTitleLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        storyTitleLabel.setText("Story Title:");

        javax.swing.GroupLayout storyNamePanelLayout = new javax.swing.GroupLayout(storyNamePanel);
        storyNamePanel.setLayout(storyNamePanelLayout);
        storyNamePanelLayout.setHorizontalGroup(
            storyNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storyNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(storyTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        storyNamePanelLayout.setVerticalGroup(
            storyNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(storyNamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(storyNamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storyTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(assignstoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storyNamePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pagePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {assignstoryPanel, storyNamePanel});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(storyNamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(assignstoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPageActionPerformed
        CreatePage page = new CreatePage();
        page.setParentPanel(this);
        Global.container.showModalDialog(page, "Create new page");
    }//GEN-LAST:event_newPageActionPerformed

    private void editPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPageActionPerformed
        if (pageList.getSelectedIndex() >= 0) {
            CreatePage page = new CreatePage();
            page.setStoryID(getStoryID());
            page.setCurrentPage(this.getPages().get(pageList.getSelectedIndex()));

            Global.container.showModalDialog(page, "Edit page");
        } else {
            JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "Please select a page to edit");
        }
    }//GEN-LAST:event_editPageActionPerformed

    private void deletePageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePageActionPerformed
        DefaultListModel dataModel = new DefaultListModel();
        int selectedIndex = pageList.getSelectedIndex();

        if (pageList.getSelectedIndex() >= 0) {
            dataModel = (DefaultListModel) pageList.getModel();
            dataModel.remove(selectedIndex);

            _pages.remove(selectedIndex);
        }
    }//GEN-LAST:event_deletePageActionPerformed

    private void saveStoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveStoryActionPerformed
        sc = new StoryController();

        if (!txtTitle.getText().equals("")) {
            // new story
            if (getStoryID() == 0) {
                Story story = new Story();
                story.setTitle(txtTitle.getText());
                story.setPages(this.getPages());
                story.setFont(jcbFonts.getSelectedItem().toString());
                story.setFontSize(Integer.parseInt(jcbFontSize.getSelectedItem().toString()));
                story.setTextColor(jcbTextColor.getSelectedItem().toString());
                story.setBackgroundColor(jcbBgColor.getSelectedItem().toString());
                story.setCreatedBy(Global.loggedInUser);

                // insert into database
                sc.createNewStory(story);

            } // update story
            else {
                story.setTitle(txtTitle.getText());
                story.setPages(getPages());
                story.setFont(jcbFonts.getSelectedItem().toString());
                story.setFontSize(Integer.parseInt(jcbFontSize.getSelectedItem().toString()));
                story.setTextColor(jcbTextColor.getSelectedItem().toString());
                story.setBackgroundColor(jcbBgColor.getSelectedItem().toString());

                // update
                sc.updateStory(story);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter the story title!");
        }
    }//GEN-LAST:event_saveStoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AssignStory;
    private javax.swing.JPanel assignstoryPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton cancel;
    private javax.swing.JPanel colorPanel;
    private javax.swing.JButton deletePage;
    private javax.swing.JButton editPage;
    private javax.swing.JCheckBox feedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbBgColor;
    private javax.swing.JComboBox jcbFontSize;
    private javax.swing.JComboBox jcbFonts;
    private javax.swing.JComboBox jcbTextColor;
    private javax.swing.JList lstChildren;
    private javax.swing.JButton newPage;
    private javax.swing.JList pageList;
    private javax.swing.JScrollPane pageListScrollPane;
    private javax.swing.JPanel pagePanel;
    private javax.swing.JLabel pagesLabel;
    private javax.swing.JButton saveStory;
    private javax.swing.JPanel storyNamePanel;
    private javax.swing.JLabel storyTitleLabel;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the _pages
     */
    public LinkedList<Page> getPages() {
        return _pages;
    }

    /*
     * Add a new page to the current pages list of the story
     */
    public void addPage(Page page) {
        this._pages.add(page);

        if (model == null) {
            model = new DefaultListModel();
        }

        pageList.removeAll();

        for (Page p : getPages()) {
            model.addElement(p.getText());
        }

        pageList.setModel(model);
    }

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

    class PageListMouseListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            JList list = (JList) e.getSource();

            // double click
            if (e.getClickCount() == 2) {
                int selectedIndex = list.getSelectedIndex();

                CreatePage page = new CreatePage();
                page.setStoryID(getStoryID());
                page.setCurrentPage(getPages().get(pageList.getSelectedIndex()));

                Global.container.showModalDialog(page, "Edit page");
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
}
