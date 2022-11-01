package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외사항 처리
        // 1. pobi, crong의 길이가 2가 아닌 경우
        if (pobi == null || pobi.size() != 2) return -1;
        if (crong == null || crong.size() != 2) return -1;

        // 2. 페이지는 2~399까지만 가능(제약조건 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.)
        if (pobi.get(0) <= 1 || pobi.get(1) >= 400) return -1;
        if (crong.get(0) <= 1 || crong.get(1) >= 400) return -1;

        // 3. 왼쪽 페이지는 홀수, 오른쪽 페이지는 왼쪽 페이지 + 1
        if (!(pobi.get(0) % 2 == 1 && pobi.get(1) - 1 == pobi.get(0))) return -1;
        if (!(crong.get(0) % 2 == 1 && crong.get(1) - 1 == crong.get(0))) return -1;

        // 정답 구하기
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore > crongScore) answer = 1;
        else if (pobiScore < crongScore) answer = 2;
        else answer = 0;

        return answer;
    }

    /**
     * 왼쪽, 오른쪽 페이지를 받아서 점수를 반환하는 메소드
     * @param pages 왼쪽, 오른쪽 페이지
     * @return 점수
     */
    private static int getScore(List<Integer> pages) {
        int score = 0;
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int leftPageScore = getOnePageScore(leftPage);
        int rightPageScore = getOnePageScore(rightPage);

        return Math.max(leftPageScore, rightPageScore);

    }

    /**
     * 한 페이지의 점수를 반환하는 메소드
     * @param page 한 페이지
     * @return 점수
     */
    private static int getOnePageScore(Integer page) {
        int[] digits = page.toString().chars().map(Character::getNumericValue).toArray();
        int allSum = 0;
        int allMultiplication = 1;

        for (int digit : digits) {
            allSum += digit;
            allMultiplication *= digit;
        }

        return Math.max(allSum, allMultiplication);
    }
}
