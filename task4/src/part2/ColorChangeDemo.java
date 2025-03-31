package part2;
//使用两个布局主面板和滑动条面板
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;

//使用的监听类
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

//需要用到的相关组件
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JLabel;
/*构造方法
new JSlider(0, 255, 0) 来创建滑块，并指定最小值、最大值和初始值。
addChangeListener(ChangeListener l)
为滑块添加数值变化的监听器，从而在滑块值改变时触发事件。
getValue()
在事件处理方法中调用该方法获取滑块当前的值，进而构造新的颜色。
另外，如果需要在界面上显示刻度和标签，可以选用以下辅助方法：
setMajorTickSpacing(int spacing)
setMinorTickSpacing(int spacing)
setPaintTicks(boolean flag)
setPaintLabels(boolean flag)
这四个方法用于设置滑块上的刻度和标签
*/
public class ColorChangeDemo extends JFrame
{
    public ColorChangeDemo()
    {
        setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        JLabel label = new JLabel("Color Change Demo");
        label.setHorizontalAlignment(JLabel.CENTER);
        panel1.add(label,BorderLayout.CENTER);
        panel1.setBackground(Color.WHITE);
        add(panel1);
        
        JSlider redbar = new JSlider(0,255,255);
        JSlider greenbar = new JSlider(0,255,255);
        JSlider bluebar = new JSlider(0,255,255);

        ChangeListener slidelistener = new ChangeListener() {
            public void stateChanged(ChangeEvent e)
            {
                int red = redbar.getValue();
                int green = greenbar.getValue();
                int blue = bluebar.getValue();
                panel1.setBackground(new Color(red,green,blue));
            }
        };
        
        redbar.setPaintTicks(true);
        redbar.setMajorTickSpacing(50);
        redbar.addChangeListener(slidelistener);
        redbar.setPaintLabels(true);
        greenbar.setPaintTicks(true);
        greenbar.setMajorTickSpacing(50);
        greenbar.addChangeListener(slidelistener);
        greenbar.setPaintLabels(true);
        bluebar.setPaintTicks(true);
        bluebar.setMajorTickSpacing(50);
        bluebar.addChangeListener(slidelistener);
        bluebar.setPaintLabels(true);
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(3,2));
        JLabel label1 = new JLabel("RED");
        JLabel label2 = new JLabel("GREEN");
        JLabel label3 = new JLabel("BLUE");
        panel2.add(label1);
        panel2.add(redbar);
        panel2.add(label2);
        panel2.add(greenbar);
        panel2.add(label3);
        panel2.add(bluebar);
        add(panel2,BorderLayout.SOUTH);
        setBounds(400,400,300,225);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        ColorChangeDemo demo = new ColorChangeDemo();
    }
}