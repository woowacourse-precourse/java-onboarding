package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 잘못된 페이지 입력 예외 처리
        if (!pageValidCheck(pobi) || !pageValidCheck(crong)) {
            return -1;
        }

        // pobi 가장 큰 수 구하기

        // crong 가장 큰 수 구하기

        // 두 수 비교 한 값 할당

        return answer;
    }

    public static Boolean pageValidCheck(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        if (left % 2 != 0 || right != 1)
            return false;

        if (left == 1 || right == 400)
            return false;

        if (left + 1 != right)
            return false;

        return true;
    }
}