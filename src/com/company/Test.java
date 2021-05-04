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

import static com.company.Utility.*;

/**
 * This class is used to test the classes:
 * - ShowEmpInfoByID
 * - ShowTotalEmpByDeptID
 */

public class Test {
    public static void main (String[] args) {
        int choice = -1;
        while (choice != 0) {
            System.out.println("--------------------------------- TESTING ----------------------------------");
            System.out.println("1 - Show employee information by employee ID");
            System.out.println("2 - Show total number of employees by department ID");
            System.out.println("0 - Exit");
            System.out.println("----------------------------------------------------------------------------");
            System.out.printf("Please enter your option: ");
            choice = getIntegerInRange(0, 2);

            if (choice == 1) {
                new ShowEmpInfoByID(); // show employee information by employee ID
            } else if (choice == 2) {
                new ShowTotalEmpByDeptID(); // Show total number of employees by department ID
            }
        }
    }
}
