package onboarding;

/**
 * @Problem: 숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
 */
public class Problem3 {
    /**
     * @Method: calcAlgorithm
     */
    private static int calcAlgorithm(int number) {
        int answer = 0;
        String[] digits = String.valueOf(number).split("");
        int tempMaxDigit = Integer.parseInt(digits[0]);     // 현재 최상위 자리수의 값
        int length = digits.length - 1;                     // 현재 최상위 자리수까지 0의 갯수.

        // 1의 자리인 경우, 3으로 나눈 몫을 return한다.
        if(length == 0) {
            return tempMaxDigit / 3;
        }

        // 3. 1234인 경우, 1 ~ 999까지 박수소리에, 1 ~ 234까지의 박수의 수를 더하면 1234의 박수의 수를 구할 수 있다.
        int multipleOfTen = (int) Math.pow(10, length);
        answer += tempMaxDigit * 3 * Math.pow(10, length - 1) * length ;    // 0 ~ 현재 자리수 - 1 까지의 박수소리
        if (tempMaxDigit > 3) {
            answer += ((tempMaxDigit-1) / 3) * multipleOfTen;
        }

        // 4 - 2. 이때, 각 자릿수가 3의 배수일 때, 해당 자릿수 이하의 수 + 1만큼을 더해주어야, 실제 박수 소리를 구할 수 있다.
        int seconds = number - (tempMaxDigit * multipleOfTen);   // 전체 번호에서 temp를 뺀 값, 즉 하위값
        if(tempMaxDigit % 3 == 0) {     // 현재 자릿수의 값이 3의 배수라면, 하위값만큼 더 박수 수가 추가된다. +1은 하윗값이 0인 경우이다.
            answer += seconds + 1;
        }

        // 하위값이 0인 경우 해당 값을 바로 return
        if(seconds == 0) {
            return answer;
        }

        // 4. 재귀 함수로 3번을 구현하면, 1000까지, 200까지, 30까지 4까지 의 값을 구하고, 더해주면 총 박수의 수를 구 할 수 있다.
        answer += calcAlgorithm(seconds);   // 하위 값이 존재하는 경우, 재귀로 처리
        return answer;
    }

    public static int solution(int number) {
        return calcAlgorithm(number);
    }
}
