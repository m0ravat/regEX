package org.example;
import java.util.regex.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to my regex repo! \n");
        runRegex("test", "This is a test");
        runRegex("^[0-9]{11}$", "07769004379");
        runRegex("^[0-9]{11}$", "077690043791");
        runRegex("^[0-9]{11}$", "0776900437");
        runRegex("^[0-9]{11}$", "0776900437a");
        boolean menu;
        System.out.println("Type 0 if you want to run the anti tiktok regex");

    }
    public static void runRegex(String regex, String input) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            System.out.println("Match success for pattern " + regex + ": " + input);
        } else {
            System.out.println("No match");
        }
    }
}