package onboarding.problem3;

public class ClapGame {
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
