package onboarding;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        final String numberString = String.valueOf(number);
        final String[] digitStrings = numberString.split("");
        final int[] digits = Stream.of(digitStrings)
                .parallel()
                .mapToInt(Integer::parseInt)
                .toArray();

        // The number of claps accumulated from 1 to all the previous numbers.
        int total_num_claps = 0;

        // The number of claps added from the very previous number.
        int prev_num_claps = 0;

        // The very previous number.
        int prev_number = 0;

        for (final int digit: digits) {

            // Count the number of claps resulting from the previous number
            // for when every 10 last digit is exhaustively considered for the ones place.
            total_num_claps = (total_num_claps - prev_num_claps) * 10
                    + prev_number * 3;
            
            // Count the number of claps for when any of 10 digits may not be included in ones place.
            total_num_claps += prev_num_claps * (digit + 1)
                    + digit / 3;
            
            prev_num_claps += digit != 0 && digit % 3 == 0 ? 1 : 0;
            prev_number = prev_number * 10 + digit;
        }
        final int answer = total_num_claps;
        return answer;
    }
}
