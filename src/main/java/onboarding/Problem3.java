package onboarding;

import java.util.Set;

/* 기능 목록
 *
 *  clapNum : 해당 숫자에서 손뼉을 몇 번 쳐야 하는지 확인
 */
public class Problem3 {
    private static Set<Integer> clapSet = Set.of(3, 6, 9);

    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++)
            answer += clapNum(i);

        return answer;
    }

    private static int clapNum(int num) {
        int clapTime = 0;

        while(num > 0) {
            if(clapSet.contains(num % 10))
                clapTime++;
            num /= 10;
        }

        return clapTime;
    }
}
