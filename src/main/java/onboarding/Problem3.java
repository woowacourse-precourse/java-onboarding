package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    private static final Problem3 problem = new Problem3();
    public static int solution(int number) {
        int answer = 0;

        for(int now  = 1; now <= number; now++) {
            List<Integer> split = problem.getSplit(now);
            for(int i = 0; i < split.size(); i++) {
                int num = split.get(i);
                if (num != 0 && num % 3 == 0) answer++;
            }
        }

        return answer;
    }

    private List<Integer> getSplit(int number) {
        List<Integer> result = new ArrayList<>();
        int temp = number;
        while(temp > 0) {
            result.add(temp % 10);
            temp /= 10;
        }

        return result;
    }
}
