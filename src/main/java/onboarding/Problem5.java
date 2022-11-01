package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        ArrayList<Integer> result = new ArrayList<>(money);

        /* 금액 별 변수 생성 */
        int m0=(money/50000);//오만원권
        int m1=(money%50000)/10000;//만원권
        int m2=(money%10000)/5000;//오천원권
        int m3=(money%5000)/1000;//천원권
        int m4=(money%1000)/500;//오백원권
        int m5=(money%500)/100;//백원권
        int m6=(money%100)/50;//오십원권
        int m7=(money%50)/10;//십원권
        int m8=money%10;//일원권

        /* 금액 별 변수 저장 */
        result.add(0, m0);
        result.add(1, m1);
        result.add(2, m2);
        result.add(3, m3);
        result.add(4, m4);
        result.add(5, m5);
        result.add(6, m6);
        result.add(7, m7);
        result.add(8, m8);

        answer = result;
        return answer;
    }
}
