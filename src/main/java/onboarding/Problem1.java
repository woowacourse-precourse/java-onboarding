package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * Game_starter 클래스 ( XX )
 * 1. open_book() = 책을 랜덤으로 펼친다. ( XX )
 * <p>
 * Validator 클래스
 * 1. is_odd() = 홀수인지 검증
 * 2. is_even() = 짝수인지 검증
 * 3. is_continuous = 연속된 페이지 인지 검증
 * 4. is_proper_pages() = 알맞은 페이지 리스트가 들어왔는지 검증
 * 5. is_both_page_proper() = 두 사람의 페이지 리스트가 모두 알맞은 리스트인지 검증
 *
 * <p>
 * Calculator 클래스
 * 1. page_sum() = 현재 페이지의 모든 숫자를 더한 값 반환
 * 2. page_multiple() = 현재 페이지의 모든 숫자를 곱한 값 반환
 * 3. get_biggest() = 왼쪽 페이지의 합과 곱, 오른쪽 페이지의 합과 곱 중 제일 큰 값을 반환
 * <p>
 * Judge 클래스
 * 1. show_result() = 결과를 반환한다 ( ERROR = -1, POBI = 1, CRONG = 2, DRAW = 0 )
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}

class Validator {
    private boolean is_odd(int num) {
        return num % 2 == 1;
    }

    private boolean is_even(int num) {
        return num % 2 == 0;
    }

    private boolean is_continuous(int num1, int num2) {
        return num2 - num1 == 1;
    }

    private boolean is_proper_pages(List<Integer> list) {
        int l_page = list.get(0);
        int r_page = list.get(1);
        return is_continuous(l_page, r_page) && is_odd(l_page) && is_even(r_page);
    }

    public boolean is_both_page_proper(List<Integer> pobi, List<Integer> crong) {
        return is_proper_pages(pobi) && is_proper_pages(crong);
    }
}