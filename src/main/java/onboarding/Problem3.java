package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int n = 0;
        for(int i = 1; i < number+1; i++){
            n += calcNum(i);
        }
        return n;
    }

    public static int calcNum(int num){
        int result = 0;
        int temp = 0;
        while (num != 0) {
            temp = num % 10;
            if(temp == 3 || temp == 6 || temp == 9){
                result += 1;
            }
            num /= 10;
        }
        return result;
    }
    // 수를 받았을 때 박수를 몇번 치는지 계산

    public static void main(String[] args){
        System.out.println(solution(13));
        System.out.println(solution(33));
    }

}
