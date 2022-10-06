package fr.liva.components.input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LivaInputField extends JTextField {

    private String placeHolder;

    public LivaInputField() {
        this(null);
    }

    public LivaInputField(String placeHolder) {
        this.placeHolder = placeHolder;

        setBackground(Color.decode("#99948E"));

        if (placeHolder != null) {
            setText(placeHolder);
            addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (getText().equals(placeHolder)) {
                        setText("");
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (getText().isEmpty()) {
                        setText(placeHolder);
                    }
                }
            });
        }
    }
}
