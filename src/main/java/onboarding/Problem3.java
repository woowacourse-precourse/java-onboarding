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

        return answer;
    }



    private static boolean isWrongRange(int num){
        return (num < 1 || num > 10000);
    }


    static class Const{
        public static final int START_NUMBER = 1;
    }
}
