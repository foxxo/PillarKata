package com.kata;


import java.io.*;

public class WordSearchMain {



    public static void main(String[] args) {
        Puzzle myPuzzle;
        BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        do {
            try {
                System.out.print("Enter name of puzzle file, or enter q to quit: ");

                input = keyboardInput.readLine();

                if(input.equals("q") || input.equals("Q"))
                    break;

                myPuzzle = new Puzzle(new FileReader(input));

                myPuzzle.printPuzzle();

                System.out.println("Beginning puzzle solution...");

                myPuzzle.solvePuzzle();
                myPuzzle.printSolution();

            }catch (IOException inputError){System.out.println("Input Error: " + inputError.getMessage() + "\nPlease try again.");}
        }while(!input.equals("q") && !input.equals("Q"));

        System.out.println("Thank you for using KataSearch.");
    }

}
