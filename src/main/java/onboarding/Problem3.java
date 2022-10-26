package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * goal: 369게임을 할 때 1~number까지 몇 번의 손뼉을 치는지 리턴
 */

/**
 * 문제 풀이 순서
 * 1. 먼저 list에 박수를 쳐야 할 떄인 3, 6, 9를 초기화 해준다.
 * 2. 박수는 3부터 치기 때문에 3~number까지 for문을 돌려준다.
 * 3. for문을 돌면서 현재 num을 String으로 변환해주고 3, 6, 9가 몇 개 포함되어 있는지 확인한다.
 * 4. for문을 돌면서 박수친 횟수를 모두 더해주면 결과가 나온다.
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        List<Character> clapList = new ArrayList<>();
        clapList.add('3');
        clapList.add('6');
        clapList.add('9');

        for (int currentNumber = 3; currentNumber <= number; currentNumber++) {
            String strOfCurrentNumber = String.valueOf(currentNumber);
            answer += countClap(strOfCurrentNumber, clapList);
        }
        return answer;
    }

    private static int countClap(String strOfCurrentNumber, List<Character> clapList) {
        int clapCount = 0;
        for (int i = 0; i < strOfCurrentNumber.length(); i++) {
            if (clapList.contains(strOfCurrentNumber.charAt(i))) {
                clapCount++;
            }
        }
        return clapCount;
    }
}
