package com.company;

import java.util.Scanner;

public class UserPrompting {

    public static double promptUser(String prompt, int min, int max) {

        double value;
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println( prompt + ":");
            value = input.nextDouble();

            if (value >= min && value <= max)
                break;
            System.out.println("Enter a number between "+ min + " and " + max);

        }
        return value;
    }
}
