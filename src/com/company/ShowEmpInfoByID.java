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

import java.sql.*;

import static com.company.Utility.*;

/** ============ Task 1 ====================================================
 * This class uses Oracle OCI database driver to implement the connection
 *  - prompt user to enter employee_ID
 *  - execute the query
 *  - display the information of this employee (full name, email, salary)
 */
public class ShowEmpInfoByID {
    // database URL (OCI)
    static final String URL = "jdbc:oracle:oci:@//myoracle12c.senecacollege.ca/oracle12c";

    // JDBC driver
    static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

    // Database credentials
    static final String USERID = "jac444_211b12";
    static final String PASSWORD = "14431687";

    public ShowEmpInfoByID() {

        Connection connection = null;
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(DRIVER_NAME); // load and register JDBC driver
            connection = DriverManager.getConnection(URL, USERID, PASSWORD); // establish the connection
            System.out.println("Connected database using OCI database driver successfully!");

            // create a prepared statement
            String sql = "SELECT first_name||' '||last_name, email, salary\n" +
                    "  FROM employees\n" +
                    "  WHERE employee_ID = ?";
            pStatement = connection.prepareStatement(sql);

            // get user input
            System.out.print("Please enter employee ID: ");
            int empID = getInt();
            // set up query parameter
            pStatement.setInt(1, empID);

            // execute query
            resultSet = pStatement.executeQuery();

            // process the result
            if (!resultSet.next()) {
                System.out.println("Cannot find the information of employee with ID " + empID);
            } else {
                System.out.println("--------------------------------");
                System.out.println("Employee information (ID: " + empID + "):");
                System.out.println("\tFull Name: " + resultSet.getString(1));
                System.out.println("\tEmail: " + resultSet.getString(2));
                System.out.println("\tSalary: "+ resultSet.getInt(3));
            }

        } catch (ClassNotFoundException cnfex) {
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (pStatement != null) {
                    pStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught in StatementExample.main() finally block");
                System.out.println("Exception: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
