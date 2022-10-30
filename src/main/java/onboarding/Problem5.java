package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        //List<Integer> answer = Collections.emptyList();
        ArrayList<Integer> moneys = new ArrayList<>(List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1));
        ArrayList<Integer> answer = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0, 0, 0, 0));
        setAnswer(money, moneys, answer);
        return answer;
    }

    private static void setAnswer(int money, ArrayList<Integer> moneys, ArrayList<Integer> answer) {
        for(int i = 0; i< moneys.size(); i++){
            answer.set(i, money / moneys.get(i));
            money %= moneys.get(i);
        }
    }
}
