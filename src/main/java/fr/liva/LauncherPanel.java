package fr.liva;

import fr.liva.buttons.LivaActionType;
import fr.liva.buttons.LivaButton;
import fr.liva.buttons.LivaToggleButton;
import fr.liva.utils.LivaUtils;

import javax.swing.*;
import java.awt.*;

public class LauncherPanel extends JPanel {

    // Images
    private Image background = LivaUtils.getResource("images/background.png");

    // Buttons
    private LivaButton play = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/play_button_hover.png"));
    private LivaButton options = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));
    private LivaButton quit = new LivaButton(LivaUtils.getResource("buttons/button.png"), LivaUtils.getResource("buttons/button_hover.png"));

    private LivaButton debug = new LivaToggleButton(LivaUtils.getResource("buttons/button_toggled_false.png"), LivaUtils.getResource("buttons/button_toggled_true.png"));

    public LauncherPanel() {
        // Background
        setBackground(new Color(0, 0, 0, 0));
        setLayout(null);

        // Buttons
        play.setBounds(100, 370, 550, 90);

        options.setBounds(100, 490, 550, 90);

        quit.setBounds(100, 610, 550, 90);
        quit.setAction(LivaActionType.PRESS, () -> {
            System.exit(0);
        });

        debug.setBounds(100, 260,80, 80);

        // Add Elements
        add(play);
        add(options);
        add(quit);
        add(debug);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        LivaUtils.drawFullsizedImage(g, this, background);

        repaint();
    }
}
