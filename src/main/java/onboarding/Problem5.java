package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = cal(money);
        return answer;
    }

    //  1. hashmap으로 9개 금액 별로 나누는 매서드(큰 값이 키값 1부터 시작)\
    public static Integer moneyValue(int moneyKey) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        dict.put(0, 50000);
        dict.put(1, 10000);
        dict.put(2, 5000);
        dict.put(3, 1000);
        dict.put(4, 500);
        dict.put(5, 100);
        dict.put(6, 50);
        dict.put(7, 10);
        dict.put(8, 1);
        return dict.get(moneyKey);
    }
//  2. for문으로 가장 큰 값부터 나누고 나눈값 같은 index자리 result에 추가 나머지 갱신
public static List<Integer> cal(int money) {
    int moneyMod = money;
    List<Integer> result = new ArrayList<>(9);
    for (int i = 0; i < 9; i++) {
        int quotient = moneyMod / moneyValue(i);
        result.add(i,quotient);
        moneyMod = money % moneyValue(i);

    }
    return result;
}
}
