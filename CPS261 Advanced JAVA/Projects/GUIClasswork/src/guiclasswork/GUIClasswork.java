/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiclasswork;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;


/**
 *
 * @author Vraj
 */
public class GUIClasswork extends JFrame {

    /**
     * @param args the command line arguments
     */
    
    JLabel l1;
    JTextField t1;
    JButton b1;
    JTextArea tx;
    
    public GUIClasswork(){
        l1 = new JLabel("My First Example");
        t1 = new JTextField(40);
        b1 = new JButton("Click me!");
        tx = new JTextArea(4,10);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(l1);
        add(t1);
        add(b1);
        add(tx);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        GUIClasswork w = new GUIClasswork();
    }
    
}
