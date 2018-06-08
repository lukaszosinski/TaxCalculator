package com.bartoszwalter.students.taxes.input;

import com.bartoszwalter.students.taxes.umowa.Umowa;

public class InputMock implements Input{

    @Override
    public double getKwotaDochodu() {
        return 2000;
    }

    @Override
    public Umowa.RodzajUmowy getRodzajUmowy() {
        return Umowa.RodzajUmowy.PRACA;
    }
}
