package com.boydti.fawe.installer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MinimizeButton extends InteractiveButton {
    private final JFrame window;

    public MinimizeButton(JFrame window) {
        super("-");
        this.window = window;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.setState(Frame.ICONIFIED);
    }
}
