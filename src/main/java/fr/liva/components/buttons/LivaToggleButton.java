package fr.liva.components.buttons;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LivaToggleButton extends LivaButton {

    private boolean toggled;

    public LivaToggleButton(Image image, Image toggled) {
        this(image, toggled, false);
    }

    public LivaToggleButton(Image image, Image toggledImage, boolean toggled) {
        super(image, toggledImage);
        this.toggled = toggled;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        toggled = !toggled;

        repaint();
    }

    @Override
    public Image getImage() {
        return toggled ? hover : image;
    }
}
