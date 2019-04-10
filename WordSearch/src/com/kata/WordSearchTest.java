package com.kata;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordSearchTest {

    @Test public void LookingForWordHorizontallyReturnsFalseIfNotPresent()
    {

        Puzzle testPuzzle = new Puzzle(new char[][]{
                {'T','E','S','D'},
                {'E','E','S','T'},
                {'S','J','S','L'},
                {'T','S','E','T'}},
                new String[]{"TEST"});

        assertFalse(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(0,0), Puzzle.EAST, 0, testPuzzle));
        assertFalse(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(1,0), Puzzle.EAST, 0, testPuzzle));
        assertFalse( testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(2,0), Puzzle.EAST, 0, testPuzzle));
        assertFalse( testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(3,0), Puzzle.EAST, 0, testPuzzle));
    }

    @Test
    public void LookingForWordHorizontallyReturnsTrueIfPresent()
    {
        Puzzle testPuzzle = new Puzzle(new char[][]{
                {'T','E','S','T'},
                {'E','F','G','H'},
                {'I','J','K','L'},
                {'M','N','O','P'}},
                new String[]{"TEST"});

        assertTrue(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(0,0), Puzzle.EAST, 0, testPuzzle));

    }

    @Test
    public void LookingForWordHorizontallyBackwardsReturnsTrueIfPresent()
    {
        Puzzle testPuzzle = new Puzzle(new char[][]{
                {'A','B','C','D'},
                {'E','F','G','H'},
                {'I','J','K','L'},
                {'T','S','E','T'}},
                new String[]{"TEST"});

        assertTrue(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(3,3), Puzzle.WEST, 0, testPuzzle));
    }

    @Test public void LookingForWordVerticallyReturnsTrueIfPresent()
    {
        Puzzle testPuzzle = new Puzzle(new char[][]{
                {'A','T','C','D'},
                {'E','E','G','H'},
                {'I','S','K','L'},
                {'M','T','O','P'}},
                new String[]{"TEST"});

        assertTrue(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(0,1), Puzzle.SOUTH, 0, testPuzzle));
    }

    @Test public void LookingForWordVerticallyBackwardsReturnsTrueIfPresent()
    {
        Puzzle testPuzzle = new Puzzle(new char[][]{
                {'T','B','C','D'},
                {'S','F','G','H'},
                {'E','J','K','L'},
                {'T','N','O','P'}},
                new String[]{"TEST"});

        assertTrue(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(3,0), Puzzle.NORTH, 0, testPuzzle));
    }

    @Test public void LookingForWordDiagonallyDownReturnsTrueIfPresent()
    {
        Puzzle testPuzzle = new Puzzle(new char[][]{
                {'T','B','C','D'},
                {'E','E','G','H'},
                {'I','J','S','L'},
                {'M','N','O','T'}},
                new String[]{"TEST"});

        assertTrue(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(0,0), Puzzle.SOUTHEAST, 0, testPuzzle));
    }

    @Test public void LookingForWordDiagonallyDownBackwardsReturnsTrueIfPresent()
    {
        Puzzle testPuzzle = new Puzzle(new char[][]{
                {'T','B','C','D'},
                {'E','S','G','H'},
                {'I','J','E','L'},
                {'M','N','O','T'}},
                new String[]{"TEST"});

        assertTrue(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(3,3), Puzzle.NORTHWEST, 0, testPuzzle));
    }

    @Test public void LookingForWordDiagonallyUpReturnsTrueIfPresent()
    {
        Puzzle testPuzzle = new Puzzle(new char[][]{
                {'A','B','C','T'},
                {'E','F','S','H'},
                {'I','E','K','L'},
                {'T','N','O','P'}},
                new String[]{"TEST"});

        assertTrue(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(3,0), Puzzle.NORTHEAST, 0, testPuzzle));
    }

    @Test public void LookingForWordDiagonallyUpBackwardsReturnsTrueIfPresent()
    {
        Puzzle testPuzzle = new Puzzle(new char[][]{
                {'A','B','C','T'},
                {'E','F','E','H'},
                {'I','S','K','L'},
                {'T','N','O','P'}},
                new String[]{"TEST"});

        assertTrue(testPuzzle.solutions.get(0).lookForNextCharacter(new Coordinate(0,3), Puzzle.SOUTHWEST, 0, testPuzzle));
    }
}
