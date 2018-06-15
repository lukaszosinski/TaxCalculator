package com.bartoszwalter.students.taxes.umowa;


import com.bartoszwalter.students.taxes.output.ValueType;

public class UmowaZlecenie extends UmowaAbstract {

    public UmowaZlecenie() {
        kwotaWolnaOdPodatku = 0;
    }

    double kwotaWolnaOdPodatku;


    void printDescription(){
        sendOutput("UMOWA ZLECENIE");
    }

    double obliczPodatekPotracony(double zaliczkaPodatekDochodowy){
        sendOutput(ValueType.kwotaWolnaOdPodatku, kwotaWolnaOdPodatku);
        double podatekPotracony = zaliczkaPodatekDochodowy;
        sendOutput(ValueType.podatekPotracony, podatekPotracony);
        return podatekPotracony;
    }

    double obliczKosztyUzyskaniaPrzychodu(double podstawaSkladkiNaUbezZdrow){
        double kosztyUzyskaniaPrzychodu = (podstawaSkladkiNaUbezZdrow * 20) / 100;
        sendOutput(ValueType.kosztyUzyskaniaPrzychodu, kosztyUzyskaniaPrzychodu);
        return kosztyUzyskaniaPrzychodu;
    }

}
