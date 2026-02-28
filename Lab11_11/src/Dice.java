public class Dice {
    private int score;

    public void roll() {
        score = (int)(Math.random() * 6) + 1;
    }

    public int getScore() {
        return score;
    }
}
