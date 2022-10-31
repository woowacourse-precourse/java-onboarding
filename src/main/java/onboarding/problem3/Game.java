package onboarding.problem3;

public class Game {
    private int number;
    private int sum;

    public Game(int number) {
        this.number = number;
        this.sum = 0;
    }

    private int getThreeNumber(int number) {
        int result = 0;
        while (number > 0) {
            int slotNumber = number % 10;
            if (slotNumber > 0 && slotNumber % 3 == 0) result++;
            number /= 10;
        }
        return result;
    }

    public int getResult() {
        for (int i = 3; i <= number; i++) sum += getThreeNumber(i);
        return sum;
    }
}
