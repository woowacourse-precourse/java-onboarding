package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/** 기능 목록
 * solutionLogic    : 메인 솔루션
 * setGameRule      : 게임 룰에 맞는 숫자 저장
 * isSatisfied      : 게임 룰에 맞는지 확인
 * countClap        : 해당 숫자 박수 갯수 반환
 * checkValid       : 예외 처리
 */

public class Problem3 {

    private static Set<Integer> gameRule = Collections.emptySet();

    public static int solution(int number) {
        gameRule = setGameRule();
        if (!checkValid(number)) {
            throw new IllegalArgumentException("제한사항 위반");
        }
        return solutionLogic(number);
    }

    private static int solutionLogic(int num) {
        int clapCount = 0;
        for (int now = 1; now <= num; now++) {
            clapCount += countClap(now);
        }
        return clapCount;
    }

    private static HashSet<Integer> setGameRule() {
        HashSet<Integer> setRule = new HashSet<>();
        setRule.add(3);
        setRule.add(6);
        setRule.add(9);
        return setRule;
    }

    private static int isSatisfied(int num) {
        if (gameRule.contains(num % 10)) {
            return 1;
        }
        return 0;
    }

    private static int countClap(int num) {
        int count = 0;
        while (num != 0) {
            count += isSatisfied(num);
            num = num/10;
        }
        return count;
    }

    private static boolean checkValid(int num) {
        return 1 <= num && num <= 10000;
    }
}
