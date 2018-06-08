package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UmowaZlecenieTest {


    private UmowaZlecenie umowaZlecenie;
    private double kwotaDochodu;
    private Input input;

    @BeforeEach
    void init(){


    }

    private void mockInputAndCalculate(){
        this.input = mock(Input.class);
        when(input.getKwotaDochodu()).thenReturn(this.kwotaDochodu);
        this.umowaZlecenie = new UmowaZlecenie();
        this.umowaZlecenie.setInput(input);
        this.umowaZlecenie.oblicz();
    }


    @Test
    void umowaZlecenieTest(){
        this.kwotaDochodu = 2000;
        this.mockInputAndCalculate();
        assertEquals(2000, this.umowaZlecenie.kwotaDochodu, 0.01);
        assertEquals(195.2, this.umowaZlecenie.ubezpieczenieEmerytalne, 0.01);
        assertEquals(30, this.umowaZlecenie.ubezpieczenieRentowe, 0.01);
        assertEquals(49, this.umowaZlecenie.ubezpieczenieChorobowe, 0.01);
        assertEquals(1725.8, this.umowaZlecenie.podstawaSkladkiNaUbezZdrow, 0.01);
//        this.umowaZlecenie.obliczUbezpieczenia(this.umowaZlecenie.podstawaSkladkiNaUbezZdrow);
        assertEquals(155.32, this.umowaZlecenie.skladkaZdrowZUS, 0.01);
        assertEquals(133.75, this.umowaZlecenie.skladkaZdrowPomniejszajaca, 0.01);
        assertEquals(345.16, this.umowaZlecenie.kosztyUzyskaniaPrzychodu , 0.01);
        assertEquals(1380.6399999999999, this.umowaZlecenie.podstawaOpodatkowania, 0.01);
        assertEquals(1381, this.umowaZlecenie.podstawaOpodatkowaniaZaokr );
//        this.umowaZlecenie.obliczZaliczkePodDoch(this.umowaZlecenie.podstawaOpodatkowaniaZaokr)
        assertEquals(248.58, this.umowaZlecenie.zaliczkaPodatekDochodowy, 0.01);
        assertEquals(248.58, this.umowaZlecenie.podatekPotracony , 0.01);
        assertEquals(114.83, this.umowaZlecenie.zaliczkaUrzadSkarbowy, 0.01);
        assertEquals(115, this.umowaZlecenie.zaliczkaUrzadSkarbowyZaokr);
        assertEquals(1455.48, this.umowaZlecenie.wynagrodzenie, 0.01);
    }

    @Test
    void umowaZlecenieTest2(){
        this.kwotaDochodu = 9998.99;
        this.mockInputAndCalculate();
        assertEquals(9998.99, this.umowaZlecenie.kwotaDochodu, 0.01);
        assertEquals(975.9, this.umowaZlecenie.ubezpieczenieEmerytalne, 0.01);
        assertEquals(149.98, this.umowaZlecenie.ubezpieczenieRentowe, 0.01);
        assertEquals(244.98, this.umowaZlecenie.ubezpieczenieChorobowe, 0.01);
        assertEquals(8628.128471, this.umowaZlecenie.podstawaSkladkiNaUbezZdrow, 0.01);
//        this.umowaZlecenie.obliczUbezpieczenia(this.umowaZlecenie.podstawaSkladkiNaUbezZdrow);
        assertEquals(776.53, this.umowaZlecenie.skladkaZdrowZUS, 0.01);
        assertEquals(668.68, this.umowaZlecenie.skladkaZdrowPomniejszajaca, 0.01);
        assertEquals(1725.6256942000002, this.umowaZlecenie.kosztyUzyskaniaPrzychodu , 0.01);
        assertEquals(6902.5027768, this.umowaZlecenie.podstawaOpodatkowania, 0.01);
        assertEquals(6903, this.umowaZlecenie.podstawaOpodatkowaniaZaokr);
//        this.umowaZlecenie.obliczZaliczkePodDoch(this.umowaZlecenie.podstawaOpodatkowaniaZaokr)
        assertEquals(1242.53, this.umowaZlecenie.zaliczkaPodatekDochodowy, 0.01);
        assertEquals(1242.54, this.umowaZlecenie.podatekPotracony , 0.01);
        assertEquals(573.86, this.umowaZlecenie.zaliczkaUrzadSkarbowy, 0.01);
        assertEquals(574, this.umowaZlecenie.zaliczkaUrzadSkarbowyZaokr);
        assertEquals(7277.6, this.umowaZlecenie.wynagrodzenie, 0.01);
    }


}
