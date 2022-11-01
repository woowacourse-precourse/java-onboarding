package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    /* 기능 단위
     * 1. money를 각 단위로 변환
     *   a. money를 10^digit 과 5*10^digit으로 나누기
     *   b. 몫이 1보다 크면 변환가능
     * */
    private static int getPowerByDigit(int digit) {
        return ((int) Math.pow(10, digit-1));
    }

    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int digit = 5;
        int powerDigit;
        int quotient;

        while(answer.size() < 8) {
            powerDigit = getPowerByDigit(digit);

            quotient = money/(powerDigit*5);
            if(quotient >= 1) {
                answer.add(quotient);
                money -= 5*powerDigit*quotient;
            } else {
                answer.add(0);
            }

            quotient = money/powerDigit;
            if(quotient >= 1) {
                answer.add(quotient);
                money -= powerDigit*quotient;
            } else {
                answer.add(0);
            }
            digit --;
        }
        answer.add(money);
        System.out.println("answer:" + answer);
        return answer;
    }
}
