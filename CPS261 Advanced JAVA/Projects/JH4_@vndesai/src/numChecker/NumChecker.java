package numChecker;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class NumChecker extends JFrame {
    int slider_Value = 0;
    boolean slider_visibility = true;
    boolean vertical_slider = false;
    public NumChecker() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        s1 = new javax.swing.JSlider();
        b1 = new javax.swing.JToggleButton();
        tf2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        file_exit = new javax.swing.JMenuItem();
        color = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        slider = new javax.swing.JMenu();
        hide_Menu = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        s1.setMajorTickSpacing(10);
        s1.setMinorTickSpacing(10);
        s1.setPaintLabels(true);
        s1.setPaintTicks(true);
        s1.setValue(10);

        b1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        b1.setText("Check Number");
        b1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b1MouseClicked(evt);
            }
        });

        tf2.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("Result");

        file.setText("File");

        file_exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK));
        file_exit.setText("Exit");
        file_exit.setToolTipText("");
        file_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_exitActionPerformed(evt);
            }
        });
        file.add(file_exit);

        jMenuBar1.add(file);

        color.setText("Color");

        jMenu1.setText("ForeGround");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Red");
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Blue");
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Green");
        jMenu1.add(jMenuItem3);

        color.add(jMenu1);

        jMenu2.setText("BackGround");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText("ColorChooser");
        jMenu2.add(jMenuItem4);

        color.add(jMenu2);

        jMenuBar1.add(color);

        slider.setText("Slider");

        hide_Menu.setText("Hide");
        hide_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hide_MenuActionPerformed(evt);
            }
        });
        slider.add(hide_Menu);

        jCheckBoxMenuItem1.setText("Vertical");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        slider.add(jCheckBoxMenuItem1);

        jMenuBar1.add(slider);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(s1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b1)
                    .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(b1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(248, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void file_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_file_exitActionPerformed

    private void b1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b1MouseClicked
        slider_Value = s1.getValue();
        if(slider_Value % 2 == 0)
        {
            tf2.setText("The number is even. ");
        }
        else
        {
            tf2.setText("The number is odd. ");
        }
    }//GEN-LAST:event_b1MouseClicked

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        if(vertical_slider == false)
        {   if(slider_visibility == false)
            { 
                s1.setVisible(true);
                    slider_visibility = true;
            }
            s1.setOrientation(JSlider.VERTICAL);
            vertical_slider = true;
        }
        else if(vertical_slider == true)
        {   if(slider_visibility == false)
            { 
                s1.setVisible(true);
                    slider_visibility = true;
            }
            s1.setOrientation(JSlider.HORIZONTAL);
            vertical_slider = false;
        }
        
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void hide_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hide_MenuActionPerformed
        if(slider_visibility == true)
        {
            s1.setVisible(false);
            slider_visibility = false;
        }
        else
        {
            s1.setVisible(true);
            slider_visibility = true;
        }

    }//GEN-LAST:event_hide_MenuActionPerformed
    
    
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NumChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NumChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NumChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NumChecker.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NumChecker().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton b1;
    private javax.swing.JMenu color;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem file_exit;
    private javax.swing.JCheckBoxMenuItem hide_Menu;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    public javax.swing.JSlider s1;
    private javax.swing.JMenu slider;
    private javax.swing.JTextField tf2;
    // End of variables declaration//GEN-END:variables
}
