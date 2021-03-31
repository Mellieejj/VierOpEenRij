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

    private int convertCharToIndex(char column) {
        int index = 0;
        switch (column) {
            case 'a':
                index = 0;
                break;
            case 'b':
                index = 1;
                break;
            case 'c':
                index = 2;
                break;
            case 'd':
                index = 3;
                break;
            case 'e':
                index = 4;
                break;
            case 'f':
                index = 5;
                break;
            case 'g':
                index = 6;
                break;
        }
        return index;
    }

    public boolean checkColumnFull(char column) {
        int index = convertCharToIndex(column);
        boolean full = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][index].equals(" ")) {
                full = false;
            } else {
                full = true;
            }
        }
        return full;
    }

    public void dropPiece(char column, String speler) {
        String steen = speler.substring(0, 1);
        int index = convertCharToIndex(column);
        for (int i = 0; i < board.length; i++) {
            if (board[i][index].equals(" ")) {
                board[i][index] = steen;
                break;
            }
        }
    }

    public boolean horizontalCheck(String speler) {
        String steen = speler.substring(0, 1);

        for (String[] row : board) {
            for (int j = 0; j < row.length - 3; j++) {
                if (row[j].equals(steen)
                        && row[j + 1].equals(steen)
                        && row[j + 2].equals(steen)
                        && row[j + 3].equals(steen)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verticalCheck(String player) {
        String steen = player.substring(0, 1);

        int index = 0;

        while (index < board[0].length) {
            for (int i = 0; i < board.length - 3; i++) {
                if (board[i][index].equals(steen)
                        && board[i + 1][index].equals(steen)
                        && board[i + 2][index].equals(steen)
                        && board[i + 3][index].equals(steen)) {
                    return true;
                }
            }
            index++;
        }
        return false;
    }

    public boolean diagonaleCheck(String player) {
        String steen = player.substring(0, 1);
        // links boven naar rechts onder
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j].equals(steen) && board[i + 1][j + 1].equals(steen) && board[i + 2][j + 2].equals(steen) && board[i + 3][j + 3].equals(steen)) {
//                    System.out.println("1");
                    return true;
                }
            }
        }

        //links onder naar rechts boven
        for (int i = board.length - 1; i > board.length - 3; i--) {
            for (int j = 0; j < board[i].length - 3; j++) {
                if (board[i][j].equals(steen) && board[i - 1][j + 1].equals(steen) && board[i - 2][j + 2].equals(steen) && board[i - 3][j + 3].equals(steen)) {
//                    System.out.println("2");
                    return true;
                }
            }
        }

        //rechts boven naar links onder
        for (int i = 0; i < board.length - 3; i++) {
            for (int j = board[0].length - 1; j > board[i].length - 3; j--) {
                if (board[i][j].equals(steen) && board[i + 1][j - 1].equals(steen) && board[i + 2][j - 2].equals(steen) && board[i + 3][j - 3].equals(steen)) {
//                    System.out.println("3");
                    return true;
                }
            }
        }

        //rechts onder naar links boven
        for (int i = board.length - 1; i > board.length - 3; i--) {
            for (int j = board[0].length - 1; j > board[i].length - 3; j--) {
                if (board[i][j].equals(steen) && board[i - 1][j - 1].equals(steen) && board[i - 2][j - 2].equals(steen) && board[i - 3][j - 3].equals(steen)) {
//                    System.out.println("4");
                    return true;
                }
            }
        }

        return false;
    }
}
