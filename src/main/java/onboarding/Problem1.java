package onboarding;

import java.util.List;
/***
 * 기능 목록
 *
 * 1. 페이지 번호 계산 기능
 * 2. 점수 비교 기능
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
    public static int pageCal(List<Integer> player) {
        int score = 0;
        for (int i = 0; i < 2; i++) {
            int page = player.get(i);
            int len = Integer.toString(page).length();
            int addSum = 0;
            int mulSum = 1;

            for (int j = 0; j < len; j++) {
                addSum += page % 10;
                mulSum *= page % 10;
                page /= 10;
            }
        if(score<addSum) score = addSum;
        if (score<mulSum) score = mulSum;
        }
        return score;
    }
}
