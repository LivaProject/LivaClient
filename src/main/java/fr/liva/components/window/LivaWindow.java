package fr.liva.components.window;

import fr.liva.Main;
import fr.liva.utils.LivaUtils;

import javax.swing.*;
import java.awt.*;

public class LivaWindow extends JScrollPane {

    private final Image background = LivaUtils.getResource("images/window.png");

    public LivaWindow() {

        // Background
        setBounds(Main.WIDTH / 2 - 600 / 2, Main.HEIGHT / 2 - 400 / 2, 600, 400);
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);
        setBorder(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        LivaUtils.drawFullsizedImage(g, this, background);

        repaint();
    }
}
