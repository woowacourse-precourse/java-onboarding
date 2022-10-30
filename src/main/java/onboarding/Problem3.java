package onboarding;

import java.util.*;

/**
 * Problem 3
 *
 * 기능 요구 사항
 * 1. 3, 6, 9가 들어가면 갯수만큼 손뼉을 쳐야한다.
 * 2. 1부터 number까지 쳐야하는 횟수
 *
 * 제한 사항
 * 1. number는 1부터 10,000이하의 자연수
 */
public class Problem3 {
    /**
     * @param number
     * @return 손뼉 횟수
     */
    public static int solution(int number) {
        int answer = startFind(number);
        return answer;
    }

    /**
     * 손뼉 찾는 함수
     * @param number
     * @return
     */
    public static int startFind(int number) {
        if (checkUnderTen(number)) {
            return number / 3;
        }

        int[] clapNumbers = new int[number + 1];
        Arrays.fill(clapNumbers, 0);
        for (int i=1; i<10; i++) {
            if(i%3==0) {
                clapNumbers[i] = 1;
            }
        }

        int answer = 3;
        for (int i = 10; i <= number; i++) {
            String beforeString = Integer.toString(i);
            int beforeNumber = Integer.parseInt(beforeString.substring(1));
            clapNumbers[i] = clapNumbers[beforeNumber];
            if (isGameNumber(beforeString.charAt(0))){
                clapNumbers[i] += 1;
            }
            answer += clapNumbers[i];
        }
        return answer;
    }

    /**
     * 9이하의 값 확인하는 함수
     * @param number
     * @return 9이하의 값인지 확인
     */
    public static boolean checkUnderTen(int number) {
        return (number < 10);
    }

    /**
     * 게임 숫자 3, 6, 9인지 확인
     * @param origin
     * @return 게임 숫자이면 True, 아니면 False
     */
    public static boolean isGameNumber(char origin) {
        return (origin == '3' || origin == '6' || origin == '9');
    }
}