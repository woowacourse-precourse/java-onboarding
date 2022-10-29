package onboarding;

import java.util.Set;

public class Problem3 {

    private static final ClapNumber CLAP_NUMBERS;

    static {
        Set<Integer> clapNumbers = Set.of(3, 6, 9);
        CLAP_NUMBERS = new ClapNumber(clapNumbers);
    }

    public static int solution(int number) {
        int answer = 0;
        return answer;
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