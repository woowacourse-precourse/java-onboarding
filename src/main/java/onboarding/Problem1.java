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
    }
}