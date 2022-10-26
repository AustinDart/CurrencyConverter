package me.austindart.currencyconverter.gui;

import me.austindart.currencyconverter.gui.buttonlisteners.APIKeySubmitButtonListener;
import me.austindart.currencyconverter.gui.buttonlisteners.ConvertButtonListener;

import javax.swing.*;
import java.awt.*;

public class ConverterGUI extends BaseGUI {

    private String apiKey;

    private JLabel inputLabel;
    private JLabel outputLabel;

    private JTextField inputTextField;
    private JLabel outputText;

    private JSpinner inputSpinner;
    private JSpinner outputSpinner;

    private JButton calculateButton;

    private JLabel apiKeyLabel;
    private JTextField apiKeyTextField;
    private JButton apiKeySubmitButton;

    public ConverterGUI() {
        super();
        inputLabel = new JLabel("Input amount:");
        inputTextField = new JTextField(10);
        outputLabel = new JLabel("Output amount:");
        outputText = new JLabel("0");

        String[] supportedCurrencies = {"FJD", "MXN", "STD", "LVL", "SCR", "CDF", "BBD", "GTQ", "CLP", "HNL", "UGX",
                "ZAR", "TND", "CUC", "BSD", "SLL", "SDG", "IQD", "CUP", "GMD", "TWD", "RSD", "DOP", "KMF", "MYR", "FKP",
                "XOF", "GEL", "BTC", "UYU", "MAD", "CVE", "TOP", "AZN", "OMR", "PGK", "KES", "SEK", "BTN", "UAH", "GNF",
                "ERN", "MZN", "SVC", "ARS", "QAR", "IRR", "MRO", "CNY", "THB", "UZS", "XPF", "BDT", "LYD", "BMD", "KWD",
                "PHP", "RUB", "PYG", "ISK", "JMD", "COP", "MKD", "USD", "DZD", "PAB", "GGP", "SGD", "ETB", "JEP", "KGS",
                "SOS", "VEF", "VUV", "LAK", "BND", "ZMK", "XAF", "LRD", "XAG", "CHF", "HRK", "ALL", "DJF", "ZMW", "TZS",
                "VND", "XAU", "AUD", "ILS", "GHS", "GYD", "KPW", "BOB", "KHR", "MDL", "IDR", "KYD", "AMD", "BWP", "SHP",
                "TRY", "LBP", "TJS", "JOD", "AED", "HKD", "RWF", "EUR", "LSL", "DKK", "CAD", "BGN", "MMK", "MUR", "NOK",
                "SYP", "IMP", "ZWL", "GIP", "RON", "LKR", "NGN", "CRC", "CZK", "PKR", "XCD", "ANG", "HTG", "BHD", "KZT",
                "SRD", "SZL", "LTL", "SAR", "TTD", "YER", "MVR", "AFN", "INR", "AWG", "KRW", "NPR", "JPY", "MNT", "AOA",
                "PLN", "GBP", "SBD", "BYN", "HUF", "BYR", "BIF", "MWK", "MGA", "XDR", "BZD", "BAM", "EGP", "MOP", "NAD",
                "NIO", "PEN", "NZD", "WST", "TMT", "CLF", "BRL"};

        SpinnerListModel curModel = new SpinnerListModel(supportedCurrencies);
        inputSpinner = new JSpinner(curModel);
        SpinnerListModel curModel2 = new SpinnerListModel(supportedCurrencies);
        outputSpinner = new JSpinner(curModel2);

        calculateButton = new JButton("Calculate");

        apiKeyLabel = new JLabel("API Key: ");
        apiKeyTextField = new JTextField(10);
        apiKeySubmitButton = new JButton("Submit API Key");

        setupButtons();

        jPanel.add(inputLabel);
        jPanel.add(inputTextField);
        jPanel.add(inputSpinner);

        jPanel.add(outputLabel);
        jPanel.add(outputText);
        jPanel.add(outputSpinner);

        jPanel.add(calculateButton);
        jPanel.add(new JSeparator());
        jPanel.add(new JSeparator());

        jPanel.add(apiKeyLabel);
        jPanel.add(apiKeyTextField);
        jPanel.add(apiKeySubmitButton);


        jPanel.setLayout(new GridLayout(4, 3));

        jFrame.setTitle("Currency Converter");
        jFrame.pack();
    }

    public String getInputCurrency() {
        return inputSpinner.getValue().toString();
    }

    public String getOutputCurrency() {
        return outputSpinner.getValue().toString();
    }

    public double getValueFromInput() {
        String inputText = inputTextField.getText();
        double value;
        try {
            value = Double.parseDouble(inputText);
        } catch (NumberFormatException e) {
            value = -1;
        }
        return value;
    }

    public void setOutputText(String text) {
        outputText.setText(text);
    }

    public void setAPIKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getAPIKey() {
        return apiKey;
    }

    public String getInputAPIKey() {
        return apiKeyTextField.getText();
    }

    private void setupButtons() {
        calculateButton.addActionListener(new ConvertButtonListener(this));
        apiKeySubmitButton.addActionListener(new APIKeySubmitButtonListener(this));
    }

}
