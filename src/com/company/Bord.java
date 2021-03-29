package com.company;

public class Bord {
    String[] row = new String[7];
    String[][] board = new String[6][];

    public Bord() {
        for (int i = 0; i < row.length; i++) {
            row[i] = " ";
        }

        for (int i = 0; i < board.length; i++) {
            board[i] = row;
        }

        printBoard();
    }

    void printBoard() {
        for (char i = 'a'; i < ('a' + board[0].length); i++) {
            System.out.print("  " + i + " ");
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    System.out.print("\n| " + board[i][j] + " | ");
                } else if (j == board[i].length - 1) {
                    System.out.print(board[i][j] + " | " + (board.length - i));
                } else {
                    System.out.print(board[i][j] + " | ");
                }
            }
        }
        System.out.println("");
        for (int i = 0; i < board[0].length; i++) {
                System.out.print("  - ");

        }
    }

}
