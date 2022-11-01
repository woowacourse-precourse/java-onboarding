package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/*
1. 돈의 액수 초기화 설정
2. money 최소 최대값 기능
 */
public class Problem5 {
    public static int[] initCoin(){
        return new int[]{50000,10000,5000,1000,500,100,50,10,1};
    }
    public static boolean ckCoin(int money){
        return money <= 1000000 && 1 <= money;
    }
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;

    }
}
