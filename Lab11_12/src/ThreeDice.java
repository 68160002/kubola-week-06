public class ThreeDice {
        private Dice d1;
        private Dice d2;
        private Dice d3;

        public ThreeDice(){
            d1 = new Dice();
            d2 = new Dice();
            d3 = new Dice();
        }
        public void play() {
            rollDices();
            showDicesScore();
            showGameResult();
        }
        private void rollDices() {
            d1.roll();
            d2.roll();
            d3.roll();
        }
        private void showDicesScore() {
            System.out.println(d1.getScore() + " " + d2.getScore() +" "+d3.getScore());
        }
        private void showGameResult() {
            boolean allEqual = (d1.getScore() == d2.getScore() && d2.getScore() == d3.getScore());
            boolean allOdd = (d1.getScore()%2 != 0 && d2.getScore()%2 != 0 && d3.getScore()%2 != 0);
            boolean allEven = (d1.getScore()%2 == 0 && d2.getScore()%2 == 0 && d3.getScore()%2 == 0);
            if ( allEqual || allOdd || allEven){
                System.out.println("You win.");
            }
            else {
                System.out.println("You lose.");
            }
        }
}
