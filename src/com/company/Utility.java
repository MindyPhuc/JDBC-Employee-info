/**********************************************
 Workshop 10
 Course:JAC444 - Semester: Winter 2021
 Last Name: Huynh
 First Name: Thi My Phuc (Mindy)
 ID: 149792186
 Section: NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature: Thi My Phuc Huynh
 Date: Apr 16, 2021
 **********************************************/
package com.company;

import java.util.Scanner;

public class Utility {

    /** ================= Utility methods ======================= */
    /** get an integer input */
    public static int getInt() {
        boolean done = false;
        int result = -1;
        Scanner input = new Scanner(System.in);

        do {
            if(input.hasNextDouble()) {
                result = input.nextInt();
                done = true;
            } else {
                System.out.printf("Invalid input, please try again: ");
                input.next();
            }
        } while (!done);
        return result;
    }

    /** get an integer in range (inclusive) */
    public static int getIntegerInRange(int min, int max) {
        Scanner input = new Scanner(System.in);
        int result = -1;
        boolean done = false;

        do {
            if(input.hasNextInt()) {
                result = input.nextInt();

                if(result < min || result > max) {
                    System.out.printf("Please enter a number (" + min + "-" + max + "): ");
                } else {
                    done = true;
                }
            } else {
                System.out.printf("Invalid input. Please try again: ");
                input.next();
            }

        } while (!done);
        return result;
    }
}
