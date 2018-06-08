package com.bartoszwalter.students.taxes.input;

import com.bartoszwalter.students.taxes.umowa.Umowa.RodzajUmowy;

import java.io.IOException;


public interface Input {

    double getKwotaDochodu();

    RodzajUmowy getRodzajUmowy();

    void loadInput() throws IOException;

}
