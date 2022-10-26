package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.lang.Character.getNumericValue;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외처리하는 메서드 -> 페이지가 이어지지 않는다든가, 시작이나 마지막 면을 펼쳤다든가
            // 예외일시에 바로 -1 리턴
        if (handleException(pobi)) {
            return -1;
        }

        // 2,3 과정 통해서 가장 큰수 뽑는 메서드 - 포비
        int pobi_score = score(pobi);
        // 2,3 과정 통해서 가장 큰수 뽑는 메서드 - 크롱
        int crong_score = score(crong);

        // 점수비교 해서 결과값 리턴하는 메서드 -> 메서드 반환값 answer에 저장
        answer = outcome(pobi_score, crong_score);

        return answer;
    }

    /* 2,3 과정 통해 본인 점수 도출 */
    private static int score(List<Integer> pages) {
        int score;
        ArrayList<Integer> candidates = new ArrayList<Integer>();

        // int값 가지고 sum 만드는 함수
        for (int i = 0; i< 2; i++) {
            candidates.add(make_sum(pages.get(i)));
        }

        // int값 가지고 product 만드는 함수
        for (int i = 0; i<2; i++) {
            candidates.add(make_prd(pages.get(i)));
        }

        score = Collections.max(candidates);

        return score;
    }

    /* sum 만들기 */
    private static int make_sum(int num) {
        int result = 0;

        String scoreInStr = Integer.toString(num);

        for (int i = 0; i < scoreInStr.length(); i++) {
            int tmp = Character.getNumericValue(scoreInStr.charAt(i));
            result += tmp;
        }

        return result;
    }

    /* product 만들기 */
    private static int make_prd(int num) {
        int result = 1;

        String scoreInStr = Integer.toString(num);

        for (int i = 0; i < scoreInStr.length(); i++) {
            int tmp = Character.getNumericValue(scoreInStr.charAt(i));
            result *= tmp;
        }

        return result;
    }

    /* 점수 비교해서 결과값 리턴 */
    private static int outcome(int pobi_score, int crong_score) {
        int compare = pobi_score - crong_score;

        if (compare == 0) {
            return 0;
        } else if (compare > 0) {
            return 1;
        } else {
            return 2;
        }

    }

    /* 예외처리 */
    private static boolean handleException(List<Integer> pages) {
        int first = pages.get(0);
        int second = pages.get(1);

         // 페이지가 이어지지 않음
        if (second - first != 1) {
            return true ;
        } else if (second == 400 || first == 0) {
            return true;
        } else {
            return false;
        }
    }

}