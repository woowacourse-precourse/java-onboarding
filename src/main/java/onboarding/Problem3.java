package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    /*
     * 기능 정리
     * 1. 1부터 number까지 숫자 나열
     * 2. 나열된 각 숫자에 대해 3이 들어간 횟수를 카운트
     * 3. 카운트 한 숫자에 대한 총합 반환
     */

    //1. 기능1
    static List<Integer> getNumberList(int number) {

        List<Integer> numberList = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            numberList.add(i);
        }

        return numberList;
    }

    //2. 기능2
    static int getMultipleOfThreeCount(int number) {

        int remainedNumber = number;
        int count = 0;

        for (; remainedNumber > 0; ) {
            if (remainedNumber % 3 == 0 || remainedNumber % 6 == 0 || remainedNumber % 9 == 0) {
                count++;
            }
            remainedNumber /= 10;
        }

        return count;
    }


    public static int solution(int number) {
        int answer = getCountSummation(number);
        return answer;
    }
}
