package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 숫자를 각 자릿수로 나눠서 배열로 반환하는 함수
    private static List<Integer> splitInt(Integer number) {
        List<Integer> result = new ArrayList<Integer>();

        // number의 각 자릿수를 result에 저장한다.
        while(number > 0) {
            result.add(number % 10);
            number /= 10;
        }

        return result;
    }
}