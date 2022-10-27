package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        int current;
        for(int i = 1; i <= number; i++) {
            current = i;
            while (current != 0) {
                if (current % 10 == 3 || current % 10 == 6 || current % 10 == 9) {
                    count++;
                }
                current /= 10;
            }
        }
        return count;
    }
}


