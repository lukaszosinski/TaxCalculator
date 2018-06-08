package com.bartoszwalter.students.taxes.input;

import com.bartoszwalter.students.taxes.umowa.Umowa.RodzajUmowy;


public interface Input {

    double getKwotaDochodu();

    RodzajUmowy getRodzajUmowy();

}
