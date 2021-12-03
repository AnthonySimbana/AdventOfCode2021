package DayThree_PartTwo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Anthony Simbaña
 */
public class MainDayThree {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        //Definition of variables
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        String line;
        ArrayList<String> listNumTotal = new ArrayList();

        String oxygen = "";
        String carbon = "";

        //While to loop through all the numbers in the file, Copy the data to an ArrayList
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            listNumTotal.add(line);
        }

        //Gets the binary string for oxygen
        oxygen = getOlder(listNumTotal, 0).get(0);
        //Gets the binary chain for carbon
        carbon = getLower(listNumTotal, 0).get(0);

        //Convert binary to decimal
        int numOxygen = MainDayThree.getOlder(oxygen);
        int numCarbon = MainDayThree.getOlder(carbon);

        //Print the results
        System.out.println("Oxygen binary: " + oxygen + " carbon binary: " + carbon);
        System.out.println("Oxygen decimal: " + numOxygen + " carbon decimal: " + numCarbon);
        System.out.println("mult: " + numOxygen * numCarbon);

    }

    /**
     * Convert binary to decimal
     *
     * @param number binary string
     * @return int decimal
     */
    public static int getOlder(String number) {

        int exponent = 0;
        int decimal = 0;
        for (int i = 11; i >= 0; i--) {
            if (number.charAt(i) == '1') {
                decimal += Math.pow(2, exponent);
                exponent++;
            } else {
                exponent++;
            }
        }
        return decimal;
    }

    /**
     * Recursive method that generates smaller lists with the number of zeros or
     * ones that are more in each of the columns.
     *
     * @param listNumSobrantes List with all the binary numbers to analyze
     * @param pos Allows you to advance the position of the binary number by 1
     * from left to right.
     * @return ArraysList with one element
     */
    public static ArrayList<String> getOlder(ArrayList<String> listNumSobrantes, int pos) {
        /**
         * Auxiliary lists that store the binaries that contain ones or zeros
         * depending on the position analyzed
         */
        ArrayList<String> listNumAuxUnos = new ArrayList();
        ArrayList<String> listNumAuxCeros = new ArrayList();

        /**
         * Store data in smaller lists
         */
        for (String num : listNumSobrantes) {
                if (num.charAt(pos) == '0') {
                listNumAuxCeros.add(num);
            } else {
                listNumAuxUnos.add(num);
            }
        }

        // According to the larger size of the sublists, call the method again
        if (listNumAuxUnos.size() > listNumAuxCeros.size()) {
            pos++;
            return getOlder(listNumAuxUnos, pos);
        }
        if (listNumAuxUnos.size() < listNumAuxCeros.size()) {
            pos++;
            return getOlder(listNumAuxCeros, pos);
        }

        //Last requested value
        if ((listNumAuxUnos.size() == 1)) {
            return listNumAuxUnos;
        }
        return listNumSobrantes;
    }

    /**
     * Recursive method that generates smaller lists with the number of zeros or
     * ones that are fewer in each of the columns.
     *
     * @param listNumSobrantes List with all the binary numbers to analyze
     * @param pos Allows you to advance the position of the binary number by 1
     * from left to right.
     * @return ArraysList with one element
     */
    public static ArrayList<String> getLower(ArrayList<String> listNumSobrantes, int pos) {
        /**
         * Auxiliary lists that store the binaries that contain ones or zeros
         * depending on the position analyzed
         */
        ArrayList<String> listNumAuxUnos = new ArrayList();
        ArrayList<String> listNumAuxCeros = new ArrayList();

        /**
         * Store data in smaller lists
         */
        for (String num : listNumSobrantes) {
            if (num.charAt(pos) == '0') {
                listNumAuxCeros.add(num);
            } else {
                listNumAuxUnos.add(num);
            }
        }
        // According to the lower size of the sublists, call the method again

        if (listNumAuxUnos.size() < listNumAuxCeros.size()) {
            pos++;
            return getLower(listNumAuxUnos, pos);
        }

        if (listNumAuxUnos.size() > listNumAuxCeros.size()) {
            pos++;
            return getLower(listNumAuxCeros, pos);
        }
        
        //Last requested value
        if ((listNumAuxCeros.size() == 1)) {
            return listNumAuxCeros;
        }
        return listNumSobrantes;
    }
}
