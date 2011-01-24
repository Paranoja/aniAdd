/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI_Help.java
 *
 * Created on 29.06.2009, 21:05:33
 */

package gui;

import aniAdd.Communication.ComEvent;
import aniAdd.IAniAdd;
import aniAdd.misc.Mod_Memory;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import javax.swing.JOptionPane;
import processing.Mod_EpProcessing;

/**
 *
 * @author Arokh
 */
public class GUI_Help extends javax.swing.JPanel implements GUI.ITab {
    Mod_Memory mem;

    /** Creates new form GUI_Help */
    public GUI_Help() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_Icons = new javax.swing.JLabel();
        ctrl_IconHelp = new gui.GUI_Help_Icons();
        btn_ResetSettings = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        lbl_Icons.setFont(new java.awt.Font("Tahoma", 1, 14));
        lbl_Icons.setText("Icons:");

        btn_ResetSettings.setText("Reset Settings to Default");

        jLabel1.setText("Current Build: 24.01.11");

        jLabel2.setText("Use the DEL Key to remove selected files from the file table");

        jLabel3.setText("<html><a href=\"http://wiki.anidb.net/w/User_talk:Dvdkhl\">TagSystem definition & help</a></html>");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_TagSystemHelp_Click(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_Icons)
                        .addComponent(ctrl_IconHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_ResetSettings)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addComponent(jLabel2))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_Icons)
                .addGap(2, 2, 2)
                .addComponent(ctrl_IconHelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ResetSettings)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_TagSystemHelp_Click(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_TagSystemHelp_Click
        try {
            Desktop.getDesktop().browse(new URI("http://wiki.anidb.net/w/User_talk:Dvdkhl"));
        } catch (Exception ex) {}
    }//GEN-LAST:event_lbl_TagSystemHelp_Click


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ResetSettings;
    protected gui.GUI_Help_Icons ctrl_IconHelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    protected javax.swing.JLabel lbl_Icons;
    // End of variables declaration//GEN-END:variables

    public String TabName() { return "Help"; }
    public int PreferredTabLocation() { return 3; }

    public void Initialize(final IAniAdd aniAdd, final IGUI gui) {
        mem = (Mod_Memory)aniAdd.GetModule("Memory");

        btn_ResetSettings.addActionListener(new ActionListener() {
            Mod_EpProcessing epProc = (Mod_EpProcessing)aniAdd.GetModule("EpProcessing");

            public void actionPerformed(ActionEvent e) {
                if(epProc.isProcessing()){
                    JOptionPane.showMessageDialog(null, "Cannot reset settings while files are being processed", "Resetting Settings", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                
                if(JOptionPane.showConfirmDialog(null, "Reset all settings?", "Resetting Settings", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                    mem.clear();
                }
            }
        });
    }

    public void Terminate() {}

    public void GUIEventHandler(ComEvent comEvent) {}

    public void GainedFocus() {}

    public void LostFocus() {}

}
