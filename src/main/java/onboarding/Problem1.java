package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 각 자리수 모두 분리
        // 더하거나 곱해서 max값 구하기
        // max값 비교해서 -1 0 1 중에서 알맞은거 리턴
        return answer;
    }

    /* 주어진 리스트로 만들 수 있는 가장 큰 수를 구하는 함수 */
    private static int getMax(List<Integer> book) {
        int max = 0;
        int left, right;

        return max;
    }

    /* 각 자릿수를 구하는 함수 */
    private static ArrayList<Integer> splitNum(int num) {
        ArrayList<Integer> result = new ArrayList<>();

        while(num > 0) {
            result.add(num%10);
            num /= 10;
        }
        return result;
    }
}