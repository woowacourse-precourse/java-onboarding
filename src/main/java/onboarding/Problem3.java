package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = check369(number);
        return answer;
    }
    public static int check369(int num){
        int result = 0;
        List<String> check_369= new ArrayList<>(Arrays.asList("3","6","9"));
        for (int i = 0; i <= num; i++) {
            String strNum = String.valueOf(i);
            char[] charNum = strNum.toCharArray();
            for (char searchNum:
                 charNum) {
                for (String checkNum:
                     check_369) {
                    if (checkNum.equals(String.valueOf(searchNum))){
                        result+=1;
                    }
                }
            }
        }
        return result;

    }
}
