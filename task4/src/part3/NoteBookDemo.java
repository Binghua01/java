package part3;
//容器
import javax.swing.JFrame;
//布局
import java.awt.BorderLayout;
import java.awt.ScrollPane;
//颜色
import java.awt.Color;
//组件
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
//监听
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//输入输出流
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class NoteBookDemo extends JFrame
{
    //文本框
    public JTextArea textarea;

    public NoteBookDemo() {
        setLayout(new BorderLayout());
        //-------------------添加组件---------------------------
        //菜单栏
        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("Check");
        //文本框
        textarea = new JTextArea(10,20);
        textarea.setBackground(new Color(140,190,240));
        ScrollPane scrollpane = new ScrollPane();
        scrollpane.add(textarea);
        scrollpane.setVisible(true);
        add(scrollpane,BorderLayout.CENTER);
        //菜单项目
        JMenuItem m1_item1 = new JMenuItem("new");
        m1_item1.addActionListener(newlistener);
        JMenuItem m1_item2 = new JMenuItem("open");
        m1_item2.addActionListener(openlistener);
        JMenuItem m1_item3 = new JMenuItem("store");
        m1_item3.addActionListener(storelistener);
        JMenuItem m1_item4 = new JMenuItem("exit");
        m1_item4.addActionListener(exitlistener);
        menu1.add(m1_item1);
        menu1.add(m1_item2);
        menu1.add(m1_item3);
        menu1.add(m1_item4);
        menubar.add(menu1);
        menubar.add(menu2);
        menubar.add(menu3);
        setJMenuBar(menubar);

        setBounds(400,400,400,200);
        //pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    //新建
    ActionListener newlistener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            textarea.setText("");
        }
    };
    //打开文件
    ActionListener openlistener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JFileChooser filechooser = new JFileChooser();
            int returnvalue = filechooser.showOpenDialog(null);
            if(returnvalue != JFileChooser.CANCEL_OPTION) {
                File file = filechooser.getSelectedFile();
                try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    while( (line = reader.readLine() ) !=null) {
                        //line.append("\0");
                        line  = line + "\n";
                        textarea.append(line);
                    }
                } catch(IOException ioexception) { }
            }
        }
    };
    //保存文件
    ActionListener storelistener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            JFileChooser filechooser = new JFileChooser(); 
            int returnvalue = filechooser.showSaveDialog(null);
            if(returnvalue == JFileChooser.APPROVE_OPTION) {
                File file = filechooser.getSelectedFile(); 
                try(BufferedWriter bufferedwriter = new BufferedWriter(new FileWriter(file))) {
                    bufferedwriter.write(textarea.getText());
                }catch(IOException ioexception) {

                }
            }
        }
    };
    //退出程序
    ActionListener exitlistener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };
    public static void main(String[] args)
    {
        NoteBookDemo notebook = new NoteBookDemo();
    }
}