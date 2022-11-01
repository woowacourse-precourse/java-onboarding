package onboarding;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        Set<String> set = new HashSet<String>();
        init(set);

        for (int i = 1; i <= number; i++) {
            answer += checkingNumber(Integer.toString(i), set);
        }

        return answer;
    }

    /**
     * Function for creating Set for checking 3,6,9
     * */
    private static void init(Set<String> set) {
        set.add("3");
        set.add("6");
        set.add("9");
    }

    /**
     * Function for checking whether number contain things in Set
     * */
    private static int checkingNumber(String i, Set<String> set) {
        int total = 0;
        String num = i;
        for (int k = 0; k < num.length(); k++) {
            if (set.contains(String.valueOf(num.charAt(k)))) {
                total += 1;
            }
        }
        return total;
    }
}
