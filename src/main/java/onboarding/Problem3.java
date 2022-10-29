package onboarding;

import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String[] numberArr = String.valueOf(i).split("");
            if(checkNumber(numberArr)) {

            }
        }

        return answer;
    }
    static boolean checkNumber(String[] numberArr) {
        for (int i = 0; i < numberArr.length; i++) {
            if(numberArr[i].equals("3") || numberArr[i].equals("6") || numberArr[i].equals("9")) {
                return true;
            }
        }
        return false;
    }
}
