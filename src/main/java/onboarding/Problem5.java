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
        answer = setFiveUnits(answer);
        answer = setEmpty(answer);
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

    static List<Integer> setFiveUnits(List<Integer> oneUnits) {
        for(int i=0; i<oneUnits.size()-1; i=i+2){
            oneUnits.add(i,oneUnits.get(i)/5);
            oneUnits.set(i+1,oneUnits.get(i+1)%5);
        }
        return oneUnits;
    }

    static List<Integer> setEmpty (List<Integer> fiveUnits) {
        while(fiveUnits.size()<9){
            fiveUnits.add(0,0);
        }
        return fiveUnits;
    }
}
