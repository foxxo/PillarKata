package com.kata;

import java.io.*;
import java.util.ArrayList;

public class Puzzle
{
    char[][] grid;
    ArrayList<WordSolution> solutions;
    int gridSize;

    static final Coordinate NORTH = new Coordinate(1,0);
    static final Coordinate NORTHEAST = new Coordinate(1,-1);
    static final Coordinate NORTHWEST = new Coordinate(1,1);
    static final Coordinate SOUTH = new Coordinate(-1,0);
    static final Coordinate SOUTHEAST = new Coordinate(-1,-1);
    static final Coordinate SOUTHWEST = new Coordinate(-1,1);
    static final Coordinate EAST = new Coordinate(0,-1);
    static final Coordinate WEST = new Coordinate(0,1);

    Puzzle(char[][] inputGrid, String[] words)
    {
        grid = inputGrid;
        solutions = new ArrayList<WordSolution>();
        gridSize=grid.length;

        for(String s : words)
        {
            solutions.add(new WordSolution(s));
        }

    }

    Puzzle(FileReader sourceFile){
        readPuzzleFromFile(sourceFile);
    }

    public void readPuzzleFromFile(FileReader inputFile)  {
        try {
            solutions = new ArrayList<WordSolution>();

            BufferedReader readerFromFile = new BufferedReader(inputFile);


            for (String wordFromList : readerFromFile.readLine().split(",")) {

                solutions.add(new WordSolution(wordFromList));
            }

            gridSize = 0;
            String nextLine = readerFromFile.readLine();
            nextLine = nextLine.replaceAll(",", "");
            grid = new char[nextLine.length()][nextLine.length()];
            int currentLine = 0;
            do{
                nextLine = nextLine.replaceAll(",", "");

                grid[gridSize] = nextLine.toCharArray();
                gridSize++;
            }
            while((nextLine = readerFromFile.readLine()) != null);
        }
        catch(IOException inputError)
        {
            System.out.println(inputError.getMessage());
        }
    }

    public void solvePuzzle()
    {
        for(int x = 0; x < gridSize; x++)
            for(int y = 0; y < gridSize; y++)
            {
                Coordinate startingSearchPosition = new Coordinate(x,y);
                for(WordSolution s : solutions)
                {
                    if(!s.found && grid[x][y] == s.word.charAt(0))
                        if(!s.lookForNextCharacter(startingSearchPosition, NORTH, 0, this))
                            if(!s.lookForNextCharacter(startingSearchPosition, NORTHEAST, 0, this))
                                if(!s.lookForNextCharacter(startingSearchPosition, EAST, 0, this))
                                    if(!s.lookForNextCharacter(startingSearchPosition, SOUTHEAST, 0, this))
                                        if(!s.lookForNextCharacter(startingSearchPosition, SOUTH, 0, this))
                                            if(!s.lookForNextCharacter(startingSearchPosition, SOUTHWEST, 0, this))
                                                if(!s.lookForNextCharacter(startingSearchPosition, WEST, 0, this))
                                                    if(!s.lookForNextCharacter(startingSearchPosition, NORTHWEST, 0, this))
                                                    {

                                                    }
                }
            }
    }

    public void printSolution()
    {
        for(WordSolution s : solutions)
        {
            System.out.print(s.word + ": ");
            for(int i = 0; i < s.letterPositions.size(); i++)
            {
                //Coordinate system is rotated 90 degrees for output (x and y axes are swapped for internal representation)
                System.out.print("(" + s.letterPositions.get(i).y + "," + s.letterPositions.get(i).x + ")");
                if(i != s.letterPositions.size()-1)
                    System.out.print(", ");
                else
                    System.out.println();
            }
        }
    }

    public void printPuzzle()
    {

        for(WordSolution s : solutions)
        {
            System.out.print(s.word + " ");
        }
        System.out.println();

        for(int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                System.out.print(grid[x][y]);
            }
            System.out.println();
        }

    }
}
