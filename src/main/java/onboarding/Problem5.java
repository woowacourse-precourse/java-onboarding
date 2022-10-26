package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem5 {
    //단위 배열
    private static int[] units = {50000,10000,5000,1000,500,100,50,10,1};

    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        return answer;
    }

    //해당 단위로 최대 받을수 있는 크기 구하는 함수
    private static int getCount(int money, int idx){
        return money / units[idx];
    }
}
