package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1;i<=number;i++) {
            List<Integer> arrayOfNumbers = convertToArray(i); // 1 ~ number 의 정수를 정수 배열로 변환
        }
        return answer;
    }
    private static List<Integer> convertToArray(int number) {
        List<Integer> arr = new ArrayList<>();
        while (number > 0) {
            arr.add(number % 10);
            number /= 10;
        }
        return arr;
    }
}
