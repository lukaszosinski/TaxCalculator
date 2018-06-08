package com.bartoszwalter.students.taxes.calculator;


import com.bartoszwalter.students.taxes.input.Input;
import com.bartoszwalter.students.taxes.input.InputMock;
import com.bartoszwalter.students.taxes.umowa.Umowa;

import java.io.IOException;

public class TaxCalculator {

    public static void main(String[] args) {

        Input input = new InputMock();

        try {
            Umowa umowa = Umowa.getInstance(input);
            umowa.oblicz();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
