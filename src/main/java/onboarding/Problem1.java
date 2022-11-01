package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 페이지 예외사항 처리
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1)
            return answer = -1;

        return answer;
    }
}