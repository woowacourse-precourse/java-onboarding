package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int currentNum =1; currentNum<=number; currentNum++){
            // 1 ... number
            String numToStr = Integer.toString(currentNum);
            String[] numToStrArr = numToStr.split("");
            int clap = 0;
            for(String str: numToStrArr){
                int stringToInt = Integer.parseInt(str);
                if(stringToInt % 3 ==0 && stringToInt != 0){
                    clap++;
                }
            }
        answer += clap;

        }
        return answer;
    }
}
