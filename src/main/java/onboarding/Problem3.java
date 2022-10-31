package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        return 1;
    }
    private static int checkNumber(int number){
        int count = 0;
        while (number > 0) {
            if ((number % 10) % 3 == 0 && (number % 10) / 3 != 0) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
