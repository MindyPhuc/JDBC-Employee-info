-- /**********************************************
-- Workshop 10
-- Course:JAC444 - Semester: Winter 2021
-- Last Name: Huynh
-- First Name: Thi My Phuc (Mindy)
-- ID: 149792186
-- Section: NBB
-- This assignment represents my own work in accordance with Seneca Academic Policy.
-- Signature: Thi My Phuc Huynh
-- Date: Apr 16, 2021
-- **********************************************/


CREATE OR REPLACE PROCEDURE total_emp_by_dept_id(
	   p_deptID     IN EMPLOYEES.DEPARTMENT_ID%TYPE,
	   o_total      OUT INTEGER)	   
IS
BEGIN

  SELECT COUNT(*)
  INTO o_total
  FROM  EMPLOYEES WHERE DEPARTMENT_ID = p_deptID;

END;