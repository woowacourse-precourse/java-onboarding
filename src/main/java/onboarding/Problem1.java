/*-----------------------------------------------------------
 * Author: 조형준
 * Date: 2022/11/01
 * Objective:
 *   1. pobi, crong 각각의 페이지 값이 예외사항에 해당하지 않는지 검토
 *   2. pobi, crong 각각의 왼쪽, 오른쪽 페이지 각 숫자의 각 자릿수 덧셈, 곱셈 값을 계산 후 비교
 *   3. 왼쪽, 오른쪽 페이지 각각의 계산결과를 다시 비교하여 pobi, crong의 점수로 삼음
 *   4. pobi, crong의 점수를 비교하여 해당하는 값을 return
 *   5. solution 메서드가 과도하게 길어질 수 있으므로 점수 계산 목적의
 *      get_score 메서드를 만들어 계산 파트를 분리
 *-----------------------------------------------------------*/
package onboarding;

import java.util.List;

class Problem1 {
    static int get_score(List<Integer> page_list) {
        int[] page_max = new int[2];
        int[] page = {page_list.get(0), page_list.get(1)};
        int page_add, page_mul;

        for (int i = 0; i < 2; i++){
            page_add = (page[i] / 100) + (page[i] % 100 / 10) + (page[i] % 10);
            page_mul = page[i] % 10;
            if (page[i] / 100 != 0){
                page_mul *= (page[i] / 100);
                page_mul *= page[i] % 100 / 10;
            } else if (page[i] / 10 != 0) {
                page_mul *= page[i] / 10;
            }
            page_max[i] = Math.max(page_add, page_mul);
        }
        return Math.max(page_max[0], page_max[1]);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_score = get_score(pobi);
        int crong_score = get_score(crong);
        int answer = Integer.MAX_VALUE;
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
            return answer;
        }

        if (pobi_score > crong_score)
            answer = 1;
        else if (pobi_score < crong_score)
            answer = 2;
        else if (pobi_score == crong_score)
            answer = 0;
        else
            answer = -1;

        return answer;
    }
}
