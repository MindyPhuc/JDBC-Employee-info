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

/** ------------ Task 2 ---------------- */
/** This class uses Oracle Thin database driver to implement the connection
 *  - prompt user to enter department ID
 *  - call the PL/SQL total_emp_by_dept_id to get the total number of employees in a department by department id
 */
public class ShowTotalEmpByDeptID {
    // database URL (Thin)
    static final String URL = "jdbc:oracle:thin:@//myoracle12c.senecacollege.ca/oracle12c";

    // JDBC driver
    static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

    // Database credentials
    static final String USERID = "jac444_211b12";
    static final String PASSWORD = "14431687";


    /** set up the connection
     *  - call the PL/SQL
     *  - process and display the results
     */
    public ShowTotalEmpByDeptID(){
        Connection connection = null;
        CallableStatement callableStatement = null;

        //Constructing the String to call the Store Procedure with 1 parameter place holder
        String getTotalEmpByDeptId = "{call total_emp_by_dept_id(?,?)}";

        try {
            Class.forName(DRIVER_NAME); // load and register JDBC driver
            connection = DriverManager.getConnection(URL, USERID, PASSWORD); // establish the connection
            System.out.println("Connected database using Thin database driver successfully!");

            callableStatement = connection.prepareCall(getTotalEmpByDeptId);

            // get user input
            System.out.print("Please enter department ID: ");
            int deptID = getInt();

            // set up query parameters
            callableStatement.setInt(1, deptID);
            callableStatement.registerOutParameter(2, Types.INTEGER);

            // execute getTotalEmpByDeptId store procedure
            callableStatement.executeUpdate();

            // process the result
            int totalEmp = callableStatement.getInt(2);
            System.out.println("Total number of employees (Department ID: " + deptID + "): " + totalEmp);

        } catch (ClassNotFoundException cnfex) {
            System.err.println("Failed to load JDBC/ODBC driver.");
        } catch (SQLException e) {
            System.out.println("The error is:  " + e.getMessage());
            e.printStackTrace();
        } finally {

            try {
                if (callableStatement != null) {
                    callableStatement.close();
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
