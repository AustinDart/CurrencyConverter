package me.austindart.currencyconverter.gui.buttonlisteners;

import me.austindart.currencyconverter.gui.ConverterGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record APIKeySubmitButtonListener(ConverterGUI gui) implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String apiKey = gui.getInputAPIKey();
        gui.setAPIKey(apiKey);
    }
}
