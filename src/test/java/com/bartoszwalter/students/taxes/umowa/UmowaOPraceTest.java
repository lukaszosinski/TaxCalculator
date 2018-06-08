package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UmowaOPraceTest {


    private UmowaOPrace umowaOPrace;
    private double kwotaDochodu;
    private Input input;

    @BeforeEach
    void init(){


    }

    private void mockInputAndCalculate(){
        this.input = mock(Input.class);
        when(input.getKwotaDochodu()).thenReturn(this.kwotaDochodu);
        this.umowaOPrace = new UmowaOPrace();
        this.umowaOPrace.setInput(input);
        this.umowaOPrace.oblicz();
    }


    @Test
    void umowaOPraceTest(){
        this.kwotaDochodu = 2000;
        this.mockInputAndCalculate();
        assertEquals(2000, this.umowaOPrace.kwotaDochodu, 0.01);
        assertEquals(195.2, this.umowaOPrace.ubezpieczenieEmerytalne, 0.01);
        assertEquals(30, this.umowaOPrace.ubezpieczenieRentowe, 0.01);
        assertEquals(49, this.umowaOPrace.ubezpieczenieChorobowe, 0.01);
        assertEquals(1725.8, this.umowaOPrace.podstawaSkladkiNaUbezZdrow, 0.01);
//        this.umowaOPrace.obliczUbezpieczenia(this.umowaOPrace.podstawaSkladkiNaUbezZdrow);
        assertEquals(155.32, this.umowaOPrace.skladkaZdrowZUS, 0.01);
        assertEquals(133.75, this.umowaOPrace.skladkaZdrowPomniejszajaca, 0.01);
        assertEquals(111.25, this.umowaOPrace.kosztyUzyskaniaPrzychodu , 0.01);
        assertEquals(1614.55, this.umowaOPrace.podstawaOpodatkowania, 0.01);
        assertEquals(1615, this.umowaOPrace.podstawaOpodatkowaniaZaokr );
//        this.umowaOPrace.obliczZaliczkePodDoch(this.umowaOPrace.podstawaOpodatkowaniaZaokr)
        assertEquals(290.7, this.umowaOPrace.zaliczkaPodatekDochodowy, 0.01);
        assertEquals(46.33, this.umowaOPrace.kwotaWolnaOdPodatku, 0.01);
        assertEquals(244.37, this.umowaOPrace.podatekPotracony , 0.01);
        assertEquals(110.62, this.umowaOPrace.zaliczkaUrzadSkarbowy, 0.01);
        assertEquals(111, this.umowaOPrace.zaliczkaUrzadSkarbowyZaokr);
        assertEquals(1459.48, this.umowaOPrace.wynagrodzenie, 0.01);
    }

    @Test
    void umowaOPraceTest2(){
        this.kwotaDochodu = 9998.99;
        this.mockInputAndCalculate();
        assertEquals(9998.99, this.umowaOPrace.kwotaDochodu, 0.01);
        assertEquals(975.9, this.umowaOPrace.ubezpieczenieEmerytalne, 0.01);
        assertEquals(149.98, this.umowaOPrace.ubezpieczenieRentowe, 0.01);
        assertEquals(244.98, this.umowaOPrace.ubezpieczenieChorobowe, 0.01);
        assertEquals(8628.128471, this.umowaOPrace.podstawaSkladkiNaUbezZdrow, 0.01);
//        this.umowaOPrace.obliczUbezpieczenia(this.umowaOPrace.podstawaSkladkiNaUbezZdrow);
        assertEquals(776.53, this.umowaOPrace.skladkaZdrowZUS, 0.01);
        assertEquals(668.68, this.umowaOPrace.skladkaZdrowPomniejszajaca, 0.01);
        assertEquals(111.25, this.umowaOPrace.kosztyUzyskaniaPrzychodu , 0.01);
        assertEquals(8516.878471, this.umowaOPrace.podstawaOpodatkowania, 0.01);
        assertEquals(8517, this.umowaOPrace.podstawaOpodatkowaniaZaokr );
//        this.umowaOPrace.obliczZaliczkePodDoch(this.umowaOPrace.podstawaOpodatkowaniaZaokr)
        assertEquals(1533.06, this.umowaOPrace.zaliczkaPodatekDochodowy, 0.01);
        assertEquals(46.33, this.umowaOPrace.kwotaWolnaOdPodatku, 0.01);
        assertEquals(1486.73, this.umowaOPrace.podatekPotracony , 0.01);
        assertEquals(818.05, this.umowaOPrace.zaliczkaUrzadSkarbowy, 0.01);
        assertEquals(818, this.umowaOPrace.zaliczkaUrzadSkarbowyZaokr);
        assertEquals(7033.6, this.umowaOPrace.wynagrodzenie, 0.01);
    }

}
