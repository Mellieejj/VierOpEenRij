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
        System.out.println("Speler " + player + " in welke kolom wil je je steen gooien? Gebruik geen hoofdletters.");
        char column = input.nextLine().toLowerCase().charAt(0);
        if(column >= 'a' && column <= 'g'){
            speelrek.dropPiece(column, player);
            speelrek.printBoard();
        }else {
            System.out.println("Die kolom bestaat niet, probeer opnieuw");
            turn(player);
        }
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
