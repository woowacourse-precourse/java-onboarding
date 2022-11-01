package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;

    // 자리수별로 숫자 분리
    private static List<Integer> separateNumber(int num){
        List<Integer> separatedNumbers = new ArrayList<>();
        final int NOTATION = 10;

        while (num > NOTATION){
            separatedNumbers.add(num % NOTATION);
            num /= NOTATION;
        }
        separatedNumbers.add(num % NOTATION);
        return separatedNumbers;
    }

    private static boolean isOdd(int num){
        if (num%2 == 1) return true;
        return false;
    }

    private static boolean isSequential(int leftPage, int rightPage){
        if (leftPage + 1 == rightPage) return true;
        return false;
    }

    private static boolean isInRange(int num){
        final int MAX_VALUE = 400;
        final int MIN_VALUE = 0;

        if (num >= MIN_VALUE && num <= MAX_VALUE) return true;
        return false;
    }

    private static boolean isValidSize(List<Integer> pages){
        final int PAGES_SIZE = 2;
        if (pages.size() == PAGES_SIZE) return true;
        return false;
    }
    }
}