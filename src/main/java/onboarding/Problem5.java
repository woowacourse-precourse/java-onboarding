package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//돈의 단위에따라 나누어 돈의 장수 구하는메소드
//나머지 거스름돈으로 초기화
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        List<Integer> result = new ArrayList<>();
        result.add(CountJang(50000, money));
        money=CurrentMoney(50000, money);
        result.add(CountJang(10000, money));
        money=CurrentMoney(10000, money);
        result.add(CountJang(5000, money));
        money=CurrentMoney(5000, money);
        result.add(CountJang(1000, money));
        money=CurrentMoney(1000, money);
        result.add(CountJang(500, money));
        money=CurrentMoney(500, money);
        result.add(CountJang(100, money));
        money=CurrentMoney(100, money);
        result.add(CountJang(50, money));
        money=CurrentMoney(50, money);
        result.add(CountJang(10, money));
        money=CurrentMoney(10, money);
        result.add(CountJang(1, money));
        money=CurrentMoney(1, money);
        return result;
    }
    public static int CountJang(int unit,int money){
        int jang;
        jang=money/unit;
        return jang;
    }
    public static int CurrentMoney(int unit,int money){
        int currentmoney=money%unit;
        return currentmoney;
    }
}
