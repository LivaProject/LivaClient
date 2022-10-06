package fr.liva.components.chat;

import javax.swing.*;
import java.awt.*;

public class LivaChatBox extends JTextArea {

    public LivaChatBox() {
        super(10, 10);

        setEditable(false);

        setBackground(Color.decode("#7A7671"));
    }
}
