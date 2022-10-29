package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    /**
     * 거스름돈을 반환
     * @param money : 1~1,000,000 사이의 정수
     * @return 5원을 제외한 화폐, 동전의 수 배열
     */
    public static List<Integer> solution(int money) {
        List<Integer> answer = new ArrayList<>();
        final int[] moneyArr = {50000,10000,5000,1000,500,100,50,10,1};

        for(int i=0;i<moneyArr.length;i++){
            int count = money / moneyArr[i];
            answer.add(i, count);
            money %= moneyArr[i];
        }

        return answer;
    }
}
