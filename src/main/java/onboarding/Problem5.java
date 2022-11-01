package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    //  Static-Variable
    private static final int[] exchange = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    //  교환하려는 화폐의 개수를 구하는 메소드
    private static int checkExchange(int money, int index){
        return money / exchange[index];
    }
}
