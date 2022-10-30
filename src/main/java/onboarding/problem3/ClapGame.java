package onboarding.problem3;

public class ClapGame {
    private final int MULTIPLE_NUMBER = 3;

    public int getClapCount (int number) {
        if(number < MULTIPLE_NUMBER) {
            return 0;
        }

        return countClap(number);
    }

    private int countClap(int number) {
        int totalClapCount = 0;
        for (int i = 3; i < number + 1; i++) {
            totalClapCount += countClapForOneNumber(i);
        }
        return totalClapCount;
    }

    private int countClapForOneNumber(int number) {
        int count = 0;
        while (number > 0) {
            count += getNumberToAdd(number);;
            number /= 10;
        }
        return count;
    }

    private int getNumberToAdd (int number) {
        int target = number % 10;
        if (target != 0 && target % MULTIPLE_NUMBER == 0) {
            return 1;
        }
        return 0;
    }
}
