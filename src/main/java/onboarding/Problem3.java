package onboarding;

import java.util.Arrays;

public class Problem3 {
    private static int count = 0;

    public static int solution(int number) {
        countClap(number);
        int answer = count;
        count = 0; // Initialize for multiple test case
        return answer;
    }

    public static void countClap(int number){
        while (number != 0){
            checkEachNumber(number);
            number -= 1;
        }
    }

    public static void checkEachNumber(int number){
        String stringNumber = String.valueOf(number);
        String[] digits = stringNumber.split("");
        increaseCount(digits);
    }

    public static void increaseCount(String[] digits){
        for (String stringNumber : digits){
            int number = Integer.parseInt(stringNumber);
            checkCondition(number);
        }
    }

    public static void checkCondition(int number){
        if(number == 3 || number == 6 || number == 9){
            count += 1;
        }
    }
}
