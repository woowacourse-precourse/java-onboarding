package onboarding;

import java.util.Arrays;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;

        // Count 3, 6, 9 in each number and add
        for (int i = 1; i <= number; i++) {
            answer += countNumber(i);
        }

        return answer;
    }

    // Method to count 3, 6, 9 in each digit
    public static int countNumber(int number) {
        int count = 0;

        while (number > 0) {
            // Separate digit by dividing the number by 10
            int temp = number % 10;

            // Increase count if it is in 3, 6, 9
            if (temp == 3 || temp == 6 || temp == 9) {
                count += 1;
            }

            // Move pointer to the next digit
            number /= 10;
        }

        return count;
    }
}
