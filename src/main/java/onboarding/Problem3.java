package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; i++){
            String numStr = Integer.toString(i);
            for(int j = 0; j < numStr.length(); j++){
                int Strnum = Integer.parseInt(numStr.substring(j,j+1));
                if(checkMultipleOfThree(Strnum)){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static boolean checkMultipleOfThree(int num){
        if(num != 0 && num % 3 == 0)
            return true;
        else
            return false;
    }
}
