package onboarding.problem3.MatchGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MatchGame {
    private final Set<Integer> matchNumbers;

    public MatchGame(Set<Integer> matchNumbers) {
        this.matchNumbers = matchNumbers;
    }

    private List<Integer> splitDigits(int number) {
        List<Integer> digits = new ArrayList<>();

        while (number > 0) {
            digits.add(0,number % 10);
            number /= 10;
        }

        return digits;
    }

    private boolean isMatchedNumbers(int number) {
        return matchNumbers.contains(number);
    }

    private int getMatchCount(List<Integer> digits) {
        int cnt = 0;

        for (int digit : digits) {
            if (isMatchedNumbers(digit))
                cnt++;
        }

        return cnt;
    }

    public int getMatchCount(int number) {
        List<Integer> digits = splitDigits(number);

        return getMatchCount(digits);
    }
}
