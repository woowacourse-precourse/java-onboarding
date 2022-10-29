package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = findMaxScore(pobi);
        int crongScore = findMaxScore(crong);

        int answer = compare(pobiScore, crongScore);
        return answer;
    }

    public static int findMaxScore(List<Integer> page) {

        Integer frontPage = page.get(0);
        Integer backPage = page.get(1);

        if (validation(frontPage, backPage) || page.size() > 2) {
            return -1;
        }

        int[] front_digits = Stream.of(String.valueOf(frontPage).split("")).mapToInt(Integer::parseInt).toArray();
        int[] back_digits = Stream.of(String.valueOf(backPage).split("")).mapToInt(Integer::parseInt).toArray();

        int[] scores = new int[4];

        int add = 0;
        int mul = 1;

        for (int front_digit : front_digits) {
            add += front_digit;
            mul *= front_digit;
        }

        scores[0] = add;
        scores[1] = mul;

        add = 0;
        mul = 1;

        for (int back_digit : back_digits) {
            add += back_digit;
            mul *= back_digit;
        }

        scores[2] = add;
        scores[3] = mul;

        return Arrays.stream(scores).max().getAsInt();
    }

    public static boolean validation(int frontPage, int backPage) {
        if (frontPage < 1 || backPage > 400) {
            return true;
        }
        if (backPage - frontPage != 1) {
            return true;
        }

        return false;
    }

    public static int compare(int firstScore, int secondScore) {
        if (firstScore == -1 || secondScore == -1) {
            return -1;
        } else if (firstScore == secondScore) {
            return 0;
        } else if (firstScore == Math.max(firstScore, secondScore)) {
            return 1;
        } else {
            return 2;
        }
    }
}