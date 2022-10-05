package fr.liva.listeners;

import fr.liva.launcher.Launcher;
import fr.liva.launcher.LauncherPanel;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LivaMouseEvent extends MouseAdapter {

    private Point point;
    private Launcher launcher;
    private LauncherPanel panel;

    public LivaMouseEvent(Launcher launcher, LauncherPanel panel) {
        this.launcher = launcher;
        this.panel = panel;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        // Not Clicked
        if (point == null) {
            return;
        }

        // Drag Point
        Point point = MouseInfo.getPointerInfo().getLocation();

        // Move
        launcher.setLocation(new Point((int) point.getX() - (int) this.point.getX(), (int) point.getY() - (int) this.point.getY()));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.point = e.getPoint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        super.mouseMoved(e);
    }
}
