package onboarding;

import java.util.HashSet;

/** 기능 목록
 * solutionLogic    : 메인 솔루션
 * setGameRule      : 게임 룰에 맞는 숫자 저장
 * isSatisfied      : 게임 룰에 맞는지 확인
 * countClap        : 해당 숫자 박수 갯수 반환
 * checkValid       : 예외 처리
 */


public class Problem3 {
    static HashSet<Integer> gameRule;

    public static int solution(int number) {
        final int errorCase = -1;
        int answer;
        setGameRule();
        if(!checkValid(number)){
            return errorCase;
        }
        answer = solutionLogic(number);
        return answer;
    }

    public static int solutionLogic(int num) {
        int clapCount = 0;
        int now = 1;
        while (now <= num) {
            clapCount += countClap(now);
            now += 1;
        }
        return clapCount;
    }


    public static void setGameRule() {
        gameRule.add(3);
        gameRule.add(6);
        gameRule.add(9);
    }

    public static int isSatisfied(int num) {
        if (gameRule.contains(num % 10)) {
            return 1;
        }
        return 0;
    }

    public static int countClap(int num) {
        int count = 0;
        while (num != 0) {
            count += isSatisfied(num);
            num = num/10;
        }
        return count;
    }

    public static boolean checkValid(int num) {
        return 1 <= num && num <= 10000;
    }
}
