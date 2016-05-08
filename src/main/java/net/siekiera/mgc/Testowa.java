package net.siekiera.mgc;

import net.siekiera.mgc.model.ElementWyposazenia;
import net.siekiera.mgc.model.Marka;
import net.siekiera.mgc.model.Samochod;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by eric on 03.05.2016.
 */
public class Testowa {
    public static void main(String[] args) {

    }

    /**
     * Każdy zwrócony string na liście odpowiada jednej linii tekstu w pliku.
     *
     * @param plik
     * @return
     */
    public static List<String> czytajPlik(String plik) {
        List<String> lista = new ArrayList<String>();
        try {
            Scanner input = new Scanner(System.in);
            File file = new File(plik);
            input = new Scanner(file);
            while (input.hasNextLine()) {
                lista.add(input.nextLine());
            }
            input.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
