package DayOneParOne;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Anthony Simbaña
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        //Definition of variables
        File file = new File("Day one input.txt");               
        Scanner sc = new Scanner(file);                     
        String line = sc.nextLine();
        int previous, later,accountant =0;
        
        //Previous number assignment
        previous = Integer.parseInt(line);
        
        //While to loop through all the numbers in the file
        while (sc.hasNextLine()) {                          //Mientras existan líneas en el archivo realiza
            
            line = sc.nextLine();
            later = Integer.parseInt(line);
            
            //Comparison
            if(later>previous){
                accountant++;  
                System.out.println(previous + " < " + later );
            }
            //New previous
            previous = later;                    
        }
            
        //Printing of results
        System.out.println("Measurements are larger than the previous measurement: "+ accountant);
    }

}
