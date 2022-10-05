package fr.liva.components.others;

import javax.swing.*;
import java.awt.*;

public class LivaTitleText extends JLabel {

    public LivaTitleText() {
        setFont(new Font("Serif", Font.PLAIN, 96));
        setBounds(90, 50, 900, 115);
        setForeground(Color.LIGHT_GRAY);

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

}
