package com.philippepeter.formatter;

import javax.swing.*;

public class FormatterImpl implements Formatter{
    @Override
    public String format(double value) {
        return null;
    }

    @Override
    public String format(float value) {
        return null;
    }

    @Override
    public String format(int value) {
        return null;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new JLabel("12,345x10\u207B\u2076"));
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
