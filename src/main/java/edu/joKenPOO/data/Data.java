package main.java.edu.joKenPOO.data;

public abstract class Data extends Choice {
    protected Player player = new Player(null, 0);
    private Player ia = new Player("IA", 0);
    protected int rounds;

    protected void inGame() {
        System.out.println("\n******* SEJA BEM-VINDO(A), " + player.getPlayer() + " *******\n");
        for (int i = 1; i <= rounds; i++) {
            int choicePlayer = choicePlayer();
            int choiceIA = choiceIA();
            String scoreRound = "\nRound " + i + ": \n\t" + player.getPlayer() + ": " + showChoice(choicePlayer)
                    + " -VS- " + ia.getPlayer()
                    + ": " + showChoice(choiceIA);
            System.out.println(scoreRound);
            int result = choicePlayer - choiceIA;
            winnerRound(result);
        }
    }

    private void winnerRound(int result) {
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
        int playerScore = player.getScore();
        int iaScore = ia.getScore();
        System.out.println(
                "PLACAR FINAL: \n\t" + player.getPlayer() + ": " + player.getScore() + " -VS- " + ia.getPlayer()
                        + ": " + ia.getScore());
        if (playerScore == iaScore)
            System.out.println("\tEMPATE!");
        else {
            final String winnerFinal = (iaScore > playerScore) ? ia.getPlayer() : player.getPlayer();
            System.out.println("\tO VENCEDOR(A) É: " + winnerFinal.toUpperCase());
        }
        System.out.println();
    }

}
