package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        if(hasException(number)){
            return -1;
        }
        return getClapNum(number);
    }

    public static boolean hasException(int number){
        if(number<1 || number>10000)
            return true;
        return false;
    }

    public static int getClapNum(int number){
        int result = 0;
        for(int i = 1; i <= number; i++){
            long count = Arrays.stream(Integer.toString(i).split(""))
                    .map(Integer::parseInt)
                    .filter(num -> num == 3 || num == 6 || num == 9)
                    .count();
            result += count;
        }
        return result;
    }
}
