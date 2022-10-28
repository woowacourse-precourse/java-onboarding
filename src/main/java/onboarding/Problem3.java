package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    private static final int[] targets = {3, 6, 9};

    public static int solution(int number) {
        int answer = 0;

        while (number > 0)
            answer += countTargets(number--);

        return answer;
    }

    /**
     * 기능 3.1.1
     * 수를 자리별 숫자 리스트로 변환
     */
    public static List<Integer> getNumElements(int number) {
        List<Integer> numElements = new ArrayList<>();
        while (number > 0) {
            numElements.add(number % 10);
            number /= 10;
        }

        return numElements;
    }

    /**
     * 기능 3.1.2
     * 숫자 리스트에 존재하는 target(3,6,9)의 갯수를 계산
     */
    public static int countTargets(int number) {
        int count = 0;
        List<Integer> numElements = getNumElements(number);

        for (int ele : numElements) {
            if (isTarget(ele))
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
