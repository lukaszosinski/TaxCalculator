package com.bartoszwalter.students.taxes.umowa;


import com.bartoszwalter.students.taxes.input.Input;
import com.bartoszwalter.students.taxes.output.Output;

import java.io.IOException;
import java.security.InvalidParameterException;


public interface Umowa {

    enum RodzajUmowy{
        PRACA,
        ZLECENIE
    }

    static Umowa getInstance(Input input) throws IOException {
        RodzajUmowy rodzajUmowy = input.getRodzajUmowy();
        Umowa umowa;
        switch (rodzajUmowy){
            case PRACA:
                umowa = new UmowaOPrace();
                break;
            case ZLECENIE:
                umowa = new UmowaZlecenie();
                break;
            default: throw new InvalidParameterException("Ten rodzaj umowy nie jest obslugiwany");
        }
        umowa.setInput(input);
        return umowa;
    }

    void loadInputData() throws IOException;

    double obliczWynagrodzenie();
    void setOutput(Output output);
    void setInput(Input input);


}
