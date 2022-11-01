package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
	
    public static List<Integer> separateInt(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        return list;
    }
    public static int solution(int number) {
        int answer = 0;
        
        List<Integer> sep;
        
        for (int n = 1; n <= number; n++) {
            sep = separateInt(n);
            for (int i: sep) {
                if (i == 3 || i == 6 || i == 9) answer++;
            }
        }
        return answer;
    }
}