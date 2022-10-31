package onboarding;

import java.util.List;
import java.util.ArrayList;

public class Problem3 {
    private static int count369(int num) {
        List<Integer> newList = new ArrayList<Integer>();
        int count = 0;

        while (num > 0) {
            newList.add(num % 10);
            num /= 10;
        }

        for (int i : newList) {
            if(i % 3 == 0 && i != 0) count++;
        }
        return count;
    }
    public static int solution(int number){
        int answer = 0;

        if(number < 1 || number > 10000)
            return -1;
        for (int i = 1; i <= number; i++) {
            answer += count369(i);
        }
        return answer;
    }
}
