package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        ArrayList<Integer> arr = new ArrayList<>();
        int a = money / 50000;
        int b = (money % 50000) / 10000;
        int c = (money % 10000) / 5000;
        int d = (money % 5000) / 1000;
        int e = (money % 1000) / 500;
        int f = (money % 500) / 100;
        int g = (money % 100) / 50;
        int h = (money % 50) / 10;
        int i = money % 10;

        arr.add(a);
        arr.add(b);
        arr.add(c);
        arr.add(d);
        arr.add(e);
        arr.add(f);
        arr.add(g);
        arr.add(h);
        arr.add(i);

        answer = arr;

        return answer;
    }
}
