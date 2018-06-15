package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.input.Input;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UmowaOPraceTest {


    private UmowaOPrace umowaOPrace;


    private void init(double kwotaDochodu){
        Input input = mock(Input.class);
        when(input.getKwotaDochodu()).thenReturn(kwotaDochodu);
        this.umowaOPrace = new UmowaOPrace();
        this.umowaOPrace.setInput(input);
    }

    @Test
    void obliczSkladkaZdrowZUSTest(){
        this.init(2000);
        double podstawaSkladkiNaUbezZdrow = 1725.8d;
        double skladkaZdrowZUS = umowaOPrace.obliczSkladkaZdrowZUS(podstawaSkladkiNaUbezZdrow);
        assertEquals(155.32, skladkaZdrowZUS, 0.01);
    }

    @Test
    void obliczSkladkaZdrowPomniejszajacaTest(){
        this.init(2000);
        double podstawaSkladkiNaUbezZdrow = 1725.8d;
        double skladkaZdrowPomniejszajaca = umowaOPrace.obliczSkladkaZdrowPomniejszajaca(podstawaSkladkiNaUbezZdrow);
        assertEquals(133.75, skladkaZdrowPomniejszajaca, 0.01);
    }

    @Test
    void obliczPodstaweSkladkiNaUbezZdrowTest(){
        this.init(2000);
        double sumaUbezpieczen = 274.2;
        double skladkaZdrowPomniejszajaca = umowaOPrace.obliczPodstaweSkladkiNaUbezZdrow(sumaUbezpieczen);
        assertEquals(1725.8, skladkaZdrowPomniejszajaca, 0.01);
    }


    @Test
    void obliczPodstawaOpodatkowaniaZaokrTest(){
        this.init(2000);
        double podstawaSkladki = 1725.8;
        double kosztyUzyskaniaPrzychodu = 111.25;
        double podstawaOpodatkowania = umowaOPrace.obliczPodstawaOpodatkowaniaZaokr(podstawaSkladki,kosztyUzyskaniaPrzychodu);
        assertEquals(1615, podstawaOpodatkowania);

    }

    @Test
    void obliczZaliczkaPodDochTest(){
        this.init(2000);
        double podstawaOpodatkowania = 1614.55;
        double zaliczkaPodDoch = umowaOPrace.obliczZaliczkePodDoch(podstawaOpodatkowania);
        assertEquals(290.7,zaliczkaPodDoch, 0.1);

    }

    @Test
    void obliczZaliczkaUrzadSkarbowyZaokrTest(){
        this.init(2000);
        double podatekPotracony = 244.37;
        double skladkaZdrowPomniejszajaca = 133.75d;
        double zaliczkaUrzadSkarbowyZaokr = umowaOPrace.obliczZaliczkaUrzadSkarbowyZaokr(podatekPotracony, skladkaZdrowPomniejszajaca);
        assertEquals(111, zaliczkaUrzadSkarbowyZaokr);

    }

    @Test
    void obliczWynagrodzenieTest(){
        this.init(2000);
        double wynagrodzenie = umowaOPrace.obliczWynagrodzenie();
        assertEquals(1459.48, wynagrodzenie);
    }



//    @Test
//    void umowaOPraceTest(){
//
//        this.mockInputAndCalculate();
//        assertEquals(2000, this.umowaOPrace.kwotaDochodu, 0.01);
//        assertEquals(195.2, this.umowaOPrace.ubezpieczenieEmerytalne, 0.01);
//        assertEquals(30, this.umowaOPrace.ubezpieczenieRentowe, 0.01);
//        assertEquals(49, this.umowaOPrace.ubezpieczenieChorobowe, 0.01);
//        assertEquals(1725.8, this.umowaOPrace.podstawaSkladkiNaUbezZdrow, 0.01);
////        this.umowaOPrace.obliczUbezpieczenia(this.umowaOPrace.podstawaSkladkiNaUbezZdrow);
//        assertEquals(155.32, this.umowaOPrace.skladkaZdrowZUS, 0.01);
//        assertEquals(133.75, this.umowaOPrace.skladkaZdrowPomniejszajaca, 0.01);
//        assertEquals(111.25, this.umowaOPrace.kosztyUzyskaniaPrzychodu , 0.01);
//        assertEquals(1614.55, this.umowaOPrace.podstawaOpodatkowania, 0.01);
//        assertEquals(1615, this.umowaOPrace.podstawaOpodatkowaniaZaokr );
////        this.umowaOPrace.obliczZaliczkePodDoch(this.umowaOPrace.podstawaOpodatkowaniaZaokr)
//        assertEquals(290.7, this.umowaOPrace.zaliczkaPodatekDochodowy, 0.01);
//        assertEquals(46.33, this.umowaOPrace.kwotaWolnaOdPodatku, 0.01);
//        assertEquals(244.37, this.umowaOPrace.podatekPotracony , 0.01);
//        assertEquals(110.62, this.umowaOPrace.zaliczkaUrzadSkarbowy, 0.01);
//        assertEquals(111, this.umowaOPrace.zaliczkaUrzadSkarbowyZaokr);
//        assertEquals(1459.48, this.umowaOPrace.wynagrodzenie, 0.01);
//    }
//
//    @Test
//    void umowaOPraceTest2(){
//        this.kwotaDochodu = 9998.99;
//        this.mockInputAndCalculate();
//        assertEquals(9998.99, this.umowaOPrace.kwotaDochodu, 0.01);
//        assertEquals(975.9, this.umowaOPrace.ubezpieczenieEmerytalne, 0.01);
//        assertEquals(149.98, this.umowaOPrace.ubezpieczenieRentowe, 0.01);
//        assertEquals(244.98, this.umowaOPrace.ubezpieczenieChorobowe, 0.01);
//        assertEquals(8628.128471, this.umowaOPrace.podstawaSkladkiNaUbezZdrow, 0.01);
////        this.umowaOPrace.obliczUbezpieczenia(this.umowaOPrace.podstawaSkladkiNaUbezZdrow);
//        assertEquals(776.53, this.umowaOPrace.skladkaZdrowZUS, 0.01);
//        assertEquals(668.68, this.umowaOPrace.skladkaZdrowPomniejszajaca, 0.01);
//        assertEquals(111.25, this.umowaOPrace.kosztyUzyskaniaPrzychodu , 0.01);
//        assertEquals(8516.878471, this.umowaOPrace.podstawaOpodatkowania, 0.01);
//        assertEquals(8517, this.umowaOPrace.podstawaOpodatkowaniaZaokr );
////        this.umowaOPrace.obliczZaliczkePodDoch(this.umowaOPrace.podstawaOpodatkowaniaZaokr)
//        assertEquals(1533.06, this.umowaOPrace.zaliczkaPodatekDochodowy, 0.01);
//        assertEquals(46.33, this.umowaOPrace.kwotaWolnaOdPodatku, 0.01);
//        assertEquals(1486.73, this.umowaOPrace.podatekPotracony , 0.01);
//        assertEquals(818.05, this.umowaOPrace.zaliczkaUrzadSkarbowy, 0.01);
//        assertEquals(818, this.umowaOPrace.zaliczkaUrzadSkarbowyZaokr);
//        assertEquals(7033.6, this.umowaOPrace.wynagrodzenie, 0.01);
//    }

}
