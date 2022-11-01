package onboarding;

import java.util.List;

class Problem1 {
    public static boolean hasError(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        // 페이지의 범위를 벗어나지 않는가
        if(left < 1 || left > 400) return true;
        if(right < 1 || right > 400) return true;

        // 왼쪽 페이지가 홀수인가
        if (left % 2 == 0) return true;

        // 두 페이지가 연속적인가
        return (right - left != 1);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        return answer;
    }
}