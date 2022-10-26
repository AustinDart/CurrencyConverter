package me.austindart.currencyconverter.gui.buttonlisteners;

import me.austindart.currencyconverter.gui.ConverterGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * APIKeySubmitButtonListener is the ActionListener used for the Submit API Key button
 *
 * @param gui ConverterGUI that the related button is a member of
 *
 * @author Austin Dart
 */
public record APIKeySubmitButtonListener(ConverterGUI gui) implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String apiKey = gui.getInputAPIKey();
        gui.setAPIKey(apiKey);
    }
}
