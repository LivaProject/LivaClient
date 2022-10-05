package fr.liva.components.others;

import javax.swing.*;
import java.awt.*;

public class LivaText extends JLabel {

    public LivaText() {
        setFont(new Font("Serif", Font.PLAIN, 48));
        setForeground(Color.LIGHT_GRAY);

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y - 5, width, height);
    }
}
