package onboarding;

import java.util.List;

class Problem1 {
    /** 기능 목록
     * 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     * 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     * 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
     * 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
     * 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiScore = getMaxScore(pobi);
        int crongScore = getMaxScore(crong);

        return Math.max(pobiScore, crongScore);
    }
    // 원시값 포장을 위한 점수 계산 메소드
    public static int getMaxScore(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);
        int leftScore = calScore(leftPage);
        int rightScore = calScore(rightPage);

        return Math.max(leftScore, rightScore);
    }
    public static int calScore(Integer page){
        int sum = 0;
        int mul = 1;
        while (page > 0) {
            int calVar = page % 10;
            sum += calVar;
            mul *= calVar;
            page /= 10;
        }
        return Math.max(sum, mul);
    }
}