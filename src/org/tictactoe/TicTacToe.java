package org.tictactoe;

/**
 * TicTacToe Example
 * @author Adrian Iordache
 * @version 1.0
 */

public class TicTacToe {
    private final int X = 1, O = -1, EMPTY = 0;
    protected int[][] board = new int[3][3];
    private int currentPlayer;

    /**
     * Initialize the board and set the current player to X
     */
    public TicTacToe(){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                this.board[i][j] = EMPTY;
            }
        }
        this.currentPlayer = X;
    }

    /**
     * Put the mark in the according row and column
     * @param row The row position
     * @param column The column position
     * @throws IllegalArgumentException Thrown in case the position is outside of the board or if the position is already occupied
     */
    public void putMark(int row, int column) throws IllegalArgumentException{
        if ((row > 2 || row < 0) || (column > 2 || column < 0)) throw new IllegalArgumentException("You cannot mark outside of the board!");
        if (this.board[row][column] != EMPTY) throw new IllegalArgumentException("You cannot place a mark here. The cell is already occupied!");

        this.board[row][column] = currentPlayer;
        currentPlayer = -currentPlayer;
    }

    /**
     * Determine the winner
     * @param mark Player's mark
     * @return True if the board positions values equals to mark * 3
     */
    private boolean isWin(int mark){
        return this.board[0][0] + this.board[0][1] + this.board[0][2] == mark * 3 ||
               this.board[1][0] + this.board[1][1] + this.board[1][2] == mark * 3 ||
               this.board[2][0] + this.board[2][1] + this.board[2][2] == mark * 3 ||
               this.board[0][0] + this.board[1][0] + this.board[2][0] == mark * 3 ||
               this.board[0][1] + this.board[1][1] + this.board[2][1] == mark * 3 ||
               this.board[0][2] + this.board[1][2] + this.board[2][2] == mark * 3 ||
               this.board[0][0] + this.board[1][1] + this.board[2][2] == mark * 3 ||
               this.board[0][2] + this.board[1][1] + this.board[2][0] == mark * 3;
    }

    /**
     * Determine the winner
     * @return An int representing the winner of the game
     */
    public int determineWinner(){
        if (this.isWin(X)) return X;
        else if (this.isWin(O)) return O;

        return 0;
    }

    /**
     * Format the board
     * @return StringBuilder toString method.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++){
                switch (this.board[row][column]){
                    case X :{
                        stringBuilder.append("X");
                        break;
                    }
                    case O : {
                        stringBuilder.append("O");
                        break;
                    }
                    case EMPTY: {
                        stringBuilder.append(" ");
                        break;
                    }
                }

                if (column < 2) stringBuilder.append("|");
            }

            if (row < 2) stringBuilder.append("\n-----\n");
        }

        return stringBuilder.toString();
    }
}