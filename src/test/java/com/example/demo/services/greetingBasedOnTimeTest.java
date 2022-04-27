package com.example.demo.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreetingBasedOnTimeTest {

    @Test
    void greetingBasedOnTime() {

        // arrange
        GreetingBasedOnTime greetingBasedOnTime = new GreetingBasedOnTime();

        //act
        //Morning
        String morning = greetingBasedOnTime.greetingBasedOnTime(5);
        //Afternoon
        String afternoon = greetingBasedOnTime.greetingBasedOnTime(12);
        //Evening
        String evening = greetingBasedOnTime.greetingBasedOnTime(16);
        //Night
        String night = greetingBasedOnTime.greetingBasedOnTime(22);
        //Night past 24
        String nightPastMidnight = greetingBasedOnTime.greetingBasedOnTime(4);
        //Invalid
        // Greater than 24
        String invalid = greetingBasedOnTime.greetingBasedOnTime(29);
        // Less than 0
        String invalidTooLow = greetingBasedOnTime.greetingBasedOnTime(-1);

        //assert
        assertEquals("morning", morning);
        assertEquals("afternoon", afternoon);
        assertEquals("evening", evening);
        assertEquals("night", night);
        assertEquals("night", nightPastMidnight);
        assertEquals("invalid", invalid);
        assertEquals("invalid", invalidTooLow);


    }
}