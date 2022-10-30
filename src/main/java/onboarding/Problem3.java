package onboarding;

/**
 * @Problem: 숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
 */
public class Problem3 {
    /**
     * @Method: calcAll
     * 1씩 더해서 계산하는 함수.
     * 비효율적이더라도, 테스트용으로 구현
     */

    /**
     * @Method: calcAlgorithm
     * 효율적으로 문제를 해결할 수 있는 알고리즘 구상
     * 1. 자릿수 별로 0 ~ 9까지 값이 존재한다.
     * 2. 각 값은 자릿수 별로 1번씩 나오게 된다.
     * 3. 1234인 경우, 1 ~ 999까지 박수소리에, 1 ~ 234까지의 박수의 수를 더하면 1234의 박수의 수를 구할 수 있다.
     * 3. 재귀 함수로 3번을 구현하면, 1000까지, 200까지, 30까지 4까지 의 값을 구하고, 더해주면 총 박수의 수를 구 할 수 있다.
     * 3 - 2. 이때, 각 자릿수가 3의 배수일 때, 해당 자릿수 이하의 수 + 1만큼을 더해주어야, 실제 박수 소리를 구할 수 있다.
     */


    /**
     * @Method: test3
     * calcAlgorithm을 테스트하기 위한 Test Code -> ApplicationTest에 추가
     */

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
