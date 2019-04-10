package com.kata;
import java.util.ArrayList;

public class WordSolution {
    String word;                            //the word to be found
    ArrayList<Coordinate> letterPositions;  //the coordinates of each letter in the puzzle grid
    boolean found;                          //whether the word has been found yet

    WordSolution(String myWord)
    {
        word = myWord;
        letterPositions = new ArrayList<Coordinate>();
        found = false;
    }

    boolean lookForNextCharacter(Coordinate position, Coordinate direction, int letterIndex, Puzzle puzzleToSearch)
    {
        //Recursively step through the grid in a given direction, stopping when we meet a non-matching letter or
        //edge of the grid. If we find the full word, return true and mark this WordSolution "solved."

        if (letterIndex == 0)               //Check whether this is the first letter
        {
            if (puzzleToSearch.grid[position.x][position.y] == word.charAt(letterIndex))
                letterPositions.add(position);
            else
                return false;
        }
        if (letterIndex == word.length()-1)
        {   //if we've found the last letter, the word is complete - return true.
            found = true;
            return true;
        }

        Coordinate nextPosition = new Coordinate(position.x - direction.x, position.y - direction.y);

        if(nextPosition.x < 0 || nextPosition.x >= puzzleToSearch.gridSize || nextPosition.y < 0 || nextPosition.y >= puzzleToSearch.gridSize)
        {   //if we've reached the boundary of the grid, fail
            letterPositions.clear();
            return false;
        }

        if (puzzleToSearch.grid[nextPosition.x][nextPosition.y] == word.charAt(letterIndex + 1))
        {   //if the next letter is a match, continue in this direction
            letterPositions.add(nextPosition);
            return lookForNextCharacter(nextPosition, direction, letterIndex + 1, puzzleToSearch);
        }
        else
        {   //if the next letter is not a match, fail
            letterPositions.clear();
            return false;
        }
    }
}
