package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {

    static final List<Integer> ERROR = Collections.emptyList();
    static boolean Exception(int money) {
        return (0 < money && money < 1000000) ? false : true;
    }

    static int getMoneyType(int money) {
        if (money >= 50000)
            return 50000;
        else if (money >= 10000)
            return 10000;
        else if (money >= 5000)
            return 5000;
        else if (money >= 1000)
            return 1000;
        else if (money >= 500)
            return 500;
        else if (money >= 100)
            return 100;
        else if (money >= 50)
            return 50;
        else if (money >= 10)
            return 10;
        else if (money >= 1)
            return 1;
        return 0;
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
        System.out.println(getMoneyType(5354));
    }

}
