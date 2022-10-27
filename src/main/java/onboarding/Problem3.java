package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int[] getEachDigit(int number) {
        String strNum = Integer.toString(number);
        int[] arrNum = new int[strNum.length()];
        for (int i = 0; i < strNum.length(); i++) {
            arrNum[i] = strNum.charAt(i) - '0';
        }
        return arrNum;
    }

    public static int getNumberOfClap(int[] digitList) {
        int answer = 0;
        for(int i: digitList) {
            if(i == 3 || i == 6 || i == 9) {
                answer++;
            }
        }
        return answer;
    }

}
