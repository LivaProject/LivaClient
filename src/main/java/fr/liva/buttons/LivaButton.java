package fr.liva.buttons;

import fr.liva.utils.LivaUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class LivaButton extends JComponent implements MouseListener {

    public Image image;
    public Image hover;
    private boolean activate = false;

    private Map<LivaActionType, LivaAction> action = new HashMap<>();

    public LivaButton(Image image) {
        this(image, null);
    }

    public LivaButton(Image image, Image hover) {
        super();

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

        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        activate = false;

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
