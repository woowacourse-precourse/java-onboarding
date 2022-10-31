package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        // 0. 전달받은 페이지 정보에 대한 유효성을 검증함 (연속적으로 주어진 페이지 인가?)
        if(!validation(pobi) || !validation(crong)) {
            answer = -1;
            return answer;
        }

        return answer;
    }

    // 페이지 정보에 대한 유효성을 검증 (연속적으로 주어진 페이지인가?)
    private static boolean validation(List<Integer> pages) {
        return (pages.get(0)+1 == pages.get(1));
    }
}