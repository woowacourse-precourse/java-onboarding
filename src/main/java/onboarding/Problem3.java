package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {

    public static int count(int number) {
        int num = number;
        List<Integer> arr = new ArrayList<>();

        while (num > 0) {
            arr.add(num%10);
            num /= 10;
        }

        int cnt = 0;
        int digit = 0;

        for (int i = 0; i < arr.size(); i++) {
            digit = arr.get(i);

            if (digit == 3 || digit == 6 || digit == 9)
                cnt++;
        }

        return cnt;
    }


    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += count(i);
        }

        return answer;
    }
}
