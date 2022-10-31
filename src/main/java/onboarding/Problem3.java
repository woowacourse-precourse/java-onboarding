package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int num = 10;
        List<Integer> num_check = Arrays.asList(3,6,9);
        for (int i = 1; i <= number; i++){
            for (int current_number = i; current_number != 0;){
                if (num_check.contains(current_number % num)){
                    answer += 1;
                }//if
                current_number -= current_number % num;
                current_number /= num;
            }//for2
        }//for1
        return answer;
    }
}
