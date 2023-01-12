package main.java.edu.joKenPOO.data;

import java.util.Scanner;

public class Game extends Data {
    public void startGame() {
        var scanner = new Scanner(System.in);
        System.out.println("\n*********  Jo-Ken-Po  **********\n\tPressione Enter");
        scanner.nextLine();

        System.out.print("Informe seu nome: ");
        final var username = scanner.next().toUpperCase();
        player.setPlayer(username);

        System.out.print(username + ", informe o numero de rounds que deseja jogar: ");
        final var setRounds = scanner.nextInt();
        rounds = setRounds;

        playGame();
        scoreFinal();
    }
}