package me.austindart.currencyconverter.gui;

import javax.swing.*;
import java.awt.*;

public class BaseGUI
{

    protected JFrame jFrame;
    protected JPanel jPanel;

    public BaseGUI()
    {
        jFrame = new JFrame();

        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));

        jFrame.add(jPanel, BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(300, 300);
        jFrame.pack();
        jFrame.setVisible(true);
    }

}