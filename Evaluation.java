package com.example;

public enum Evaluation {
    InvalidInput,
    Draw, // valid board, but the game hasn't been won by either player yet 
    X_wins, // valid board, and the game was won by player X 
    O_wins, // valid board, and the game was won by player O 
    UnreachableState // string describes a board, but not a board state that is reachable from a valid game 
}
