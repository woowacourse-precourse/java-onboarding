package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(validation(pobi) == -1 || validation(crong) == -1) {
            return -1;
        }

        return answer;
    }

    public static int validation(List<Integer> page) {
        if(page.get(0) == 1 || page.get(1) == 400) {
            return -1;
        }
        if(page.get(0) + 1 != page.get(1)) {
            return -1;
        }
        return 0;
    }

    public static int sum_page(List<Integer> page) { // 왼쪽 오른쪽 페이지의 각 자리 숫자를 더한 후 더 큰 숫자 반환
        int sum_left = 0, sum_right = 0;
        int left_page = page.get(0);
        int right_page = page.get(1);

        while(left_page > 0 || right_page > 0) {
            sum_left += left_page % 10;
            sum_right += right_page % 10;
            left_page /= 10;
            right_page /= 10;
        }
        if(sum_left > sum_right) return sum_left;
        else return sum_right;
    }
}

