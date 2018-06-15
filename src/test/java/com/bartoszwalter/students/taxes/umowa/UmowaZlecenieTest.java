package com.bartoszwalter.students.taxes.umowa;

import com.bartoszwalter.students.taxes.input.Input;
import com.bartoszwalter.students.taxes.output.Output;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UmowaZlecenieTest {


    private UmowaZlecenie umowaZlecenie;


    private void init(double kwotaDochodu){
        Input input = mock(Input.class);
        when(input.getKwotaDochodu()).thenReturn(kwotaDochodu);
        this.umowaZlecenie = new UmowaZlecenie();
        this.umowaZlecenie.setInput(input);
    }

    @Test
    void obliczSkladkaZdrowZUSTest(){
        this.init(2000);
        double podstawaSkladkiNaUbezZdrow = 1725.8d;
        double skladkaZdrowZUS = umowaZlecenie.obliczSkladkaZdrowZUS(podstawaSkladkiNaUbezZdrow);
        assertEquals(155.32, skladkaZdrowZUS, 0.01);
    }

    @Test
    void obliczSkladkaZdrowPomniejszajacaTest(){
        this.init(2000);
        double podstawaSkladkiNaUbezZdrow = 1725.8d;
        double skladkaZdrowPomniejszajaca = umowaZlecenie.obliczSkladkaZdrowPomniejszajaca(podstawaSkladkiNaUbezZdrow);
        assertEquals(133.75, skladkaZdrowPomniejszajaca, 0.01);
    }

    @Test
    void obliczPodstaweSkladkiNaUbezZdrowTest(){
        this.init(2000);
        double sumaUbezpieczen = 274.2;
        double skladkaZdrowPomniejszajaca = umowaZlecenie.obliczPodstaweSkladkiNaUbezZdrow(sumaUbezpieczen);
        assertEquals(1725.8, skladkaZdrowPomniejszajaca, 0.01);
    }


    @Test
    void obliczPodstawaOpodatkowaniaZaokrTest(){
        this.init(2000);
        double podstawaSkladki = 1725.8;
        double kosztyUzyskaniaPrzychodu = 345.16;
        double podstawaOpodatkowania = umowaZlecenie.obliczPodstawaOpodatkowaniaZaokr(podstawaSkladki,kosztyUzyskaniaPrzychodu);
        assertEquals(1381,podstawaOpodatkowania);

    }

    @Test
    void obliczZaliczkaPodDochTest(){
        this.init(2000);
        double podstawaOpodatkowania = 1381;
        double zaliczkaPodDoch = umowaZlecenie.obliczZaliczkePodDoch(podstawaOpodatkowania);
        assertEquals(248.58,zaliczkaPodDoch, 0.1);

    }

    @Test
    void obliczZaliczkaUrzadSkarbowyZaokrTest(){
        this.init(2000);
        double zaliczkaPodatekDochodowy = 248.58d;
        double skladkaZdrowPomniejszajaca = 133.75d;
        double zaliczkaUrzadSkarbowyZaokr = umowaZlecenie.obliczZaliczkaUrzadSkarbowyZaokr(zaliczkaPodatekDochodowy, skladkaZdrowPomniejszajaca);
        assertEquals(115,zaliczkaUrzadSkarbowyZaokr);

    }

    @Test
    void obliczWynagrodzenieTest(){
        this.init(2000);
        double wynagrodzenie = umowaZlecenie.obliczWynagrodzenie();
        assertEquals(1455.48, wynagrodzenie);
    }

}
