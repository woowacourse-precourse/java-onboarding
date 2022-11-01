package onboarding;

import java.util.List;

public class Problem3 {

    public static int solution(int number) {

        int[] crap_count = new int[number+1];
        crap_count[0] = 0;

        for (int i=1; i <= number; i++) {
            crap_count[i] = crap_count[i-1] + calculate_clap_count(i);
        }

        return crap_count[number];
    }

    public static int calculate_clap_count(int number){
        int count = 0;

        while (number != 0) {
            int units = number % 10;

            if (units == 3 || units == 6 || units == 9) {
                count += 1;
            }

            number /= 10;
        }

        return count;
    }
}
