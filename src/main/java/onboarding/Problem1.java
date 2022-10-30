package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    private static List<Integer> digitParser(Integer page) {
        List<String> stringDigits = Arrays.asList(page.toString().split(""));
        List<Integer> integerDigits = new ArrayList<>();

        for (String digit: stringDigits) {
            integerDigits.add(Integer.valueOf(digit));
        }

        return integerDigits;
    }

    private static int getScore(List<List<Integer>> digits) {
        List<Integer> scores = new ArrayList<>();

        for (List<Integer> digit: digits) {
            scores.add(digit.stream().reduce(0, Integer::sum));
            scores.add(digit.stream().reduce(1, (a, b) -> a * b));
        }

        int maxValue = scores.stream().reduce(0, Integer::max);
        return maxValue;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        final int WRONG_INPUT = -1;
        final int TIE = 0;
        final int POBI_WINS = 1;
        final int CRONG_WINS = 2;

        List[] players = {pobi, crong};
        List<Integer> scores = new ArrayList<>();

        int result = 500;

        for (List<Integer> player : players) {
            int left = player.get(0);
            int right = player.get(1);

            if (right - left != 1 || right % 2 != 0 || left % 2 != 1 || right > 399 || left < 2) {
                result = WRONG_INPUT;
                return result;
            }

            List<List<Integer>> digits = new ArrayList<>();
            digits.add(digitParser(left));
            digits.add(digitParser(right));

            scores.add(getScore(digits));
        }

        final int POBI = scores.get(0);
        final int CRONG = scores.get(1);

        if (POBI == CRONG) {
            result = TIE;
        } else if (POBI > CRONG) {
            result = POBI_WINS;
        } else if (POBI < CRONG) {
            result = CRONG_WINS;
        }

        return result;
    }
}