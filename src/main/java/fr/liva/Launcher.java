package fr.liva;

import fr.liva.listeners.LivaMouseEvent;
import fr.liva.utils.LivaUtils;
import fr.liva.utils.animate.Animator;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame {

    private LauncherPanel panel;

    public Launcher() {
        panel = new LauncherPanel();

        setTitle("LivaLauncher");
        setSize(1080, 780);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setBackground(new Color(0, 0, 0, 0));
        setIconImage(LivaUtils.getResource("images/icon.png"));

        // Cursor
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = LivaUtils.getResource("cursors/cursor.png");
        Cursor cursor = toolkit.createCustomCursor(image , new Point(getX(), getY()), "cursor");
        setCursor(cursor);

        // Panel
        setContentPane(panel);

        // Listeners
        LivaMouseEvent mouseEvent = new LivaMouseEvent(this, panel);
        addMouseListener(mouseEvent);
        addMouseMotionListener(mouseEvent);
        Animator.fadeInFrame(this, 3);

        setVisible(true);
    }

}
