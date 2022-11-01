package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int countingNum = 1;
        while(countingNum <=number){
            String stringCountingNum = numToString(countingNum);
            answer+=countClap(stringCountingNum);
            countingNum ++;

        }
        return answer;
    }

    //문자에서 3/6/9 갯수 찾는 기능
    public static int countClap(String stringCountingNum){
        int clapCount = 0;
        for (int i=0; i<stringCountingNum.length();i++){
            if ("3,6,9".contains(Character.toString(stringCountingNum.charAt(i)))){
                clapCount++;
            }
        }

        return clapCount;
    }

    //숫자를 문자로 바꾸는 기능
    public static String numToString(int number){
        return Integer.toString(number);
    }
}
