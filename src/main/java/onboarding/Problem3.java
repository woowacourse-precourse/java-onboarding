package onboarding;

import java.util.HashMap;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        String numStr = Integer.toString(number);
        for(int i = 1;i<=numStr.length();i++){
            if(numStr.contains("3")||numStr.contains("6")||numStr.contains("9"))
                answer++;
        }

        return answer;
    }
}
