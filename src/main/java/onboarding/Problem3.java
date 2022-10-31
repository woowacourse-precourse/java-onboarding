package onboarding;

import onboarding.problem3.ThreefoldGamer;

/**
 * Problem 3 기능 목록
 * 1. 1부터 number 까지 이루어진 문자열을 생성한다. ex) number = 10 -> str = "12345678910"
 * 2. 생성한 문자열에서 3, 6, 9의 개수를 count 한다.
 */
public class Problem3 {
    public static int solution(int number) {
        ThreefoldGamer gamer = new ThreefoldGamer(number);
        return gamer.play();
    }
}
