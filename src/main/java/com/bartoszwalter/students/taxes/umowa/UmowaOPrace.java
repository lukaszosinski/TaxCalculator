package com.bartoszwalter.students.taxes.umowa;


public class UmowaOPrace extends UmowaAbstract {


    double podstawaSkladkiNaUbezZdrow;
    double kosztyUzyskaniaPrzychodu  = 111.25;
    double podstawaOpodatkowania;
    double podstawaOpodatkowaniaZaokr;
    double podatekPotracony;
    double zaliczkaUrzadSkarbowyZaokr;
    double wynagrodzenie;

    @Override
    public void oblicz() {
        System.out.println("UMOWA O PRACĘ");
        System.out.println("Podstawa wymiaru składek " + kwotaDochodu);
        podstawaSkladkiNaUbezZdrow = odliczUbezpieczeniaSpoleczne(kwotaDochodu);
        System.out.println("Składka na ubezpieczenie emerytalne "
                + df00.format(ubezpieczenieEmerytalne));
        System.out.println("Składka na ubezpieczenie rentowe    "
                + df00.format(ubezpieczenieRentowe));
        System.out.println("Składka na ubezpieczenie chorobowe  "
                + df00.format(ubezpieczenieChorobowe));
        System.out
                .println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
                        + podstawaSkladkiNaUbezZdrow);
        obliczSkladkiZdrowotne(podstawaSkladkiNaUbezZdrow);
        System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
                + df00.format(skladkaZdrowZUS) + " 7,75% = " + df00.format(skladkaZdrowPomniejszajaca));
        System.out.println("Koszty uzyskania przychodu w stałej wysokości "
                + kosztyUzyskaniaPrzychodu);
        podstawaOpodatkowania = podstawaSkladkiNaUbezZdrow - kosztyUzyskaniaPrzychodu;
        podstawaOpodatkowaniaZaokr = Double
                .parseDouble(df.format(podstawaOpodatkowania));
        System.out.println("Podstawa opodatkowania " + podstawaOpodatkowania
                + " zaokrąglona " + df.format(podstawaOpodatkowaniaZaokr));
        obliczZaliczkePodDoch(podstawaOpodatkowaniaZaokr);
        System.out.println("Zaliczka na podatek dochodowy 18 % = "
                + zaliczkaPodatekDochodowy);
        System.out.println("Kwota wolna od podatku = " + kwotaWolnaOdPodatku);
        podatekPotracony = zaliczkaPodatekDochodowy - kwotaWolnaOdPodatku;
        System.out.println("Podatek potrącony = "
                + df00.format(podatekPotracony));
        obliczZaliczke();
        zaliczkaUrzadSkarbowyZaokr = Double.parseDouble(df.format(zaliczkaUrzadSkarbowy));
        System.out.println("Zaliczka do urzędu skarbowego = "
                + df00.format(zaliczkaUrzadSkarbowy) + " po zaokrągleniu = "
                + df.format(zaliczkaUrzadSkarbowyZaokr));
        wynagrodzenie = kwotaDochodu
                - ((ubezpieczenieEmerytalne + ubezpieczenieRentowe + ubezpieczenieChorobowe) + skladkaZdrowZUS + zaliczkaUrzadSkarbowyZaokr);
        System.out.println();
        System.out
                .println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
                        + df00.format(wynagrodzenie));
    }

}
