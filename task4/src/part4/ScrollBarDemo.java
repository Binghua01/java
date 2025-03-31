package part4;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrollBarDemo extends JFrame {
    JLabel label = new JLabel("SCROLL BAR DEMO");
    int x;
    ScrollBarDemo() {
        setLayout(new BorderLayout());
        setBounds(400,400,300,200);
        setBackground(Color.WHITE);
        label.setFont(new Font("宋体",Font.ITALIC,24));
        add(label,BorderLayout.CENTER);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        x = getWidth();
        Timer timer = new Timer(10,new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x-=2;
                if (label.getX() + label.getWidth() < 0) {
                    x = getWidth(); // 如果滚出窗口，重置位置
                }
                label.setLocation(x,getHeight()/ - label.getHeight()/2);
            }
    });
        timer.start();
    }
    public static void main(String[] args) {
        ScrollBarDemo scrollbar = new ScrollBarDemo();
    }
}
