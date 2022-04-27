package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidDepartmentNumberTest {

    @Test
    void validDepartmentTest() {
        //Arrange
        ValidDepartmentNumber validDepartmentNumber = new ValidDepartmentNumber();
        //Act
        boolean lessThan10 = validDepartmentNumber.validDepartmentNumber(9);
        boolean greaterThan999 = validDepartmentNumber.validDepartmentNumber(1000);
        boolean notDivisibleBy10 = validDepartmentNumber.validDepartmentNumber(314);
        boolean valid = validDepartmentNumber.validDepartmentNumber(320);
        boolean valid2 = validDepartmentNumber.validDepartmentNumber(990);
        //Assert
        assertFalse(lessThan10);
        assertFalse(greaterThan999);
        assertFalse(notDivisibleBy10);
        assertTrue(valid);
        assertTrue(valid2);


    }

}