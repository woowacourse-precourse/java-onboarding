package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int checkInputs(List<Integer> pages) {
        int errorValue = -11;

        // 페이지 번호가 시작면이나 마지막면인지 확인
        if (pages.get(0) == 1 || pages.get(1) == 399) {
            errorValue = -1;
        }

        return errorValue;
    }
}