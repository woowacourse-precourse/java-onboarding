package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Problem5 {
    private static LinkedHashMap<Integer, Integer> moneyIdx;
    private static List<Integer> answer;
    private static int currentMoney;


    public static void setMap()
    {
        moneyIdx = new LinkedHashMap<>();
        moneyIdx.put(50000, 0);
        moneyIdx.put(10000,1);
        moneyIdx.put(5000,2);
        moneyIdx.put(1000,3);
        moneyIdx.put(500,4);
        moneyIdx.put(100,5);
        moneyIdx.put(50,6);
        moneyIdx.put(10,7);
        moneyIdx.put(1,8);
    }
    // money 나눠가며 카운트 증가시킨다.
    public static void  ChangeNum (int divisor)
    {
        if (currentMoney-divisor>=0)
        {
            int count = currentMoney/divisor;
            answer.set(moneyIdx.get(divisor),count);
            currentMoney-= count* divisor;
        }
    }

    public static List<Integer> solution(int money)
    {
        setMap();
        currentMoney = money;
        answer = new ArrayList<>();
        for (int i = 0 ; i < 9 ; i++)
            answer.add(0);
        for ( Integer key : moneyIdx.keySet())
            ChangeNum(key);
        return answer;
    }
}
