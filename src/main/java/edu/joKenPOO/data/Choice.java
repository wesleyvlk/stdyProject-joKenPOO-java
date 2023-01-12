package main.java.edu.joKenPOO.data;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public enum Choice {
    ROCK(1, "Pedra"),
    PAPER(2, "Papel"),
    SCISSOR(3, "Tesoura");

    private int level;
    private String display;

    private Choice(final int level, final String display) {
        this.level = level;
        this.display = display;
    }

    private int getLevel() {
        return level;
    }

    private String getDisplay() {
        return display;
    }

    private static Choice fromDisplay(final String display) {
        return Arrays.stream(values())
                .filter(choice -> choice.getDisplay().equalsIgnoreCase(display))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static Choice fromLevel(final int level) {
        return Arrays.stream(values())
                .filter(choice -> choice.getLevel() == level)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    protected static int choicePlayer() {
        int choice = 0;
        final var scanner = new Scanner(System.in);
        final var options = "1 - PEDRA \n2 - PAPEL \n3 - TESOURA \nEscolha a sua jogada: ";
        System.out.print(options);
        while (true) {
            final var choicePlayer = scanner.next();
            try {
                    choice = Integer.parseInt(choicePlayer);
                if (choice >= 1 && choice <= 3)
                    break;
                else
                    System.out.println("\nValor invalido.\n" + options);
            } catch (final IllegalArgumentException eIf) {
                try {
                    choice = fromDisplay(choicePlayer).getLevel();
                    break;
                } catch (final IllegalArgumentException eElse) {
                    System.out.println("\nValor invalido.\n" + options);
               }
            }
        }
        return choice;
    }

    protected static int choiceIA() {
        final var random = new Random();
        final var choiceIA = random.nextInt(values().length);
        return values()[choiceIA].getLevel();
    }

    protected static String showChoice(final int choice) {
        return fromLevel(choice).getDisplay();
    }

}