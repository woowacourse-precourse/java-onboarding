package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {

    static List<Integer> answer;
    static int[] arrMoney = new int[] {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    public static List<Integer> solution(int money) {
        answer = new ArrayList<Integer>();
        for (int i=0; i< arrMoney.length; i++){
            answer.add(change(money,arrMoney[i]));
            money = leftMoney(money,arrMoney[i]);
        }
        return answer;
    }

    private static int change(int input, int change) {
        int answer = 0;
        if(input >= change){
            answer = input / change;
        }
        return answer;
    }

    static int leftMoney(int input, int change){
        int answer = input % change;
        return answer;
    }
}
