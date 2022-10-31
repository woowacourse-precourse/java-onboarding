package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        greedy_solve(money, answer);
        return answer;
    }

    static void greedy_solve(int money, List<Integer> answer)
    {
        int tmp_money = money;
        tmp_money = count_50000(tmp_money, answer);
        tmp_money = count_10000(tmp_money, answer);
        tmp_money = count_5000(tmp_money, answer);
        tmp_money = count_1000(tmp_money, answer);
        tmp_money = count_500(tmp_money, answer);
        tmp_money = count_100(tmp_money, answer);
        tmp_money = count_50(tmp_money, answer);
        tmp_money = count_10(tmp_money, answer);
        count_1(tmp_money, answer);
    }

    static int count_50000(int money, List<Integer> answer)
    {
        answer.add(money/50000);
        return money%50000;
    }
    static int count_10000(int money, List<Integer> answer)
    {
        answer.add(money/10000);
        return money%10000;
    }
    static int count_5000(int money, List<Integer> answer)
    {
        answer.add(money/5000);
        return money%5000;
    }
    static int count_1000(int money, List<Integer> answer)
    {
        answer.add(money/1000);
        return money%1000;
    }
    static int count_500(int money, List<Integer> answer)
    {
        answer.add(money/500);
        return money%500;
    }
    static int count_100(int money, List<Integer> answer)
    {
        answer.add(money/100);
        return money%100;
    }
    static int count_50(int money, List<Integer> answer)
    {
        answer.add(money/50);
        return money%50;
    }
    static int count_10(int money, List<Integer> answer)
    {
        answer.add(money/10);
        return money%10;
    }
    static int count_1(int money, List<Integer> answer)
    {
        answer.add(money/1);
        return money%1;
    }
}
