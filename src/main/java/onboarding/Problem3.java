package onboarding;

import java.util.List;

public class Problem3 {

    static final List<Character> TO_FIND_NUMBERS = List.of('3', '6', '9');

    public static int solution(int number) {
        int count = 0;

        for (int i = 1; i <= number; i++) {
            String num = Integer.toString(i);
            for (int j = 0; j < num.length(); j++) {
                if (TO_FIND_NUMBERS.contains(num.charAt(j))) {
                    count += 1;
                }
            }
        }

        return count;
    }
}
