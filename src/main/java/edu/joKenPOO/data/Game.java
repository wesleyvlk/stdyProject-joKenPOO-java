package main.java.edu.joKenPOO.data;

import java.util.Scanner;

public class Game extends Data {
    Scanner scan = new Scanner(System.in);
    public void startGame() {
        System.out.println("\n*********  Jo-Ken-Po  **********");
        System.out.println("\tPressione Enter");
        scan.nextLine();

        System.out.print("Informe seu nome: ");
        String username = scan.next().toUpperCase();
        player.setPlayer(username);

        System.out.print(username + ", informe o numero de rounds que deseja jogar: ");
        int setRounds = scan.nextInt();
        rounds = setRounds;
        
        inGame();
        scoreFinal();
    }
}