package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외사항 처리
        // 1. pobi, crong의 길이가 2가 아닌 경우
        if (pobi == null || pobi.size() != 2) return -1;
        if (crong == null || crong.size() != 2) return -1;

        // 2. 페이지는 2~399까지만 가능(제약조건 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.)
        if (pobi.get(0) <= 1 || pobi.get(1) >= 400) return -1;
        if (crong.get(0) <= 1 || crong.get(1) >= 400) return -1;

        // 3. 왼쪽 페이지는 홀수, 오른쪽 페이지는 왼쪽 페이지 + 1
        if (!(pobi.get(0) % 2 == 1 && pobi.get(1) - 1 == pobi.get(0))) return -1;
        if (!(crong.get(0) % 2 == 1 && crong.get(1) - 1 == crong.get(0))) return -1;

        // 정답 구하기

        return answer;
    }
}