package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    //지폐 수 계산
    public static List<Integer> returnNumberOfBills(int money){
        List<Integer> koreanWonList = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1); //한화 단위 리스트
        List<Integer> result = new ArrayList<Integer>();

        for(Integer won : koreanWonList) {
            result.add(money / won);
            money %= won;
        }
        return result;
    }

    //솔루션 메소드
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = returnNumberOfBills(money); //지폐 수 계산
        return answer;
    }
}
