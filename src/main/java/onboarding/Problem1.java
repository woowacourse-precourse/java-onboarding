package onboarding;

import java.util.List;

/*
    기능 명세
    1. validate_check(List<Integer> list) : 입력값이 유효한지 확인하는 함수
        1-1. 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수인지 확인하기
        1-2. 왼쪽 페이지와 오른쪽 페이지가 1페이지 차이나는지 확인하기
        1-3. 시작페이지거나 끝 페이지가 아닌지 확인하기
    2. get_score(int page) : 입력한 페이지의 각 자리를 더하거나 뺀 값중 최대 값을 구하는 함수
 */

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        try {
            validate_check(pobi);
            validate_check(crong);
            int pobi_score = Math.max(getScore(pobi.get(0)), getScore(pobi.get(1)));
            int crong_score = Math.max(getScore(crong.get(0)), getScore(crong.get(1)));
            if (pobi_score > crong_score) {
                answer = 1;
            } else if (pobi_score < crong_score) {
                answer = 2;
            } else {
                answer = 0;
            }
        } catch (Exception e) {
            answer = -1;
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void validate_check(List<Integer> pagelist) {
        int left_page = pagelist.get(0);
        int right_page = pagelist.get(1);

        if (left_page % 2 == 0 || right_page % 2 == 1) {
            throw new IllegalArgumentException("왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수여야 합니다.");
        }

        if (left_page + 1 != right_page) {
            throw new IllegalArgumentException("왼쪽 페이지와 오른쪽 페이지는 1페이지 차이여야 합니다.");
        }

        if (left_page == 1 || right_page == 400) {
            throw new IllegalArgumentException("시작페이지거나 끝 페이지는 입력할 수 없습니다.");
        }

        if (left_page < 1 || left_page > 400 || right_page < 1 || right_page > 400) {
            throw new IllegalArgumentException("페이지는 1~400 사이의 숫자여야 합니다.");
        }
    }

    private static int getScore(int page) {
        int add = 0;
        int multiply = 1;

        String str_page = Integer.toString(page);
        for (int i = 0; i < str_page.length(); i++) {
            int digit = str_page.charAt(i) - '0';
            add += digit;
            multiply *= digit;
        }
        return Math.max(add, multiply);
    }
}