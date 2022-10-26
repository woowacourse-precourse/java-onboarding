package onboarding;

import java.util.List;

/**
 * Game_starter
 * 1. open_book() = 책을 랜덤으로 펼친다.
 *
 * Validator
 * 1. is_proper_pages() = 알맞은 페이지 리스트가 들어왔는지 검증 ( 오류시 ERROR (-1) 반환 )
 *
 * Calculator
 * 1. page_sum() = 현재 페이지의 모든 숫자를 더한 값 반환
 * 2. page_multiple() = 현재 페이지의 모든 숫자를 곱한 값 반환
 * 3. get_biggest() = 왼쪽 페이지의 합과 곱, 오른쪽 페이지의 합과 곱 중 제일 큰 값을 반환
 *
 * Judge
 * 1. show_result() = 결과를 반환한다 ( ERROR = -1, POBI = 1, CRONG = 2, DRAW = 0 )
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}