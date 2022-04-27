package com.example.demo.services;

public class GreetingBasedOnTime {
    public String greetingBasedOnTime(int time) {

        if (time >= 5 && time < 12) {
            return "morning";
        } else if (time >= 12 && time < 16) {
            return "afternoon";
        } else if (time >= 16 && time < 22) {
            return "evening";
        } else if (time >= 22  && time < 24 || time < 5 && time > 0) {
            return "night";
        }else if(time > 23 || time < 0){
            return "invalid";
        }
        return null;
    }

    public static void main(String[] args) {
        GreetingBasedOnTime greetingBasedOnTime = new GreetingBasedOnTime();
        System.out.println(greetingBasedOnTime.greetingBasedOnTime(25));
    }
}
