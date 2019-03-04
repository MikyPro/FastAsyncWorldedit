package com.boydti.fawe.installer;

import javax.swing.*;
import java.awt.*;

public class InvisiblePanel extends JPanel {
    public InvisiblePanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(0, 0, 0, 0));
    }

    public InvisiblePanel() {
        this(new FlowLayout());
    }
}
