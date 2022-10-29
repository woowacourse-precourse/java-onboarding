package onboarding;

import java.util.Set;

public class Problem3 {

    private static final ClapNumber CLAP_NUMBERS;

    static {
        Set<Integer> clapNumbers = Set.of(3, 6, 9);
        CLAP_NUMBERS = new ClapNumber(clapNumbers);
    }

    public static int solution(int number) {
        int answer = getTotalClapCount(number);
        return answer;
    }

    private static int getTotalClapCount(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            count += getClapCount(i);
        }

        return count;
    }

    private static int getClapCount(int number) {
        String intToString = String.valueOf(number);
        int count = 0;

        for (int len = intToString.length(), i = 0; i < len; i++) {
            char current = intToString.charAt(i);

            if (CLAP_NUMBERS.contains(current - '0')) {
                count++;
            }
        }

        return count;
    }

}

class ClapNumber {

    private final Set<Integer> CLAP_NUMBERS;

    public ClapNumber(final Set<Integer> clapNumbers) {
        this.CLAP_NUMBERS = clapNumbers;
    }

    public boolean contains(int number) {
        return CLAP_NUMBERS.contains(number);
    }

}