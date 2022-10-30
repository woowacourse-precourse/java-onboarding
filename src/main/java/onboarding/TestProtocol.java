package onboarding;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class TestProtocol {

    public static void main(String[] args){
        List<Integer> answer = Collections.emptyList();
        int money = 50237;
        List<Integer> list = new ArrayList<>();
            list.add(0, money/50000);
            money = money%50000;
            list.add(1,money/10000);
            money = money%10000;
            list.add(2,money/5000);
            money = money%5000;
            list.add(3,money/1000);
            money = money%1000;
            list.add(4,money/500);
            money = money%500;
            list.add(5,money/100);
            money = money%100;
            list.add(6,money/50);
            money = money%50;
            list.add(7,money/10);
            money = money%10;
            list.add(8,money);

    }
}
