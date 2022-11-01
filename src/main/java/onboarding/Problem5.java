package onboarding;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

public class Problem5 {
    private static LinkedHashMap<Integer, Integer> map;
    private static List<Integer> answer;
    private static int currentMoney;

    public static void setMap()
    {
        map = new LinkedHashMap<>();
        map.put(50000, 0);
        map.put(10000,1);
        map.put(5000,2);
        map.put(1000,3);
        map.put(500,4);
        map.put(100,5);
        map.put(50,6);
        map.put(10,7);
        map.put(1,8);
    }
    public static void  ChangeNum (int divisor)
    {
        if (currentMoney-divisor>=0)
        {
            int count = currentMoney/divisor;
            answer.set(map.get(divisor),count);
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
        for ( Integer key : map.keySet())
            ChangeNum(key);
        return answer;
    }

    /*
    public static void main(String[] args) {
        List<Integer> result = List.of(0, 1, 1, 0, 0, 0, 0, 0, 0);
        List<Integer> result2=  solution(15_000);
        System.out.println(result);
        System.out.println(result2);
        assertThat(result2).isEqualTo(result);
    }*/
}
