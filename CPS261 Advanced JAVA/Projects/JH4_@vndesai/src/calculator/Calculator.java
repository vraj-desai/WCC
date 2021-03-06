package calculator;

import static java.lang.Math.floor;

public class Calculator extends javax.swing.JApplet {
    String num1 = new String();
    String num2 = new String();
    boolean add = false;
    boolean sub = false;
    boolean multiply = false;
    boolean divide = false;
    Double result = 0.0;
    int int_result = 0;
    @Override
    public void init() {
        this.setSize(400,415);
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tf1 = new javax.swing.JTextField();
        B1 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        B3 = new javax.swing.JToggleButton();
        B0 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();
        subbtn = new javax.swing.JButton();
        mltplybtn = new javax.swing.JButton();
        dvdbtn = new javax.swing.JButton();
        eqlbtn = new javax.swing.JButton();
        clrbtn = new javax.swing.JButton();

        tf1.setEditable(false);
        tf1.setBackground(new java.awt.Color(255, 255, 0));

        B1.setBackground(new java.awt.Color(0, 255, 255));
        B1.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        B1.setText("1");
        B1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B1MouseClicked(evt);
            }
        });

        B2.setBackground(new java.awt.Color(0, 255, 255));
        B2.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        B2.setText("2");
        B2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B2MouseClicked(evt);
            }
        });

        B3.setBackground(new java.awt.Color(0, 255, 255));
        B3.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        B3.setSelected(true);
        B3.setText("3");
        B3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        B3.setVerifyInputWhenFocusTarget(false);
        B3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B3MouseClicked(evt);
            }
        });

        B0.setBackground(new java.awt.Color(0, 255, 255));
        B0.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        B0.setText("0");
        B0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B0MouseClicked(evt);
            }
        });

        B4.setBackground(new java.awt.Color(0, 255, 255));
        B4.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        B4.setText("4");
        B4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B4MouseClicked(evt);
            }
        });

        B5.setBackground(new java.awt.Color(0, 255, 255));
        B5.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        B5.setText("5");
        B5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                B5MouseClicked(evt);
            }
        });

        b6.setBackground(new java.awt.Color(0, 255, 255));
        b6.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        b6.setText("6");
        b6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b6MouseClicked(evt);
            }
        });

        b7.setBackground(new java.awt.Color(0, 255, 255));
        b7.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        b7.setText("7");
        b7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b7MouseClicked(evt);
            }
        });

        b8.setBackground(new java.awt.Color(0, 255, 255));
        b8.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        b8.setText("8");
        b8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b8MouseClicked(evt);
            }
        });

        b9.setBackground(new java.awt.Color(0, 255, 255));
        b9.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        b9.setText("9");
        b9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b9MouseClicked(evt);
            }
        });

        addbtn.setBackground(new java.awt.Color(255, 0, 0));
        addbtn.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        addbtn.setText("+");
        addbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbtnMouseClicked(evt);
            }
        });

        subbtn.setBackground(new java.awt.Color(255, 0, 0));
        subbtn.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        subbtn.setText("-");
        subbtn.setToolTipText("");
        subbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subbtnMouseClicked(evt);
            }
        });

        mltplybtn.setBackground(new java.awt.Color(255, 0, 0));
        mltplybtn.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        mltplybtn.setText("*");
        mltplybtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mltplybtnMouseClicked(evt);
            }
        });

        dvdbtn.setBackground(new java.awt.Color(255, 0, 0));
        dvdbtn.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        dvdbtn.setText("/");
        dvdbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dvdbtnMouseClicked(evt);
            }
        });

        eqlbtn.setBackground(new java.awt.Color(255, 0, 0));
        eqlbtn.setFont(new java.awt.Font("Serif", 1, 32)); // NOI18N
        eqlbtn.setText("=");
        eqlbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eqlbtnMouseClicked(evt);
            }
        });

        clrbtn.setBackground(new java.awt.Color(255, 0, 0));
        clrbtn.setFont(new java.awt.Font("Serif", 1, 28)); // NOI18N
        clrbtn.setText("clear");
        clrbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clrbtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tf1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mltplybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dvdbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(B0, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(eqlbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(clrbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B0, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(subbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clrbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mltplybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eqlbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dvdbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void B0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B0MouseClicked
        String b1 =tf1.getText();
        tf1.setText(b1 + "0");       
    }//GEN-LAST:event_B0MouseClicked

    private void B1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B1MouseClicked
        String b1 =tf1.getText();
        tf1.setText(b1 + "1");
    }//GEN-LAST:event_B1MouseClicked

    private void B2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B2MouseClicked
        String b1 =tf1.getText();
        tf1.setText(b1 + "2");                
    }//GEN-LAST:event_B2MouseClicked

    private void B3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B3MouseClicked
        String b1 =tf1.getText();
        tf1.setText(b1 + "3");
    }//GEN-LAST:event_B3MouseClicked

    private void B4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B4MouseClicked
        String b1 =tf1.getText();
        tf1.setText(b1 + "4");    
    }//GEN-LAST:event_B4MouseClicked

    private void B5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B5MouseClicked
        String b1 =tf1.getText();
        tf1.setText(b1 + "5");        
    }//GEN-LAST:event_B5MouseClicked

    private void b6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b6MouseClicked
        String b1 =tf1.getText();
        tf1.setText(b1 + "6");        
    }//GEN-LAST:event_b6MouseClicked

    private void b7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b7MouseClicked
        String b1 =tf1.getText();
        tf1.setText(b1 + "7");        
    }//GEN-LAST:event_b7MouseClicked

    private void b8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b8MouseClicked
        String b1 =tf1.getText();   
        tf1.setText(b1 + "8");             
    }//GEN-LAST:event_b8MouseClicked

    private void b9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b9MouseClicked
        String b1 =tf1.getText();
        tf1.setText(b1 + "9");        
    }//GEN-LAST:event_b9MouseClicked

    private void addbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbtnMouseClicked
        add = true;
        num1 = tf1.getText();
        tf1.setText("");        
    }//GEN-LAST:event_addbtnMouseClicked

    private void subbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subbtnMouseClicked
        sub = true;
        num1 = tf1.getText();
        tf1.setText("");        
    }//GEN-LAST:event_subbtnMouseClicked

    private void mltplybtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mltplybtnMouseClicked
        multiply = true;
        num1 = tf1.getText();
        tf1.setText("");       
    }//GEN-LAST:event_mltplybtnMouseClicked

    private void dvdbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dvdbtnMouseClicked
        divide = true;
        num1 = tf1.getText();
        tf1.setText("");        
    }//GEN-LAST:event_dvdbtnMouseClicked

    private void clrbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clrbtnMouseClicked
        num1 = "";
        num2 = "";
        result = 0.0;
        tf1.setText("");
    }//GEN-LAST:event_clrbtnMouseClicked

    private void eqlbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eqlbtnMouseClicked
        num2 = tf1.getText();
        if(add == true)
        {
          result =  Double.parseDouble(num1) + Double.parseDouble(num2);
          if(floor(result) == result)
          {
              int_result = result.intValue();
              tf1.setText(Integer.toString(int_result));
          }
          else
          {
            tf1.setText(Double.toString(result));
          }
          num1 = "";
          num2 = "";
          result = 0.0;
          add = false;
        }
        if(sub == true)
        {  
          num2 = tf1.getText();
          result =  Double.parseDouble(num1) - Double.parseDouble(num2);
          if(floor(result) == result)
          {
              int_result = result.intValue();
              tf1.setText(Integer.toString(int_result));
          }
          else
          {
            tf1.setText(Double.toString(result));
          }
          num1 = "";
          num2 = "";
          result = 0.0;
          sub = false;
           }
        if(multiply == true)
        {
          num2 = tf1.getText();
          result =  Double.parseDouble(num1) * Double.parseDouble(num2);
          if(floor(result) == result)
          {
              int_result = result.intValue();
              tf1.setText(Integer.toString(int_result));
          }
          else
          {
            tf1.setText(Double.toString(result));
          }num1 = "";
          num2 = "";
          result = 0.0;
          multiply = false;
        }
        if(divide == true)
        {
          num2 = tf1.getText();
          if(Integer.parseInt(num2) == 0)
          {
              tf1.setText("Cannot Divide by zero enter a different value");
          }
          else
          {
          result =  Double.parseDouble(num1) / Double.parseDouble(num2);
          if(floor(result) == result)
          {
              int_result = result.intValue();
              tf1.setText(Integer.toString(int_result));
          }
          else
          {
            tf1.setText(Double.toString(result));
          }
          num1 = "";
          num2 = "";
          result = 0.0;
          divide = false;
          }
        }
    }//GEN-LAST:event_eqlbtnMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B0;
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JToggleButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton addbtn;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton clrbtn;
    private javax.swing.JButton dvdbtn;
    private javax.swing.JButton eqlbtn;
    private javax.swing.JButton mltplybtn;
    private javax.swing.JButton subbtn;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
