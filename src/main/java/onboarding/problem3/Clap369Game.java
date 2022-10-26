package onboarding.problem3;

import java.util.Enumeration;
import java.util.Map;

public class Clap369Game implements ClapGame {
    private final int number;

    public Clap369Game(int number) {
        this.number = number;
    }

    @Override
    public int getResult() {
        int result = 0;
        for (int i = 1; i <= number; i++) {
            result += calculateClapCount(i);
        }
        return result;
    }

    /**
    * 해당 숫자에 3, 6, 9 가 몇개 있는지 계산
     */
    private int calculateClapCount(int number) {
        int count = 0;
        while (number > 0) {
            if ((number % 10) == 3 || (number % 10) == 6 || (number % 10) == 9) {
                count += 1;
            }
            number /= 10;
        }
        return count;
    }
}
