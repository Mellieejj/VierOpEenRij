package com.company;

public class Bord {
    String[][] board = new String[6][7];

    public Bord() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = " ";
            }
        }

        printBoard();
    }

    public void printBoard() {
        for (char i = 'a'; i < ('a' + board[0].length); i++) {
            System.out.print("  " + i + " ");
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (j == 0) {
                    System.out.print("\n| " + board[i][j] + " | ");
                } else if (j == board[i].length - 1) {
                    System.out.print(board[i][j] + " | " + (i + 1));
                } else {
                    System.out.print(board[i][j] + " | ");
                }
            }
        }
        System.out.print("\n");
        for (int i = 0; i < board[0].length; i++) {
            System.out.print("  - ");
        }
        System.out.print("\n");
    }

private void columnDrop(int index, String steen){
    for (int i = 0; i < board.length; i++) {
        if (board[i][index].equals(" ")) {
            board[i][index] = steen;
            break;
        }
    }
}
    public void dropPiece(char column, String speler) {
        String steen = speler.substring(0, 1);
        switch (column) {
            case 'a':
                columnDrop(0, steen);
                break;
            case 'b':
                columnDrop(1, steen);
                break;
            case 'c':
                columnDrop(2, steen);
                break;
            case 'd':
                columnDrop(3, steen);
                break;
            case 'e':
                columnDrop(4, steen);
                break;
            case 'f':
                columnDrop(5, steen);
                break;
            case 'g':
                columnDrop(6, steen);
                break;
        }
    }
}
