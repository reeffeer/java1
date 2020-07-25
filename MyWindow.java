import com.sun.security.ntlm.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    JButton exitButton = new JButton("Click on me");


    public  MyWindow() {
        setBounds(500,500,400,300);
        setTitle("Don't do it!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        add(exitButton);
        setSize(300, 300);
        exitButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        setVisible(true);
    }


}
