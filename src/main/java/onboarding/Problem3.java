package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    // 해당 숫자 3,6,9갯수 세기
    static int Count369(int num){
        int[] arr = {3,6,9};
        int count = 0;
        while(num > 0){
            if (List.of(arr).contains(num % 10)){
                count++;
                num /= 10;
            }
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }
}
