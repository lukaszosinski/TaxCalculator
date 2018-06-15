package com.bartoszwalter.students.taxes.output;

import java.util.HashMap;
import java.util.Map;

public class Descriptions {


     final private Map<ValueType, String> descriptions = new HashMap<ValueType, String>(){
         {

             put(ValueType.kwotaDochodu,                "Podstawa wymiaru składek");
             put(ValueType.ubezpieczenieEmerytalne,     "Składka na ubezpieczenie emerytalne");
             put(ValueType.ubezpieczenieRentowe,        "Składka na ubezpieczenie rentowe");
             put(ValueType.ubezpieczenieChorobowe,      "Składka na ubezpieczenie chorobowe");
             put(ValueType.podstawaSkladkiNaUbezZdrow,  "Podstawa wymiaru składki na ubezpieczenie zdrowotne");
             put(ValueType.skladkaZdrowZUS,             "Składka na ubezpieczenie zdrowotne: 9%");
             put(ValueType.skladkaZdrowPomniejszajaca,  "Składka na ubezpieczenie zdrowotne: 7.5%");
             put(ValueType.kosztyUzyskaniaPrzychodu,    "Koszty uzyskania przychodu w stałej wysokości");
             put(ValueType.podstawaOpodatkowania,       "Podstawa opodatkowania");
             put(ValueType.podstawaOpodatkowaniaZaokr,  "Podstawa opodatkowania zaokrąglona");
             put(ValueType.zaliczkaPodatekDochodowy,    "Zaliczka na podatek dochodowy 18%");
             put(ValueType.kwotaWolnaOdPodatku,         "Kwota wolna od podatku");
             put(ValueType.podatekPotracony,            "Podatek potrącony");
             put(ValueType.zaliczkaUrzadSkarbowy,       "Zaliczka do urzędu skarbowego");
             put(ValueType.zaliczkaUrzadSkarbowyZaokr,  "Zaliczka do urzędu skarbowego zaokrąglona");
             put(ValueType.wynagrodzenie,               "\nPracownik otrzyma wynagrodzenie netto w wysokości");
         }
     };


    public String getDescriptions(ValueType valueType){
        return descriptions.get(valueType);
    }


}
