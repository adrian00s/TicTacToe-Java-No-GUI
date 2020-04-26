package org.tictactoe;

/**
 * Main class
 * @author Adrian Iordache
 * @version 1.0
 */
public class Board {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.putMark(0,0);
        ticTacToe.putMark(1,0);
        ticTacToe.putMark(0,1);
        ticTacToe.putMark(1,1);
        ticTacToe.putMark(2,2);
        ticTacToe.putMark(2,1);
        ticTacToe.putMark(0,2);

        int winner = ticTacToe.determineWinner();
        String[] textWinner = new String[] {"O Wins", "X Wins", ""};


        boolean isEmpty = false;

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (ticTacToe.board[i][j] == 0) {
                    isEmpty = true;
                    break;
                }
            }
        }

        System.out.println(ticTacToe);

        if (!isEmpty){
            textWinner[2] = "Tie";
            System.out.println("\n"+ textWinner[1 + winner]);
        }else if (winner != 0) System.out.println("\n"+textWinner[winner]);

    }
}
