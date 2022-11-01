package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    private static final List<Integer> listOf369 = new ArrayList<>(Arrays.asList(3, 6 ,9));

    public static int solution(int number) {
        if(isInvalidInput(number)){
            return -1;
        }

        int result = 0;
        for(int i = 1; i <= number; i++){
            result += get369CountEachNum(i);
        }
        return result;
    }

    private static boolean isInvalidInput(int num){
        return !(1 <= num && num <= 10000);
    }

    private static int get369CountEachNum(int num){
        int result = 0;
        for(;num > 0; num /= 10){
            result += is369Digit(num % 10);
        }
        return result;
    }
    private static int is369Digit(int num){
        int result = 0;
        if(listOf369.contains(num)){
            result++;
        }
        return result;
    }


}
