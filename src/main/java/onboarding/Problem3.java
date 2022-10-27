package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            if (i < 10 && i % 3 == 0) { // 1의 자리수이고 3의 배수일 때
                answer++;
                continue;
            }
            // 10 이상의 수일 때 각 자리수를 구하고 박수 횟수를 구한다. 
            int[] digitList = getEachDigit(i);
            answer += getNumberOfClap(digitList);

        }
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
