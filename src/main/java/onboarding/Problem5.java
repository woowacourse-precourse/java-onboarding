package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> divNumbers = Arrays.asList(50000, 10000, 5000, 1000, 500, 100, 50, 10);
        List<Integer> answer = new ArrayList<>();

        for (int divNumber : divNumbers) {
            int result = divideMoney(money, divNumber);
            answer.add(result);
            money -= result * divNumber;
        }

        // 일원 동전
        answer.add(money);

        return answer;
    }

    // 돈을 원하는 단위로 나누는 함수
    public static int divideMoney(int money, int divNumber) {
        return money / divNumber;
    }
}
