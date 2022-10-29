package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 1. 예외사항(두 페이지가 연속되지 않은 경우) -1 반환
        // 2. pobi의 점수 도출
        // 3. crong의 점수 도출
        // 4. pobi와 crong의 점수 비교
        // 5. 결과 값 반환
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}