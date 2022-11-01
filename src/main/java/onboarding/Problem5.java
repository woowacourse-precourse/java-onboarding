package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem5 {
    public static List<Integer> solution(int money) {

        List<Integer> answer = new ArrayList<Integer>();

        int own_money = money;

        int fm = own_money / 50_000;
        answer.add(fm);
        own_money = own_money % 50_000;

        int m = own_money / 10_000;
        answer.add(m);
        own_money = own_money % 10_000;

        int ft = own_money / 5_000;
        answer.add(ft);
        own_money = own_money % 5_000;

        int t = own_money / 1_000;
        answer.add(t);
        own_money = own_money % 1_000;

        int fh = own_money / 500;
        answer.add(fh);
        own_money = own_money % 500;

        int h = own_money / 100;
        answer.add(h);
        own_money = own_money % 100;

        int fi = own_money / 50;
        answer.add(fi);
        own_money = own_money % 50;

        int ten = own_money / 10;
        answer.add(ten);
        own_money = own_money % 10;

        answer.add(own_money);

        //List<Integer> answer = Arrays.stream(array).boxed().collect(Collectors.toList());




        return answer;
    }
}
