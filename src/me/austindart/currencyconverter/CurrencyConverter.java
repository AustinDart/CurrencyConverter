package me.austindart.currencyconverter;

import me.austindart.currencyconverter.gui.ConverterGUI;
import me.austindart.currencyconverter.utils.ConversionUtils;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class CurrencyConverter
{

    public static void main(String[] args) throws IOException, ParseException
    {
        new ConverterGUI();
    }

}
