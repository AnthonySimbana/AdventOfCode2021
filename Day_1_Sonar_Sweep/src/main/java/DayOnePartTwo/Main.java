package DayOnePartTwo;
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
        Scanner read = new Scanner(file);                     
        Scanner sc = new Scanner(file); 
        int rowsnumber=0;
        int position=0;
        int previous, later,accountant =0;

        //Count the number of elements in the file
        while (read.hasNextLine()) {                          
           rowsnumber++;
           read.nextLine();
        }

        //Creating an int array
        int []numbers = new int [rowsnumber];
        
        //Filling the int array with the data from the .txt file
        while (sc.hasNextLine()) {                          
            numbers[position] = Integer.parseInt(sc.nextLine());
            position++;
        }
        
        //Comparison of new windows
        for (int j=0; j<numbers.length-3 ; j++){
            previous = numbers[j] +numbers[j+1] +numbers[j+2] ;
            later = numbers[j+1] +numbers[j+2] +numbers[j+3] ;
            if(later>previous){
                accountant++;  
                System.out.println(previous + " < " + later );
            }
        }
        
        //Printing of results
        System.out.println("Sums are greater than the previous sum: "+ accountant);
    }

}
