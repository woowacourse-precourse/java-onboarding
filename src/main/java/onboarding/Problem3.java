package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Problem: 숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
 */
public class Problem3 {
    /**
     * @Method: calcAll
     * 1씩 더해서 계산하는 함수.
     * 비효율적이더라도, 테스트용으로 구현
     */
    public static int calcAll(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String[] data = String.valueOf(i).split("");
            for (String tempData : data) {
                if(tempData.equals("3") || tempData.equals("6") || tempData.equals("9")) answer++;
            }
        }
        return answer;
    }

    /**
     * @Method: calcAlgorithm
     * 효율적으로 문제를 해결할 수 있는 알고리즘 구상
     * 1. 자릿수 별로 0 ~ 9까지 값이 존재한다.
     * 2. 각 값은 자릿수 별로 1번씩 나오게 된다.
     * 3. 1234인 경우, 1 ~ 999까지 박수소리에, 1 ~ 234까지의 박수의 수를 더하면 1234의 박수의 수를 구할 수 있다.
     * 3. 재귀 함수로 3번을 구현하면, 1000까지, 200까지, 30까지 4까지 의 값을 구하고, 더해주면 총 박수의 수를 구 할 수 있다.
     * 3 - 2. 이때, 각 자릿수가 3의 배수일 때, 해당 자릿수 이하의 수 + 1만큼을 더해주어야, 실제 박수 소리를 구할 수 있다.
     */
    private static int calcAlgorithm(int number) {
        int answer = 0;
        String[] digits = String.valueOf(number).split("");
        int length = digits.length - 1;

        // 1의 자리인 경우, 3으로 나눈 몫을 return한다.
        if(length == 0) {
            int data = Integer.parseInt(digits[0])/ 3;
            return data;
        }

        int temp = Integer.parseInt(digits[0]);     // 현재 최상위 자리수의 값
        answer += temp * 3 * Math.pow(10, length - 1) * length ;    // 0 ~ 현재 자리수 - 1 까지의 박수소리
        if (temp > 3) {
            answer += (temp-1) / 3 * Math.pow(10, length);
        }

        int seconds = (int) (number - (temp * Math.pow(10, length)));   // 전체 번호에서 temp를 뺀 값, 즉 하위값
        // 현재 자릿수의 값이 3의 배수라면, 하위값만큼 더 박수 수가 추가된다. +1은 하윗값이 0인 경우이다.
        if(temp % 3 == 0) {
            answer += seconds + 1;
        }

        // 하위값이 0인 경우 해당 값을 바로 return
        if(seconds != 0) {
            // 재귀
            answer += calcAlgorithm(seconds);
        }

        return answer;
    }


    /**
     * @Method: test3
     * calcAlgorithm을 테스트하기 위한 Test Code -> ApplicationTest에 추가
     */
//    @Test
//    void test3() {
//        for (int i = 0; i < 10000; i++) {
//            assertThat(Problem3.solution(i)).isEqualTo(Problem3.calcAll(i));
//        }
//    }

    public static int solution(int number) {
        int answer = calcAlgorithm(number);
        return answer;
    }
}
