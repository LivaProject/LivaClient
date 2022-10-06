package fr.liva.components.others;

import javax.swing.*;
import java.awt.*;

public class LivaText extends JLabel {

    public LivaText(int size) {
        setFont(new Font("Serif", Font.PLAIN, size));
        setForeground(Color.LIGHT_GRAY);

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    public LivaText() {
        this(48);
    }

    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y - 5, width, height);
    }
}
