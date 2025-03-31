package part1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.BorderLayout;
/*
 * 【1】	编写程序，使用BorderLayout的布局策略在五个位置分别加入四个按钮和一个标签，
 *          当点击按钮时，标签的文本就是按钮的标签的文本。
 */
public class BorderLayoutDemo {
    BorderLayoutDemo(){
        JFrame frame = new JFrame("Title");
        frame.setBounds(400,400,400,300);
        frame.setBackground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        JLabel label = new JLabel("Label");
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label,BorderLayout.CENTER);
        JButton button1 = new JButton("NORTH");
        JButton button2 = new JButton("SOUTH");
        JButton button3 = new JButton("EAST");
        JButton button4 = new JButton("WEST");
        ActionListener buttonListener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton)e.getSource();
                label.setText(button.getText());
            }
        };
        button1.addActionListener(buttonListener);
        button2.addActionListener(buttonListener);
        button3.addActionListener(buttonListener);
        button4.addActionListener(buttonListener);
        frame.add(button1,BorderLayout.NORTH);
        frame.add(button2,BorderLayout.SOUTH);
        frame.add(button3,BorderLayout.EAST);
        frame.add(button4,BorderLayout.WEST);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        BorderLayoutDemo demo = new BorderLayoutDemo();
    }
}
