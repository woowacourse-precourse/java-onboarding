package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        while(number >= 0) {
            for (int i = 1; i <= number; i++) {
                String num_str = String.valueOf(i);
                if(num_str.indexOf("3") >= 0 || num_str.indexOf("6") >= 0 || num_str.indexOf("9") >= 0) {
                    answer += 1;
                }
            }
            number = number / 10;

            if(number <= 0) {
                break;
            }
        }



        return answer;
    }
}
