package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------");
        int[] gastos = {10, 20, 30, 40, 50};
        int d = 3;
        ArrayList<Integer> previousDays = new ArrayList<>();

        // valido el posible error al ingresar un 2 o menos. En la validacion de la media daría error
        if (d < 3){
            System.out.println("Ingresar un numero mayor a 2 para evitar errores de punteros en array");
        } else {
            for (int i = 0; i < gastos.length; i++) {
                if (i >= d) {
                    Integer[] MedianArray = previousDays.toArray(new Integer[0]);
                    Arrays.sort(MedianArray);
                    int half = d / 2;
                    double median;
                    if (d % 2 == 0) {
                        median = (double) (MedianArray[d / half - 1] + MedianArray[d / half]) / 2;
                    }  else {
                        median = MedianArray[d / 2];
                    }
//                    System.out.println("gasto = " + gastos[i]);
//                    System.out.println("median = " + 2 * median);
                    if (gastos[i] >= 2 * median){
                        System.out.println("Advertencia posible fraude en el dia " +(i+1));
                        System.out.println("Gastos: " + gastos[i] + " >= media: " +  (2 * median));
                    }
                    previousDays.remove(0);
                }
                previousDays.add(gastos[i]);
            }
        }
    }
}