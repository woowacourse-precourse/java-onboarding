package onboarding;

import java.util.HashSet;

/** 기능 목록
 * solutionLogic    : 메인 솔루션
 * setGameRule      : 게임 룰에 맞는 숫자 저장
 * countClap        : 해당 숫자 박수 갯수 반환
 * checkValid       : 예외 처리
 */


public class Problem3 {
    static HashSet<Integer> gameRule;

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int solutionLogic(int num) {
        int now = 1;
        while (now <= num) {

            now += 1;
        }
    }

    public static void setGameRule() {
        gameRule.add(3);
        gameRule.add(6);
        gameRule.add(9);
    }

    public static int countClap(int num) {
        int count = 0;
        while (num != 0) {

        }
    }

    public static boolean checkValid(int num) {
        return 1 <= num && num <= 10000;
    }
}
