package fr.liva.components.buttons;

import fr.liva.launcher.LauncherPanel;
import fr.liva.utils.LivaUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class LivaButton extends JComponent implements MouseListener {

    private LauncherPanel panel;

    public Image image;
    public Image hover;
    private boolean activate = false;

    private Map<LivaActionType, LivaAction> action = new HashMap<>();

    public LivaButton(Image image) {
        this(image, image);
    }

    public LivaButton(LauncherPanel panel, Image image) {
        this(panel, image, image);
    }

    public LivaButton(Image image, Image hover) {
        this(null, image, hover);
    }

    public LivaButton(LauncherPanel panel, Image image, Image hover) {
        super();

        this.panel = panel;
        this.image = image;
        this.hover = hover;

        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        LivaAction action = this.action.get(LivaActionType.CLICK);
        if (action != null) {
            action.onAction();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        LivaAction action = this.action.get(LivaActionType.PRESS);
        if (action != null) {
            action.onAction();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        LivaAction action = this.action.get(LivaActionType.RELEASE);
        if (action != null) {
            action.onAction();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        activate = true;

        LivaAction action = this.action.get(LivaActionType.HOVER);
        if (action != null) {
            action.onAction();
        }

        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        activate = false;

        LivaAction action = this.action.get(LivaActionType.HOVER);
        if (action != null) {
            panel.setCursor(panel.getLauncher().defaultCursor());
        }

        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawImage(g);
    }

    public void setAction(LivaActionType actionType, LivaAction action) {
        this.action.put(actionType, action);
    }

    public Image getImage() {
        return activate ? hover : image;
    }

    public void drawImage(Graphics g) {
        LivaUtils.drawFullsizedImage(g, this, getImage());
    }
}
