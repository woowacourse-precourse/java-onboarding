package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int result = 0;
        for(int index = 1; index <= number; index++ ){
            result += checkNum(index);
        }
        return result;
    }

    private static int checkNum(int number){
        String numStr = Integer.toString(number);
        int result = 0;
        for(char digit : numStr.toCharArray()){
            if(digit == '3' || digit == '6' || digit == '9'){
                result ++;
            }
        }
        return result;
    }
}
