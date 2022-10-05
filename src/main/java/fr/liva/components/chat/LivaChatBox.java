package fr.liva.components.chat;

import javax.swing.*;
import java.awt.*;

public class LivaChatBox extends JTextArea {

    public LivaChatBox() {
        setBounds(740, 220, 270, 445);

        setEditable(false);

        setBackground(Color.decode("#7A7671"));
    }
}
