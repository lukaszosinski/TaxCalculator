package com.bartoszwalter.students.taxes.output;

import java.util.Map;

public interface Output {
    void deliverOutput(Map<String, Double> output);
}
