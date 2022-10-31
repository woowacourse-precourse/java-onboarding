package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int score_pobi, score_crong;

        if(validation(pobi) == -1 || validation(crong) == -1) {
            return -1;
        }

        score_pobi = cal_score(sum_page(pobi), mul_page(pobi));
        score_crong = cal_score(sum_page(crong), mul_page(crong));

        if(score_pobi > score_crong) answer = 1;
        else if (score_pobi < score_crong) answer = 2;
        else answer = 0;

        return answer;
    }

    public static int validation(List<Integer> page) { // 주어진 페이지의 유효성 검사
        if(page.get(0)%2 == 0 || page.get(1)%2 == 1) return -1;
        if(page.get(0) < 1 || page.get(1) > 400) return -1;
        if(page.get(0) + 1 != page.get(1)) return -1;
        return 0;
    }

    public static int cal_score(int sum, int mul) {
        if(sum > mul) return sum;
        else return mul;
    }

    public static int sum_page(List<Integer> page) { // 왼쪽, 오른쪽 페이지의 각 자리 숫자를 더한 후 더 큰 숫자 반환
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

    public static int mul_page(List<Integer> page) { // 왼쪽, 오른쪽 페이지의 각 자리 숫자를 곱한 후 더 큰 숫자 반환
        int mul_left = 1, mul_right = 1;
        int left_page = page.get(0);
        int right_page = page.get(1);

        while(left_page > 0 || right_page > 0) {
            mul_left *= left_page % 10;
            mul_right *= right_page % 10;
            left_page /= 10;
            right_page /= 10;
        }
        if(mul_left > mul_right) return mul_left;
        else return mul_right;
    }
}

