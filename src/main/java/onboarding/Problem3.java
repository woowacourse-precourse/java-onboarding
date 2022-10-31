package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    // 해당 숫자 3,6,9갯수 세기
    static int Count369(int num){
        Integer[] arr = {3,6,9};
        int count = 0;
        while(num > 0){
            int mod = num % 10;
            if (Arrays.asList(arr).contains(mod)){
                count++;
            }
            num /= 10;
        }
        return count;
    }
    // 1에서 타겟 숫자까지 검사 함수
    static int oneToNum(int num){
        int clapResult = 0;
        for (int i = 1 ; i <= num; i++){
            clapResult += Count369(i);
        }
        return clapResult;
    }
    // main 입력함수
    public static int solution(int number) {
        return oneToNum(number);
    }
}
