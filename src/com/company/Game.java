package com.company;

//import java.util.Arrays;

import java.util.Random;
import java.util.Scanner;

public class Game {
    boolean winner = false;
    String[] players = {"Geel", "Rood"};
    Bord speelrek;

    Game() {
        speelrek = new Bord();
    }

    private void randomPlayerOrder() {
        Random random = new Random();

        for (int i = 0; i < players.length; i++) {
            int randomIndex = random.nextInt(players.length);
            String help = players[randomIndex];
            players[randomIndex] = players[i];
            players[i] = help;
        }
//        System.out.println(Arrays.toString(players));
    }

    private void turn(String player) {
        Scanner input = new Scanner(System.in);
        System.out.println("Speler " + player + " in welke kolom wil je je steen gooien?");
        char column = input.nextLine().toLowerCase().charAt(0);
        if (column >= 'a' && column <= 'g') {
            if (speelrek.checkColumnFull(column)) {
                System.out.println("Deze kolom is vol, gooi je steen in een andere kolom.");
                turn(player);
            } else {
                speelrek.dropPiece(column, player);
                speelrek.printBoard();
            }
        } else {
            System.out.println("Die kolom bestaat niet, probeer opnieuw");
            turn(player);
        }
    }

    private void winnerCheck(String player){
        if (speelrek.horizontalCheck(player)){
            winner = true;
        }
        if (speelrek.verticalCheck(player)){
            winner = true;
        }
        if(speelrek.diagonaleCheck(player)){
            winner = true;
        }
    }

    public void playGame() {
        randomPlayerOrder();
        while (!winner) {
            for (String player : players) {
                turn(player);
                winnerCheck(player);
              if(winner){
                  System.out.println("Speler " + player + " heeft gewonnen!");
                  break;
              };
            }
        }
    }
}
