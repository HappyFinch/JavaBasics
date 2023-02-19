package UserInput;

import java.util.Date;
import java.util.Scanner;

public class UserInputTester{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();   
            System.out.println("name:"+ name+"\ndate:"+new Date());
        } catch (Exception e){
            System.out.println("Error: " + e.getLocalizedMessage());
        } finally{
            scanner.close();
        }
    }
}