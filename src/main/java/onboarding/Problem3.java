package onboarding;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;
        String strNum = splitNum(number);

        return answer;
    }
    public static String splitNum(int number){
        StringBuilder num = new StringBuilder();
        for(int i = 1;i<=number; i++){
            num.append(i);
        }

        return num.toString();
    }





}
