package com.bartoszwalter.students.taxes.output;

import java.util.Map;

public interface Output {
    void sendOutput(ValueType valueType, double value);

    void sendOutput(String message);

}
