package me.austindart.currencyconverter.gui.buttonlisteners;

import me.austindart.currencyconverter.gui.ConverterGUI;
import me.austindart.currencyconverter.utils.ConversionUtils;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public record ConvertButtonListener(ConverterGUI gui) implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (gui.getAPIKey() == null || gui.getAPIKey().isEmpty() || gui.getAPIKey().isBlank() || gui.getAPIKey().equals(""))
        {
            return;
        }
        double inputValue = gui.getValueFromInput();
        String apiKey = gui.getAPIKey();
        double conversionRate = 0;
        try
        {
            conversionRate = ConversionUtils.getConversionRate(gui.getInputCurrency(), gui.getOutputCurrency(), apiKey);
        } catch (IOException ex)
        {
            ex.printStackTrace();
        } catch (ParseException ex)
        {
            ex.printStackTrace();
        }
        double outputValue = inputValue * conversionRate;
        gui.setOutputText(String.valueOf(outputValue));
    }
}
