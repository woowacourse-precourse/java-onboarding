package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 사항 처리
        if(!(isValidBookPage(pobi) && isValidBookPage(crong)))
            return -1;

        return answer;
    }
    static boolean isValidBookPage(List<Integer> person) {
        boolean isLeftOddNumber = (person.get(0) % 2) == 1;
        boolean isLeftAndRight = (person.get(1) - person.get(0)) == 1;
        boolean isValidBookScope = (person.get(0) >= 1 && person.get(1) <= 400);
        return (isLeftOddNumber && isLeftAndRight && isValidBookScope);
    }
}