package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int i=0; i<=number ; i++ ){
            answer += getClaps(i);
        }

        return answer;
    }

    private static List<Integer> threeToNine = new ArrayList<>(Arrays.asList(3, 6, 9));

    private static int getClaps(int number){
        int count = 0;
        while(true) {
            if(number <= 0)
                return count;
            if(threeToNine.contains(number%10))
                count ++;
            number = number/10;
        }
    }
}
