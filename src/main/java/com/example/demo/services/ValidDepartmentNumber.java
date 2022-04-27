package com.example.demo.services;

import java.util.stream.IntStream;

public class ValidDepartmentNumber {
    public boolean validDepartmentNumber(int departmentNo){

        if(departmentNo > 9 && departmentNo < 1000){
            return departmentNo % 10 == 0;
        }

        return false;
    }
}
