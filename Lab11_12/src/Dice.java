public class Dice {
    private int Score;
    public void roll() {
        Score = (int)(Math.random() * 6) + 1;
    }
    public int getScore() {
        return Score;
    }
}
