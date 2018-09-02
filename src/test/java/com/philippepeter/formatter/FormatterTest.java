package com.philippepeter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class FormatterTest {

    private final static FormatterImpl FORMATTER = new FormatterImpl();

    @Test
    public void testFromFile() {
        InputStream resourceAsStream = FormatterTest.class.getResourceAsStream("/test.data");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream))) {
            for (String line; (line = reader.readLine()) != null;) {
                String string = StringEscapeUtils.unescapeJava(line);
                testString(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void testString(String string) {
        String[] split = string.split(";");

        if(split[0].contains(".")) {
            testFloatString(split);
            testDoubleString(split);
        } else {
            testIntString(split);
        }


    }

    private void testIntString(String[] split) {
        int value = Integer.parseInt(split[0]);

        String format = FORMATTER.format(value);
        log.info(split[0] + " expected=" + split[1] + " result=" + format);
        Assert.assertEquals(split[1], format);
    }

    private void testDoubleString(String[] split) {
        double value = Double.parseDouble(split[0]);

        String format = FORMATTER.format(value);
        log.info(split[0] + " expected=" + split[1] + " result=" + format);
        Assert.assertEquals(split[1], format);
    }

    private void testFloatString(String[] split) {
        float value = Float.parseFloat(split[0]);

        String format = FORMATTER.format(value);
        log.info(split[0] + " expected=" + split[1] + " result=" + format);
        Assert.assertEquals(split[1], format);
    }

}
