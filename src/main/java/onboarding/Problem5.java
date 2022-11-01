package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<Integer>();
        int count = 0;

        if (money / 50000 != 0) {
            count += money / 50000;
            answer.add(count);
            money = money % 50000;
        }
        else
            answer.add(count);
        count = 0;
        if (money / 10000 != 0){
            count += money / 10000;
            answer.add(count);
            money = money % 10000;
        }
        else
            answer.add(count);
        count = 0;
        if (money / 5000 != 0){
            count += money / 5000;
            answer.add(count);
            money = money % 5000;
        }
        else
            answer.add(count);
        count = 0;
        if (money / 1000 != 0){
            count += money / 1000;
            answer.add(count);
            money = money % 1000;
        }
        else
            answer.add(count);
        count = 0;
        if (money / 500 != 0){
            count += money / 500;
            answer.add(count);
            money = money % 500;
        }
        else
            answer.add(count);
        count = 0;
        if (money / 100 != 0){
            count += money / 100;
            answer.add(count);
            money = money % 100;
        }
        else
            answer.add(count);
        count = 0;
        if (money / 50 != 0){
            count += money / 50;
            answer.add(count);
            money = money % 50;
        }
        else
            answer.add(count);
        count = 0;
        if (money / 10 != 0) {
            count += money / 10;
            answer.add(count);
            money = money % 10;
        }
        else
            answer.add(count);
        if (money != 0) {
            answer.add(money);
        }
        else
            answer.add(count);
        return answer;
    }
    public static void main(String[] args) {
        int money = 50237;
        List<Integer> answer = solution(money);

        System.out.println(answer);
    }
}
