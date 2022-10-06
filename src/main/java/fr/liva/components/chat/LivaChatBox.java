package fr.liva.components.chat;

import javax.swing.*;
import java.awt.*;

public class LivaChatBox extends JTextArea {

    public LivaChatBox() {
        super(10, 10);
        setPreferredSize(new Dimension(100, 100));

        setBounds(740, 220, 270, 445);

        setEditable(false);

        setBackground(Color.decode("#7A7671"));
    }
}
