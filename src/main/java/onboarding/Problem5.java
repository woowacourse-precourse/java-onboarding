package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    private static List<Integer> arr; //지폐 갯수를 담을 배열
    private static int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1}; //금액
    public static List<Integer> solution(int money) {
        arr = new ArrayList<>();
        List<Integer> answer = calculation(money);
        return answer;
    }

    //지폐 갯수를 계산하는 기능
    public static List<Integer> calculation(int money) {
        int count = 0; //지폐 갯수 저장

        return arr;
    }

}
