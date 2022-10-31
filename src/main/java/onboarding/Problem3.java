package onboarding;

import java.util.ArrayList;
import java.util.List;

class Clap369 {
    /**
     * 369게임에 쓰이는 메소드들을 정의한 클래스입니다.
     *
     * 모두 외부에 기능을 제공하기 위한 메소드들이고,
     * 인스턴스 변수의 값을 참조하거나 수정하지 않기 때문에
     * 불필요한 인스턴스의 생성을 줄이기 위해 클래스 메소드로 선언했습니다.
     *
     */
    public static List<Integer> getDigitList(int num) {
        /**
         * 각 자리의 숫자들로 이루어진 리스트를 반환하는 메소드
         */

        List<Integer> digitList = new ArrayList<>();

        while(num > 0) {
            digitList.add(num %10);
            num /= 10;
        }

        return digitList;
    }
}

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
