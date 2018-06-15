package com.bartoszwalter.students.taxes.output;


import java.util.ArrayList;

public class OutputConsole implements Output {


    private Descriptions descriptions;

    public OutputConsole(){
        this.descriptions = new Descriptions();
    }

    public OutputConsole(Descriptions descriptions) {
        this.descriptions = descriptions;
    }

    public void setDescriptions(Descriptions descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public void sendOutput(ValueType valueType, double value) {
        String formatedValue = String.format("%.2f", value);
        System.out.println(descriptions.getDescriptions(valueType) + ": " + formatedValue);
    }


    public void sendOutput(String message) {
        System.out.println(message);
    }
}