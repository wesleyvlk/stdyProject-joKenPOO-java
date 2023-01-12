package main.java.edu.joKenPOO.data;

import java.util.stream.IntStream;

public abstract class Data {
    private final Player ia = new Player("IA", 0);
    protected Player player = new Player(null, 0);
    protected int rounds;

    protected void playGame() {
        System.out.println("\n******* SEJA BEM-VINDO(A), " + player.getPlayer() + " *******\n");
        IntStream.rangeClosed(1, rounds)
                .forEach(round -> {
                    final var choicePlayer = Choice.choicePlayer();
                    final var choiceIA = Choice.choiceIA();
                    final var scoreRound = "\nRound " + round + ": \n\t" + player.getPlayer() + ": "
                            + Choice.showChoice(choicePlayer)
                            + " -VS- " + ia.getPlayer()
                            + ": " + Choice.showChoice(choiceIA);
                    System.out.println(scoreRound);
                    final var result = choicePlayer - choiceIA;
                    winnerRound(result);
                });
    }

    private void winnerRound(final int result) {
        String winnerRound;
        if (result == 0)
            winnerRound = "EMPATE!";
        else if (result == -1 || result == 2) {
            ia.incrementScore();
            winnerRound = ia.getPlayer();
        } else {
            player.incrementScore();
            winnerRound = player.getPlayer();
        }
        System.out.println("\tVencedor(a): " + winnerRound + "\n");
    }

    protected void scoreFinal() {
        final var playerScore = player.getScore();
        final var iaScore = ia.getScore();
        final var scoreFinal = "PLACAR FINAL: \n\t" + player.getPlayer() + ": " + player.getScore() + " -VS- "
                + ia.getPlayer()
                + ": " + ia.getScore();
        System.out.println(scoreFinal);
        if (playerScore == iaScore)
            System.out.println("\tEMPATE!");
        else {
            final var winnerFinal = (iaScore > playerScore) ? ia.getPlayer() : player.getPlayer();
            System.out.println("\tO VENCEDOR(A) É: " + winnerFinal.toUpperCase());
        }
        System.out.println();
    }

}
