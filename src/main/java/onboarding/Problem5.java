package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }

    //돈을 환급할 화폐 리스트
    private final int[] currencyList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

    /**
     * 주어진 금액을 큰 단위의 화폐부터 담아 출금
     * @param money 출금을 하고자 하는 액수
     * @return 단위가 큰 화폐 순서대로 개수가 담긴 리스트
     */
    private List<Integer> getWithDrawList(int money){
        // 결과로 반환할 리스트를 초기화
        List<Integer> result = new ArrayList<>();
        // 화폐로 바꾸고 남은 돈을 저장할 변수를 초기화
        int remain = money;

        //큰 화폐부터 최대 개수를 리스트에 저장
        for (int currency : currencyList){
            int currencyCount = remain / currency;
            result.add(currencyCount);
            //남은 돈 계산
            remain -= currency * currencyCount;
        }

        return result;
    }
}
