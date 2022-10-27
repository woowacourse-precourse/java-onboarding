package onboarding.problem3;

/**
 * Gamer playing threefold game
 */
public class ThreefoldGamer {

    private final int NUM;

    /**
     * Constructor with number
     * @param number last number of game
     */
    public ThreefoldGamer(int number) {
        this.NUM = number;
    }

    /**
     * Run threefold game
     * @return total number of 3, 6, 9 in 1 to last number
     */
    public int runGame() {
        int count = 0;
        for (int i = 1; i <= NUM; i++) {
            String numStr = String.valueOf(NUM);
            count += countThreefoldNum(numStr);
        }
        return count;
    }

    /**
     * Count how many threefold nums(3, 6, 9) are in single number
     * @param numStr number to count
     * @return total number of threefold number in single number
     */
    private int countThreefoldNum(String numStr) {
        int count = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int num = Integer.parseInt(numStr.substring(i, i + 1));
            if (num != 0 && num % 3 == 0)
                count++;
        }
        return count;
    }
}
