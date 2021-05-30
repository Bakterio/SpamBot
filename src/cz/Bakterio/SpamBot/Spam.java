package cz.Bakterio.SpamBot;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Spam {
    private static final JFrame frame = new JFrame("Spamovací program:");
    private static final JPanel panel = new JPanel();
    public static void spam(){ //V rámci učení se aj používám aj názvy pro proměné.
        Position();
        Center(frame);
        CotrolingStuff();
    }
    private static void Center(JFrame window){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
    }
    private static void Position(){
        frame.setSize(450, 150);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);
    }
    private static final JTextField text = new JTextField("Zde zadejte text");
    private static final JTextField count = new JTextField("počet");
    private static final JTextField seconds = new JTextField("interval");
    private static final JButton spaming = new JButton("SPAM!");
    private static void CotrolingStuff(){
        panel.add(text);
        panel.add(count);
        panel.add(spaming);
        panel.add(seconds);
        spaming.addActionListener(new ButtonSpam());
        spaming.setFont(new Font("Calibri", 0, 11));
        text.setBounds(10,10,350,100);
        count.setBounds(360 + 13,80-10,50,20);
        seconds.setBounds(360 + 13,100-10,50,20);
        spaming.setBounds(360 + 13-5-2,40-10,50+10+4,20+5+5+4);
    }
    private static String Text;
    private static int Count;
    private static int Seconds;
    private static void getInformations(){
        Text = text.getText();
        Count = Integer.parseInt(count.getText());
        Seconds = Integer.parseInt(seconds.getText());
    }
    public static void Spamming() throws AWTException, InterruptedException {
        getInformations();
        int x = 1;
        Robot r = new Robot();
        StringSelection string = new StringSelection(Text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(string,null);
        Thread.sleep(5000);
        do{
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);

            r.keyRelease(KeyEvent.VK_CONTROL);
            r.keyRelease(KeyEvent.VK_V);

            r.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(Seconds*1000);
            x++;
        } while (x <= Count);
    }
}
