package onboarding;

import java.util.List;

class Problem1 {
    /**
     * pobi와 crong 중 누가 이겼는지 알려주는 메서드이다.
     *
     * @param : List<Integer>, 두 개의 숫자로 구성된 페이지 리스트
     * @return : int,
     *    1 - 포비가 이긴 경우
     *    2 - 크롱이 이긴 경우
     *    0 - 무승부
     *    -1 - 예외처리
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * 얻을 수 있는 가장 큰 점수를 구하는 메서드이다.
     *
     * @param : List<Integer>, 두 개의 숫자로 구성된 페이지 리스트
     * @return : int, 계산된 최대 점수
     */
    public static int getScore(List<Integer> pages) {
        int score = 0;
        return score;
    }

    /**
     * 각 페이지의 숫자를 더해서 점수를 구하는 메서드이다.
     *
     * @param : int, 점수 계산에 사용될 페이지
     * @return : int, 페이지 각 자리 수의 총 합
     */
    public static int addEachNumber(int page) {
        int score = 0;
        while (page > 0) {
            score += page % 10;
            page /= 10;
        }
        return score;
    }

    /**
     * 각 페이지의 숫자를 곱해서 점수를 구하는 메서드이다.
     *
     * @param : int, 점수 계산에 사용될 페이지
     * @return : int, 페이지 각 자리 수의 총 곱
     */
    public static int multipleEachNumber(int page) {
        int score = 1;
        return score;
    }
}