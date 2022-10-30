package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능목록
 * 1. 자리 단위의 리스트 생성
 * 2. 1의 리스트를 5자리 단위로 나눈 리스트로 변환
 * 3. 빈 자리를 0으로 채움
 * */
public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer = setOneUnits(money);
        return answer;
    }
    static List<Integer> setOneUnits(int money){
        List<Integer> oneUnits = new ArrayList<>();

        while (money>0){
            oneUnits.add(money%10);
            money/=10;
        }
        Collections.reverse(oneUnits);
        return oneUnits;
    }
}
