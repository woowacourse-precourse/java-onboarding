package onboarding;

import java.util.*;
public class Problem3 {
    public static int solution(int number) {

        int answer = 0;

        for(int i = 1; i <= number; i ++) {
            String input = Integer.toString(i);

            for(int j = 0; j <input.length(); j++) {

                char alpha = input.charAt(j);

                if(alpha == '3' || alpha == '6' || alpha =='9')
                    answer ++;

            }
        }



        return answer;
    }
}
