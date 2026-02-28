public class GameSeven {
    private Dice d1;
    private Dice d2;
    private int total;

    public GameSeven() {
        d1 = new Dice();
        d2 = new Dice();
    }

    public void play() {
        rollDices();

        showDiceScore();

        addDiceScore();


        showGameResult();
    }
    private void rollDices() {
        d1.roll();
        d2.roll();
    }
    private void showDiceScore() {
        System.out.println(d1.getScore() + " " + d2.getScore());
    }
    private void addDiceScore() {
        total = d1.getScore() + d2.getScore();
    }
    private void showGameResult() {
        if (total == 7)
            System.out.println("You win.");
        else
            System.out.println("You lose.");
    }
}
