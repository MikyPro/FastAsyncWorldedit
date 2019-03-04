package com.boydti.fawe.installer;


import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(BufferedImage image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setComposite(AlphaComposite.getInstance(
                AlphaComposite.SRC_OVER, 0.6f));
        g.drawImage(image, 0, 0, getWidth(), getWidth(), this); // see javadoc for more info on the parameters
    }

}
