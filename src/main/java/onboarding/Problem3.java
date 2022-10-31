package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 369게임 박수 횟수 세기 문제
 *
 * 문제 설명 :
 *  배달이가 좋아하는 369게임을 하고자 한다.
 *  놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.
 *  숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
 *
 * 제한사항
 *  - number는 1 이상 10,000 이하인 자연수이다.
 *
 * @author      scyllacore
 * @version     1.1 2022/10/31
 */

public class Problem3 {
    /*
     * 구현 사항
     * 1. createNumberList : 1부터 number까지 나열한 숫자들을 list에 저장.
     * 2. getMultipleOfThreeCount : 어떤 수에 대해 3의 배수(3,6,9)가 들어간 횟수를 셈.
     * 3. getCountSummation : getMultipleOfThreeCount를 통해 구한 각 숫자의 3의 개수를 모두 누적함.
     * 4. solution : 최종 3의 개수 반환
     */

    /**
     * 1. 1부터 number까지 나열한 숫자들을 list에 저장.
     *
     * @param number 나열할 숫자의 범위 지정
     * @return 1~number까지 나열한 숫자 list
     */
    static List<Integer> createNumberList(int number) {

        List<Integer> numberList = new ArrayList<>();

        for (int i = 1; i <= number; i++) {
            numberList.add(i);
        }

        return numberList;
    }

    /**
     * 2. 어떤 수에 대해 3의 배수(3,6,9)가 몇 개 들어가 있는지 셈.
     *
     * @param number 이 수를 가지고 3의 배수를 찾아냄.
     * @return 해당 수의 3의 배수 총 개수.
     */
    static int getMultipleOfThreeCount(int number) {

        int remainedNumber = number;
        int count = 0;
        int digit;

        for (; remainedNumber > 0; ) {

            digit = remainedNumber % 10;

            if (digit == 3 || digit == 6 || digit == 9) {
                count++;
            }

            remainedNumber /= 10;
        }

        return count;
    }

    /**
     * 3. getMultipleOfThreeCount을 통해 받아온 각 숫자에 대한 3의 배수 개수를 누적. 
     * 
     * @param number 나열할 숫자의 범위 지정.
     * @return 범위 안에서 누적된 3의 배수의 개수.
     */
    static int getCountSummation(int number) {
        int totalCount = 0;

        List<Integer> numberList = createNumberList(number);

        for (int index : numberList) {
            totalCount += getMultipleOfThreeCount(index);
        }

        return totalCount;
    }

    /**
     * 4. 최종값 반환.
     *
     * @param number 나열할 숫자의 범위 지정.
     * @return 최종 3의 배수 누적값.
     */
    public static int solution(int number) {
        int answer = getCountSummation(number);
        return answer;
    }
}
