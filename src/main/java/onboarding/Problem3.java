package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    static List<Integer> list = List.of(3, 6, 9);
    public static int solution(int number) {

        int answer = 0;

        for(int i = 1; i<=number; i++) {
            answer = digitNumbers(answer, i);
        } return answer;
    }

    public static int digitNumbers(int answer,int num) {
        while(num > 0) {
            answer += plusAnswer(num);
            num /= 10;
        }
        return answer;
    }

    public static int plusAnswer(int num) {
        if (list.contains(num % 10)) {
            return  1;
        }
        return 0;
    }
}
