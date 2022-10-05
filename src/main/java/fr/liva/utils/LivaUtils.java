package fr.liva.utils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LivaUtils {

    public static BufferedImage getResource(String resource) {
        try {
            return ImageIO.read(new File("src/main/resources/" + resource));
        } catch (IOException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int percentage(int value, int maximum) {
        return crossMult(value, maximum, 100);
    }

    public static int crossMult(int value, int maximum, int coefficient) {
        return (int) ((double) value / (double) maximum * (double) coefficient);
    }

    public static Point getRecCenterPos(Rectangle parent, Rectangle rectangle) {
        double x = parent.getWidth() / 2 - rectangle.getWidth() / 2;
        double y = parent.getHeight() / 2 + rectangle.getHeight() / 2;

        return new Point((int) x, (int) y);
    }

    public static Point getStringCenterPos(Rectangle parent, String str, FontMetrics fontMetrics, Graphics g) {
        // Getting the string bounds
        Rectangle2D stringBounds = fontMetrics.getStringBounds(str, g);

        // Getting the center pos for this rectangle
        double x = ((parent.getWidth() - stringBounds.getWidth()) / 2);
        double y = ((parent.getHeight() - stringBounds.getHeight()) / 2 + fontMetrics.getAscent());
        return new Point((int) x, (int) y);
    }

    public static BufferedImage colorImage(BufferedImage image, int red, int green, int blue) {
        // Creating a new translucent image with the same size as the given image, and creating its graphics
        BufferedImage img = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TRANSLUCENT);
        Graphics2D graphics = img.createGraphics();

        // Getting the given color with 0 alpha (its needed)
        Color newColor = new Color(red, green, blue, 0);

        // Drawing the given image, to the new image with the xor mode as the given color
        graphics.setXORMode(newColor);
        graphics.drawImage(image, null, 0, 0);
        graphics.dispose();

        // Returning the created image
        return img;
    }

    public static void drawFullsizedImage(Graphics g, JComponent component, Image image) {
        g.drawImage(image, 0, 0, component.getWidth(), component.getHeight(), component);
    }

    public static void fillFullsizedRect(Graphics g, JComponent component) {
        g.fillRect(0, 0, component.getWidth(), component.getHeight());
    }

    public static void fillFullsizedRect(Graphics g, JComponent component, Color color) {
        g.setColor(color);
        g.fillRect(0, 0, component.getWidth(), component.getHeight());
    }
}
