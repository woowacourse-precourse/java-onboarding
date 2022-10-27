package onboarding;

import java.util.List;

class Problem1 {
    private final int WRONG_INPUT = -1;
    private final int POBI_WIN = 1;
    private final int CRONG_WIN = 2;
    private final int DRAW = 0;

    /**
     * 1. 책을 임의로 펼친다.
     * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
     * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
     * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
     * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
     *
     * @param pobi 포비가 펼친 페이지
     * @param crong 크롱이 펼친 페이지
     * @return 게임 결과, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}