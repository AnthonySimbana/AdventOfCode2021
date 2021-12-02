package DayTwo_PartOne;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author Anthony Simbaña
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Definition of variables
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);
        String direccion = "";
        int amount = 0;
        int posHorizontal = 0;
        int depth = 0;

        //Reading each line
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            StringTokenizer token = new StringTokenizer(line, " ");
            
            //tokenize each line
            int contador = 0;
            while (token.hasMoreTokens()) {
                switch (contador) {
                    case 0:
                        direccion = token.nextToken();
                        System.out.print(direccion);
                        contador++;
                        break;
                    case 1:
                        amount = Integer.parseInt(token.nextToken());
                        System.out.println("  " + amount);
                        contador++;
                        break;
                    default:
                        break;
                }
            }
            //Instruction assignment
            switch (direccion) {
                case "forward":
                    posHorizontal += amount;
                    break;
                case "down":
                    depth += amount;
                    break;
                case "up":
                    depth += -amount;
                    break;
                default:
                    break;
            }
        }
            
        //Results display
        System.out.println("Multiply final horizontal position by final depth: " + posHorizontal * depth);
    }

}
