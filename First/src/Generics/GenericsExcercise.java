package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsExcercise {
    public static void main(String[] args) {
        ArrayList<Object> varibles = new ArrayList<Object>();
        Double doubleNumber = 1.3;
        String name = "John";
        Integer intNumber = 1;
        char letter = 'a';

        varibles.add(doubleNumber);
        varibles.add(name);
        varibles.add(intNumber);
        varibles.add(letter);

        for (Object varible : varibles) {
            GenericsExcercise.displayClassName(varible);
        }
    }
        
        static <T> void displayClassName(T varible) {   // <T> is a generic type
            System.out.println(varible.getClass().getName());
        }
            
    }

// Output 
// java.lang.Double
// java.lang.String
// java.lang.Integer
// java.lang.Character


