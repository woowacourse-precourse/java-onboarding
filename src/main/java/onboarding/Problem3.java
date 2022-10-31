package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    private static final int[] targets = {3, 6, 9};

    public static int solution(int number) {
        int answer = 0;

        // 숫자를 1씩 줄여가며 target(3,6,9) 갯수를 count
        while (number > 0)
            answer += countTargets(number--);

        return answer;
    }

    /**
     * 기능 3.1.1
     * 수를 자리별 숫자 리스트로 변환
     */
    public static List<Character> getChars(int number) {

        return new CharSpliter<Integer>().getChars(number);
    }

    /**
     * 기능 3.1.2
     * 숫자 리스트에 존재하는 target(3,6,9)의 갯수를 계산
     */
    public static int countTargets(int number) {
        int count = 0;
        List<Character> numElements = getChars(number);

        for (Character ele : numElements) {
            if (isTarget(Integer.parseInt(ele.toString())))
                count++;
        }

        return count;
    }

    /**
     * 숫자가 target(3,6,9)에 속하는지 판단
     */
    public static boolean isTarget(int element) {
        for (int target : targets)
            if (element == target)
                return true;

        return false;
    }
}
