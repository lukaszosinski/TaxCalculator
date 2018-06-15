package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.input.Input;
import com.bartoszwalter.students.taxes.output.Output;
import com.bartoszwalter.students.taxes.output.OutputConsole;
import com.bartoszwalter.students.taxes.output.ValueType;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

abstract class UmowaAbstract implements Umowa {

    private Input input;
    private Output output;

    double kwotaDochodu;




    UmowaAbstract() {
        this.output = new OutputConsole();
    }




    public void loadInputData() throws IOException {
        this.input.loadInput();
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

    void sendOutput(String message){
        this.output.sendOutput(message);
    }


    void sendOutput(ValueType valueType, double value){
        value = round2decimal(value);
        this.output.sendOutput(valueType, value);
    }

    double round2decimal(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


    public double obliczWynagrodzenie() {

        double wynagrodzenie;
        printDescription();
        sendOutput(ValueType.kwotaDochodu, kwotaDochodu);


        double sumaUbezpieczen = obliczUbezpieczeniaSpoleczne(kwotaDochodu);
        double podstawaSkladkiNaUbezZdrow = obliczPodstaweSkladkiNaUbezZdrow(sumaUbezpieczen);
        double skladkaZdrowPomniejszajaca = obliczSkladkaZdrowPomniejszajaca(podstawaSkladkiNaUbezZdrow);
        double skladkaZdrowZUS = obliczSkladkaZdrowZUS(podstawaSkladkiNaUbezZdrow);
        double kosztyUzyskaniaPrzychodu = obliczKosztyUzyskaniaPrzychodu(podstawaSkladkiNaUbezZdrow);
        double podstawaOpodatkowaniaZaokr = obliczPodstawaOpodatkowaniaZaokr(podstawaSkladkiNaUbezZdrow, kosztyUzyskaniaPrzychodu);
        double zaliczkaPodatekDochodowy = obliczZaliczkePodDoch(podstawaOpodatkowaniaZaokr);
        double podatekPotracony = obliczPodatekPotracony(zaliczkaPodatekDochodowy);
        double zaliczkaUrzadSkarbowyZaokr = obliczZaliczkaUrzadSkarbowyZaokr(podatekPotracony, skladkaZdrowPomniejszajaca);
        wynagrodzenie = kwotaDochodu - (sumaUbezpieczen + skladkaZdrowZUS + zaliczkaUrzadSkarbowyZaokr);
        wynagrodzenie = round2decimal(wynagrodzenie);
        sendOutput(ValueType.wynagrodzenie, wynagrodzenie);
        return wynagrodzenie;


    }

    abstract void printDescription();
    abstract double obliczKosztyUzyskaniaPrzychodu(double podstawaSkladkiNaUbezZdrow);




    double obliczPodstaweSkladkiNaUbezZdrow(double sumaUbezpieczen){
        double podstawaSkladkiNaUbezZdrow;
        podstawaSkladkiNaUbezZdrow = kwotaDochodu - sumaUbezpieczen;
        sendOutput(ValueType.podstawaSkladkiNaUbezZdrow, podstawaSkladkiNaUbezZdrow);
        return podstawaSkladkiNaUbezZdrow;
    }

    double obliczUbezpieczeniaSpoleczne(double kwotaDochodu) {
        double suma;
        double ubezpieczenieEmerytalne = obliczUbezpieczenieEmerytalne(kwotaDochodu);
        double ubezpieczenieRentowe = obliczUbezpieczenieRentowe(kwotaDochodu);
        double ubezpieczenieChorobowe = obliczUbezpieczenieChorobowe(kwotaDochodu);
        suma = ubezpieczenieEmerytalne + ubezpieczenieRentowe + ubezpieczenieChorobowe;
        return suma;
    }


    private double obliczUbezpieczenieEmerytalne(double kwotaDochodu){
        double procentUbezpieczenieEmerytalne = 9.76 / 100;
        double ubezpieczenieEmerytalne = kwotaDochodu * procentUbezpieczenieEmerytalne;
        sendOutput(ValueType.ubezpieczenieEmerytalne, ubezpieczenieEmerytalne);
        return ubezpieczenieEmerytalne;

    }

    private double obliczUbezpieczenieRentowe(double kwotaDochodu){
        double procentUbezpieczenieRentowe = 1.5 / 100;
        double ubezpieczenieRentowe = kwotaDochodu * procentUbezpieczenieRentowe;
        sendOutput(ValueType.ubezpieczenieRentowe, ubezpieczenieRentowe);
        return ubezpieczenieRentowe;
    }

    private double obliczUbezpieczenieChorobowe(double kwotaDochodu){
        double procentUbezpieczenieChorobowe = 2.45 / 100;
        double ubezpieczenieChorobowe = kwotaDochodu * procentUbezpieczenieChorobowe;
        sendOutput(ValueType.ubezpieczenieChorobowe, ubezpieczenieChorobowe);
        return ubezpieczenieChorobowe;
    }







    double obliczSkladkaZdrowZUS(double podstawaSkladkiNaUbezZdrow){
        double skladkaZdrowZUS;
        double procentSkladkaZdrowZUS = 9.d / 100;
        skladkaZdrowZUS = podstawaSkladkiNaUbezZdrow * procentSkladkaZdrowZUS;
        sendOutput(ValueType.skladkaZdrowPomniejszajaca, skladkaZdrowZUS);
        return skladkaZdrowZUS;
    }

    double obliczSkladkaZdrowPomniejszajaca(double podstawaSkladkiNaUbezZdrow){
        double skladkaZdrowPomniejszajaca;
        double procentSkladkaZdrowPomniejszajaca = 7.75d / 100;
        skladkaZdrowPomniejszajaca = podstawaSkladkiNaUbezZdrow * procentSkladkaZdrowPomniejszajaca;
        sendOutput(ValueType.skladkaZdrowPomniejszajaca, skladkaZdrowPomniejszajaca);
        return skladkaZdrowPomniejszajaca;
    }







    double obliczZaliczkaUrzadSkarbowyZaokr(double podatekPotracony, double skladkaZdrowPomniejszajaca) {
        double zaliczkaUrzadSkarbowy = podatekPotracony - skladkaZdrowPomniejszajaca;
        sendOutput(ValueType.zaliczkaUrzadSkarbowy, zaliczkaUrzadSkarbowy);
        double zaliczkaUrzadSkarbowyZaokr = Math.round(zaliczkaUrzadSkarbowy);
        sendOutput(ValueType.zaliczkaUrzadSkarbowyZaokr, zaliczkaUrzadSkarbowyZaokr);
        return zaliczkaUrzadSkarbowyZaokr;
    }

    abstract double obliczPodatekPotracony(double zaliczkaPodatekDochodowy);

    double obliczZaliczkePodDoch(double podstawaOpodatkowaniaZaokr) {
        double procentZaliczkaPodDoch = 18.d / 100;
        double zaliczkaPodatekDochodowy = podstawaOpodatkowaniaZaokr * procentZaliczkaPodDoch;
        sendOutput(ValueType.zaliczkaPodatekDochodowy, zaliczkaPodatekDochodowy);
        return zaliczkaPodatekDochodowy;
    }



    double obliczPodstawaOpodatkowaniaZaokr(double podstawaSkladkiNaUbezZdrow, double kosztyUzyskaniaPrzychodu){
        double podstawaOpodatkowania = podstawaSkladkiNaUbezZdrow - kosztyUzyskaniaPrzychodu;
        sendOutput(ValueType.podstawaOpodatkowania, podstawaOpodatkowania);
        double podstawaOpodatkowaniaZaokr = Math.round(podstawaOpodatkowania);
        sendOutput(ValueType.podstawaOpodatkowaniaZaokr, podstawaOpodatkowaniaZaokr);
        return podstawaOpodatkowaniaZaokr;
    }




}
