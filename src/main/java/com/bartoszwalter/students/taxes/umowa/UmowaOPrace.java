package com.bartoszwalter.students.taxes.umowa;


import com.bartoszwalter.students.taxes.output.ValueType;

public class UmowaOPrace extends UmowaAbstract {


    private double kosztyUzyskaniaPrzychodu;
    private double kwotaWolnaOdPodatku;

    public UmowaOPrace() {
        kosztyUzyskaniaPrzychodu = 111.25;
        kwotaWolnaOdPodatku = 46.33;
    }


    void printDescription(){
        sendOutput("UMOWA O PRACĘ");
    }

    double obliczPodatekPotracony(double zaliczkaPodatekDochodowy){
        sendOutput(ValueType.kwotaWolnaOdPodatku, kwotaWolnaOdPodatku);
        double podatekPotracony = zaliczkaPodatekDochodowy - kwotaWolnaOdPodatku;
        sendOutput(ValueType.podatekPotracony, podatekPotracony);
        return podatekPotracony;
    }


    double obliczKosztyUzyskaniaPrzychodu(double podstawaSkladkiNaUbezZdrow){
        double kosztyUzyskaniaPrzychodu = this.kosztyUzyskaniaPrzychodu;
        sendOutput(ValueType.kosztyUzyskaniaPrzychodu, kosztyUzyskaniaPrzychodu);
        return kosztyUzyskaniaPrzychodu;
    }

}
