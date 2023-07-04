/** Helper class that contains methods for frequently actions
  * performed by the TokTik class
  * @author Roche Witbooi
  * date 15 April 2023
  */
import java.util.Scanner;

public class TokTikHelper
{
      /** method reads in account username as a string, takes the first word and
        * converts it to an account
        * @param scanner object for reading in put
        * @return an account with the corressponding username
        */ 
      public static Account  accInputValid(Scanner input)
      {
         input.nextLine();
		   String readLine = input.nextLine();
         String[] readLineArr = readLine.split(" ");
         if(readLineArr.length == 0)
         {return new Account("-");}
         String accName = readLineArr[0]; 
         return new Account(accName); 
      }
      
       /** method reads in a second account username as a string, takes the first word and
        * converts it to an account
        * @param scanner object for reading in put
        * @return an account with the corressponding username of the second account
        */
      public static Account  secAccInputValid(Scanner input)
      {
		   String readLine = input.nextLine();
         String[] readLineArr = readLine.split(" ");
         String accName = readLineArr[0]; 
         return new Account(accName); 
      }
      
     /** method reads in a string and returns the first word entered in the string
       * @param scanner object for reading in put
       * @return String which is the first word of the String entered
       */
     public static String  strInputValid(Scanner input)
      {
         input.nextLine();
		   String readLine = input.nextLine();
         String[] readLineArr = readLine.split(" ");
 
         return readLineArr[0];
      }
      
     /** method reads in a string on the same line and returns the first word entered in the string
       * @param scanner object for reading in put
       * @return String which is the first word of the String entered
       */
     public static String  singStrInputValid(Scanner input)
      {
		   String readLine = input.nextLine();
         String[] readLineArr = readLine.split(" ");
 
         return readLineArr[0];
       }
       
     /** method reads in a stringand returns the entire line
       * @param scanner object for reading in put
       * @return String which is the entire line entered
       */ 
      public static String  lineInputValid(Scanner input)
      {
		   String readLine = input.nextLine();
         return readLine;
       }
  

}
