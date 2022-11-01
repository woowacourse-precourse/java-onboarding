package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) { // 하나씩 숫자를 올리면서 숫자를 쪼개고, 해당 숫자가 있는 만큼 answer값이 올라감

        int answer = 0;
        List<String> num_arr = new ArrayList<>(Arrays.asList("3", "6", "9"));
        for (int i = 3; i <=number; i++){
            String number_string = String.valueOf(i);
            String[] digits = number_string.split("(?<=.)");

            for(int j = 0; j < digits.length; j++) {
                if (num_arr.contains(digits[j])){
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
