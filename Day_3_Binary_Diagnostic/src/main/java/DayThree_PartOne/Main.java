package DayThree_PartOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Anthony Simbaña
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Definition of variables
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        String line;
        String gamma = "";
        String alfa = "";
        
        //Creation of 2 arrays to contain the number of zeros and ones in each column.
        int[] numCero = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] numOne = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        //While to loop through all the numbers in the file
        while (sc.hasNextLine()) {
            line = sc.nextLine();
        //It adds the amounts of zeros and ones
            for (int j = 0; j < 12; j++) {
                char num = line.charAt(j);
                if (num == '0') {
                    numCero[j] += 1;
                } else {
                    numOne[j] += 1;
                }
            }
        }

        //Compare the arrays to construct the gamma and alpha number
        for (int k = 0; k < 12; k++) {
            if (numCero[k] > numOne[k]) {
                gamma += "0";
                alfa += "1";
            } else {
                gamma += "1";
                alfa += "0";
            }
        }

        //Converting from binary to decimal
        int numGamma = binaryTodecimal(gamma);
        int numAlfa = binaryTodecimal(alfa);
        
        //Printing of results
        System.out.println("gamma binario: " + gamma + "\talfa binario: " + alfa);
        System.out.println("gamma decimal: " + numGamma + "\talfa decimal: " + numAlfa);
        System.out.println("mult: " + numGamma * numAlfa);

    }

    /**
     * Converting from binary to decimal
     * @param numero binary string
     * @return int decimal
     */
    public static int binaryTodecimal(String numero) {

        int exponente = 0;
        int decimal = 0; 
        for (int i = 11; i >= 0; i--) {
            if (numero.charAt(i) == '1') {
                decimal += Math.pow(2, exponente);
                exponente++;

            } else {
                exponente++;
            }
        }
        return decimal;

    }
}
