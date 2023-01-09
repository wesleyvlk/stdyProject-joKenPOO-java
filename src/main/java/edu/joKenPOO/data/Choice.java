package main.java.edu.joKenPOO.data;

import java.util.Random;
import java.util.Scanner;

public abstract class Choice {
    protected int choicePlayer() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        System.out.println("1 - PEDRA ");
        System.out.println("2 - PAPEL ");
        System.out.println("3 - TESOURA ");
        System.out.print("Escolha a sua jogada: ");
        String choicePlayer = scanner.next();
        switch (choicePlayer.toLowerCase().toUpperCase()) {
            case "1":
                choice = 1;
                break;
            case "PEDRA":
                choice = 1;
                break;
            case "2":
                choice = 2;
                break;
            case "PAPEL":
                choice = 2;
                break;
            case "3":
                choice = 3;
                break;
            case "TESOURA":
                choice = 3;
                break;
            default:
                System.out.println("\tValor invalido");
                choicePlayer();
                break;
        }
        return choice;
    }

    protected int choiceIA() {
        Random choiceIA = new Random();
        return choiceIA.nextInt(3) + 1;
    }

    protected String showChoice(int choice) {
        String showChoice;
        switch (choice) {
            case 1:
                showChoice = "PEDRA";
                break;
            case 2:
                showChoice = "PAPEL";
                break;
            case 3:
                showChoice = "TESOURA";
                break;
            default:
                showChoice = "Valor invalido";
                break;
        }
        return showChoice;
    }

}