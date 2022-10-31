package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> list = new ArrayList<>();
        int[] coin = { 50000, 10000, 5000, 1000, 500, 100 , 50, 10, 1};
        for(int i=0; i<coin.length; i++){
            list.add(i, money/coin[i]);
            money %= coin[i];
        }
        return list;
    }
}

/*
[ 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 ]
 */
