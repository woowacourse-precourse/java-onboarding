package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int getNumberOfClaps(int num) {
        int count = 0;
        List<Integer> numList = new ArrayList<>();
        numList.add(num % 10);            // 1의 자릿수
        numList.add(num % 100 / 10);      // 10의 자릿수
        numList.add(num % 1000 / 100);    // 100의 자릿수
        numList.add(num % 10000 / 1000);  // 1000의 자릿수

        for(Integer number : numList) {
            if (number == 3 || number == 6 || number ==9) {
                count++;
            }
        }

        return count;
    }

    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            answer += getNumberOfClaps(i);
        }

        return answer;
    }
}
