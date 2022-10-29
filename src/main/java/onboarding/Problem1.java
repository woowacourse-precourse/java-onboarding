package onboarding;

import java.util.List;

class Problem1 {
    static final int FIRST_PAGE = 1;
    static final int LAST_PAGE = 400;

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

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        // 왼쪽이 홀수, 오른쪽이 짝수가 아닌 경우
        if (!(pobiLeftPage % 2 == 1 && pobiRightPage % 2 == 0)) {
            return -1;
        }

        if (!(crongLeftPage % 2 == 1 && crongRightPage % 2 == 0)) {
            return -1;
        }

        // 오른쪽 페이지 - 왼쪽 페이지가 1이 아닌 경우
        if (!(pobiRightPage - pobiLeftPage == 1 && crongRightPage - crongLeftPage == 1)) {
            return -1;
        }

        // 시작 면의 경우
        if (pobiLeftPage <= FIRST_PAGE || crongLeftPage <= FIRST_PAGE) {
            return -1;
        }

        // 마지막 면의 경우
        if (pobiRightPage >= LAST_PAGE || crongRightPage >= LAST_PAGE) {
            return -1;
        }

        int pobiScore = getScore(pobiLeftPage, pobiRightPage);
        int crongScore = getScore(crongLeftPage, crongRightPage);

        if (pobiScore == crongScore) answer = 0;
        else if (pobiScore > crongScore) answer = 1;
        else answer = 2;

        return answer;
    }

    /**
     * 얻을 수 있는 가장 큰 점수를 구하는 메서드이다.
     *
     * @param : List<Integer>, 두 개의 숫자로 구성된 페이지 리스트
     * @return : int, 계산된 최대 점수
     */
    public static int getScore(int leftPage, int rightPage) {
        int leftPageScore = Math.max(addEachNumber(leftPage), multipleEachNumber(leftPage));
        int rightPageScore = Math.max(addEachNumber(rightPage), multipleEachNumber(rightPage));

        return Math.max(leftPageScore, rightPageScore);
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
        while (page > 0) {
            score *= page % 10;
            page /= 10;
        }
        return score;
    }
}