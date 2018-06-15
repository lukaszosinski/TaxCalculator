package com.bartoszwalter.students.taxes.input;

import com.bartoszwalter.students.taxes.umowa.Umowa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputConsole implements Input {

    private double kwotaDochodu;
    private Umowa.RodzajUmowy rodzajUmowy;

    private InputStreamReader isr = new InputStreamReader(System.in);
    private BufferedReader br = new BufferedReader(isr);

    public InputConsole() throws IOException{
        loadInput();
        isr.close();
        br.close();

    }

    @Override
    public double getKwotaDochodu() {
        return kwotaDochodu;
    }

    @Override
    public Umowa.RodzajUmowy getRodzajUmowy() {
        return rodzajUmowy;
    }

    @Override
    public void loadInput() throws IOException{
        loadKwotaDochodu(isr, br);
        loadRodzajUmowy(isr, br);

    }

    private void loadKwotaDochodu(InputStreamReader isr, BufferedReader br) throws IOException{

        System.out.print("Podaj kwotę dochodu: ");
        try {
            this.kwotaDochodu = Double.parseDouble(br.readLine());
        } catch (NumberFormatException e) {
            throw new IOException("Kwoa dochotu musi byc liczba");
        }

    }

    private void loadRodzajUmowy(InputStreamReader isr, BufferedReader br) throws IOException{

        System.out.print("Typ umowy: (P)raca, (Z)lecenie: ");
        char firstChar = br.readLine().charAt(0);
        switch(firstChar){
            case 'P':
                this.rodzajUmowy = Umowa.RodzajUmowy.PRACA;
                break;
            case 'Z':
                this.rodzajUmowy = Umowa.RodzajUmowy.ZLECENIE;
                break;
            default:
                throw new IOException("Podano niepoprawny rodzaj umowy");
        }


    }
}
