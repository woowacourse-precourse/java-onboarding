package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public boolean findException(List<Integer> arr) {
        int leftPage = arr.get(0);
        int rightPage = arr.get(1);
        if (leftPage % 2 == 1 && rightPage == leftPage + 1) {
            return leftPage > 1 && rightPage < 400;
        } else {
            return false;
        }
    }

    public int getScore(int num) {
        List<Integer> digits = new ArrayList<Integer>();
        while(num > 0) {
            digits.add(num % 10);
            num = num / 10;
        }
        int multipleDigits = digits.stream().reduce(1, (acc, cur) -> acc * cur);
        int sumDigits = digits.stream().reduce(0, Integer::sum);
        return Math.max(multipleDigits, sumDigits);
    }
}