package fr.liva.launcher;

import fr.liva.Main;
import fr.liva.listeners.LivaMouseEvent;
import fr.liva.utils.LivaUtils;
import fr.liva.utils.animate.Animator;

import javax.swing.*;
import java.awt.*;

public class Launcher extends JFrame {

    private LauncherPanel panel;

    public Launcher() {
        panel = new LauncherPanel(this);

        setTitle(Main.NAME);
        setSize(Main.WIDTH, Main.HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setBackground(new Color(0, 0, 0, 0));
        setIconImage(LivaUtils.getResource("images/icon.png"));

        // Cursor
        setCursor(defaultCursor());

        // Panel
        setContentPane(panel);

        // Listeners
        LivaMouseEvent mouseEvent = new LivaMouseEvent(this, panel);
        addMouseListener(mouseEvent);
        addMouseMotionListener(mouseEvent);
        Animator.fadeInFrame(this, 3);

        // Visible
        setVisible(true);
    }

    public Cursor defaultCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = LivaUtils.getResource("cursors/cursor.png");

        return toolkit.createCustomCursor(image , new Point(getX(), getY()), "cursor");
    }

    public Cursor hoverCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = LivaUtils.getResource("cursors/hover.png");

        return toolkit.createCustomCursor(image , new Point(getX(), getY()), "hover_cursor");
    }

}
