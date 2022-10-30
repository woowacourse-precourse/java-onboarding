package onboarding;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        Set<String> set = new HashSet<String>();
        init(set);

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
}
