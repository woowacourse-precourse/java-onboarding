package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            answer += getClapCount(i);
        }
        return answer;
    }

    public static int getClapCount(int number) {
        List<Integer> nums = new ArrayList<>();
        int clap = 0;

        String numString = Integer.toString(number);
        for(char num : numString.toCharArray()) {
            if (num == '3' || num == '6' || num == '9')
                clap++;
        }
        return clap;
    }
}

