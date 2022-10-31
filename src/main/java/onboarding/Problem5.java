package onboarding;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = get_answer(money);

        return answer;
    }

    public static List<Integer> get_answer( int money){

        List<Integer> answer = new LinkedList<Integer>();
        int temp = 0;

        //50000
        temp = div_money(answer, money, 50000);
        //10000
        temp = div_money(answer, temp, 10000);
        //5000
        temp = div_money(answer, temp, 5000);
        //1000
        temp = div_money(answer, temp, 1000);
        //500
        temp = div_money(answer, temp, 500);
        //100
        temp = div_money(answer, temp, 100);
        //50
        temp = div_money(answer, temp, 50);
        //10
        temp = div_money(answer, temp, 10);
        //1
        temp = div_money(answer, temp, 1);

        return answer;
    }

    private static int div_money(List<Integer> answer, int temp, int toDiv) {
        answer.add(temp/toDiv);
        temp = temp%toDiv;
        return temp;
    }
}
