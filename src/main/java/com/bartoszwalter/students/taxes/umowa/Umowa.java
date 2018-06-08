package com.bartoszwalter.students.taxes.umowa;


import com.bartoszwalter.students.taxes.input.Input;
import com.bartoszwalter.students.taxes.output.Output;

import java.io.IOException;


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
            default: throw new IOException("Zły rodzaj umowy");
        }
        umowa.setInput(input);
        return umowa;
    }


    void oblicz();
    void setOutput(Output output);
    void setInput(Input input);

}
