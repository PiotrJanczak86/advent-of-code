package com.advent.Day3;

import com.sun.tools.javac.Main;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindRegex {

    public void find(String fileName) {

        String content = "";
        long result = 0;
        try {
            URI resourceUri = Objects.requireNonNull(Main.class.getClassLoader().getResource(fileName)).toURI();
            content = Files.readString(Paths.get(resourceUri));
        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        String regex = "(?:^|do\\(\\)).*?(?:don't\\(\\)|$)";
        Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        content = "";
        while (matcher.find()) {
            String match = matcher.group();
            content = content + match;
        }

        System.out.println(content);
        String regex1 = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(content);
        while (matcher1.find()) {
            int firstInt = Integer.parseInt(matcher1.group(1));
            int secondInt = Integer.parseInt(matcher1.group(2));
            result = result + (long) firstInt * secondInt;
        }
        System.out.println(result);
    }
}