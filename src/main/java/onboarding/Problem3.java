package onboarding;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        answer = countNumber(number);
        return answer;
    }

    static int countNumber(int number) {

        String str;
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            str = Integer.toString(i);
            String[] strArr = str.split("");
            List<String> num = Arrays.asList(strArr);

            answer += Collections.frequency(num, "3");
            answer += Collections.frequency(num, "6");
            answer += Collections.frequency(num, "9");

        }

        return answer;
    }
}
