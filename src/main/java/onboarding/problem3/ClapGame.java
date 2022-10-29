package onboarding.problem3;

public class ClapGame {
    public static int countNumberOfClap(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            count += countIncluding369(i);
        }
        return count;
    }

    private static int countIncluding369(int number) {
        int counting = 0;
        while (number > 0) {
            counting += isMultipleOfThree(number % 10);
            number /= 10;
        }
        return counting;
    }

    private static int isMultipleOfThree(int number) {
        if (number % 3 != 0 || number == 0) {
            return 0;
        } else {
            return 1;
        }
    }
}
