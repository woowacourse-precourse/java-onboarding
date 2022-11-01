package onboarding;

import java.util.List;

public class Problem3 {

    public static int solution(int number) {


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
