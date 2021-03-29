package com.company;

import java.util.Scanner;

public class Game {
    boolean winner = false;
    String[] players = {"Geel", "Rood"};
    Bord speelrek;

    Game() {
        speelrek = new Bord();
    }

    private void turn(String player){
        Scanner input = new Scanner(System.in);
        System.out.println("Speler " + player + " in welke kolom wil je je steen gooien?");
        char column = input.nextLine().toLowerCase().charAt(0);
        System.out.println("Kolom: " + column);
        speelrek.printBoard();
    }

    public void playGame() {
        while (!winner) {
            for (String player : players) {
                turn(player);
            }
            if (winner) {
                break;
            }
        }
    }
}
