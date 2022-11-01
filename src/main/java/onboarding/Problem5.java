package onboarding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Problem5 {
    // 가장 큰 단위의 화폐부터 가장 작은 단위의 화폐까지 차례대로 확인하여 거슬러 주는 작업만을 수행하면 된다
    public static List<Integer> solution(int money) {

        int[] answer = new int[9];

        int[] pocketMoney = new int[]{50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int i = 0; i < pocketMoney.length; i++) {
           if(i == 0) { answer[i] = money / pocketMoney[i];
        }else {
               answer[i] = (money % pocketMoney[i-1] / pocketMoney[i]);
           }
        }

        // 기능요구사항인 리스트/배열에 맞춰준다. 배열 -> 리스트
        // boxed() int자체로는 Collection에 못 담기 때문에 Integer클래스로 변환하여 List<Integer>로 담기위헤
        List<Integer> result = Arrays.stream(answer).boxed().collect(Collectors.toList());
        return result;
     }
}
