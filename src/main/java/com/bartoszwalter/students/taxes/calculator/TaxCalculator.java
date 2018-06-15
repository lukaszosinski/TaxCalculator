package com.bartoszwalter.students.taxes.calculator;


import com.bartoszwalter.students.taxes.input.Input;
import com.bartoszwalter.students.taxes.input.InputConsole;
import com.bartoszwalter.students.taxes.input.InputMock;
import com.bartoszwalter.students.taxes.output.Output;
import com.bartoszwalter.students.taxes.output.OutputConsole;
import com.bartoszwalter.students.taxes.umowa.Umowa;

import java.io.IOException;

public class TaxCalculator {

    public static void main(String[] args) {

        try {
            Input input = new InputConsole();
            Output output = new OutputConsole();
            Umowa umowa = Umowa.getInstance(input);
            umowa.setOutput(output);
            umowa.obliczWynagrodzenie();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
