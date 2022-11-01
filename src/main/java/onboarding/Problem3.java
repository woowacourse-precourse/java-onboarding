package onboarding;

import java.util.Arrays;
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i=1; i<number+1; i++){
            String num = String.valueOf(i);
            char[] num_arr = num.toCharArray();
            for (int j=0; j<num_arr.length; j++){
                if (num_arr[j] == '3') {
                    answer += 1;
                }
                if (num_arr[j] == '6') {
                    answer += 1;
                }
                if (num_arr[j] == '9') {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
