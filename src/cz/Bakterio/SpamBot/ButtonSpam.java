package cz.Bakterio.SpamBot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSpam implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Spam.Spamming();
        } catch (AWTException awtException) {
            awtException.printStackTrace();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }
}
