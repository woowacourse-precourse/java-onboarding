package onboarding;

import java.util.List;

import static onboarding.Problem3.Const.*;

public class Problem3 {

    private static List<Integer> targetList = List.of(3, 6, 9);

    public static int solution(int number) {
        int answer = 0;
        if (isWrongRange(number)){
            throw new IllegalArgumentException("1 이상 10000이하 자연수이어야 합니다.");
        }

        answer = getGameResult(number);
        return answer;
    }

    private static int getGameResult(int lastNumber){
        int sum = 0;

        for (int num=START_NUMBER; num<=lastNumber; num++){
            sum += getCountOfDigit(num);
        }
        return sum;
    }

    private static int getCountOfDigit(int number){
        int count = 0;
        while (number != 0){
            int digit = number % 10;
            if (targetList.contains(digit)){
                count++;
            }
            number /= 10;
        }

        return count;
    }

    private static boolean isWrongRange(int num){
        return (num < 1 || num > 10000);
    }

    static class Const{
        public static final int START_NUMBER = 1;
    }
}
