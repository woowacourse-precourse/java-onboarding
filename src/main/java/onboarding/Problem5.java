package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final List<Integer> ERROR = Collections.emptyList();
    static boolean Exception(int money) {
        return (0 < money && money < 1000000) ? false : true;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = List.of(1);

        if (Exception(money))
            return ERROR;

        return answer;
    }

    public static void main(String argv[]) {

        System.out.println(solution(0));
        System.out.println(solution(1000001));
        System.out.println(solution(100001));
    }

}
