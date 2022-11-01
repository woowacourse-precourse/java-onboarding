package onboarding;

/*
 *  🚀 기능 명세
    입력으로 들어온 숫자에서 369의 개수를 반환해주는 메서드(getClapTimeOfNumber)
    1부터 주어진 수까지의 총 박수 횟수를 반환해주는 메서드(solution)
 */

import onboarding.problem3.Game369;

public class Problem3 {
    public static int solution(int number) {
        return Game369.getTotalClapTimeOfNumbersInRange(1,number);
    }

}
