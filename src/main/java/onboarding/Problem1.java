package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 책을 임의로 펼친다.
 * 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 *
 * 포비가 이기면1, 크롱이 이기면 2, 무승부 0, 예외사항 -1
 *
 * TESTCASE
 *   pobi   /   crong   / result
 * [97, 98] / [197,198] / 0
 * [131, 132] / [211, 212] / 1
 * [99, 102]  / [211, 212] / -1
 */

/**TODO
 * 각 자리 합을 더하는 메서드
 * 각 자리를 모두 곱하는 메서드
 */

class Problem1 {

    public static void main(String[] args) {
        ArrayList<Integer> pobi = new ArrayList<>();
        ArrayList<Integer> crong = new ArrayList<>();

        pobi.add(97);
        pobi.add(98);

        crong.add(197);
        crong.add(198);

        System.out.println(solution(pobi, crong));
    }
    
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}