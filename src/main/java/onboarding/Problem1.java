package onboarding;

import java.util.List;

class Problem1 {
    private int extraction(List<Integer> pages){
        int result;
        int left = pages.get(0);
        int right = pages.get(1);

        // 더하기

        // 곱하기

        return result;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = extraction(pobi);
        int crongScore = extraction(crong);

        answer = Math.max(pobiScore, crongScore);
        return answer;
    }
}