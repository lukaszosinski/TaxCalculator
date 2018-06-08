package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.input.Input;
import com.bartoszwalter.students.taxes.output.Output;

import java.text.DecimalFormat;

abstract class UmowaAbstract implements Umowa {

    double kwotaDochodu;
    private Input input;
    private Output output;

    double ubezpieczenieEmerytalne;
    double ubezpieczenieRentowe;
    double ubezpieczenieChorobowe;
    double skladkaZdrowZUS;
    double skladkaZdrowPomniejszajaca;
    double zaliczkaPodatekDochodowy;
    double kwotaWolnaOdPodatku = 46.33;
    double zaliczkaUrzadSkarbowy;

    DecimalFormat df00 = new DecimalFormat("#.00");
    DecimalFormat df = new DecimalFormat("#");


    UmowaAbstract() {

    }

    public void setInput(Input input){
        this.input = input;
        setKwotaDochodu();
    }

    private void setKwotaDochodu(){
        this.kwotaDochodu = this.input.getKwotaDochodu();
    }



    public void setOutput(Output output){
        this.output = output;
    }

    void obliczZaliczke() {
        zaliczkaUrzadSkarbowy = zaliczkaPodatekDochodowy - skladkaZdrowPomniejszajaca - kwotaWolnaOdPodatku;
    }

    void obliczZaliczkePodDoch(double podstawaOpodatkowaniaZaokr) {
        double procentZaliczkaPodDoch = 18.d / 100;
        zaliczkaPodatekDochodowy = podstawaOpodatkowaniaZaokr * procentZaliczkaPodDoch;
    }


    double odliczUbezpieczeniaSpoleczne(double kwotaDochodu) {
        obliczUbezpieczenieEmerytalne();
        obliczUbezpieczenieRentowe();
        obliczUbezpieczenieChorobowe();
        return (kwotaDochodu - ubezpieczenieEmerytalne - ubezpieczenieRentowe - ubezpieczenieChorobowe);
    }

    private void obliczUbezpieczenieEmerytalne(){
        double procentUbezpieczenieEmerytalne = 9.76 / 100;
        ubezpieczenieEmerytalne = kwotaDochodu * procentUbezpieczenieEmerytalne;

    }

    private void obliczUbezpieczenieRentowe(){
        double procentUbezpieczenieRentowe = 1.5 / 100;

        ubezpieczenieRentowe = kwotaDochodu * procentUbezpieczenieRentowe;
    }

    private void obliczUbezpieczenieChorobowe(){
        double procentUbezpieczenieChorobowe = 2.45 / 100;
        ubezpieczenieChorobowe = kwotaDochodu * procentUbezpieczenieChorobowe;
    }

    void obliczSkladkiZdrowotne(double podstawa) {
        skladkaZdrowZUS = (podstawa * 9) / 100;
        skladkaZdrowPomniejszajaca = (podstawa * 7.75) / 100;
    }
}
