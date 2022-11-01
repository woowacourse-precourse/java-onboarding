package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    /*
    * 지폐 단위를 배열로 담아서 큰 단위부터 나눠가며 몫을 리스트에 추가한다.
    * parameter : int (돈의 액수 money)
    * return : List<Integer> (변환된 각 지폐단위의 갯수)
    * */
    public static List<Integer> solution(int money) {
        // 각 지폐의 갯수를 담을 ArrayList 생성
        List<Integer> answer = new ArrayList<>();
        // 지폐 단위 배열을 생성
        Integer[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};

        for (int a : moneyArr) {
            answer.add(money / a); // 몫을 answer 에 추가
            money %= a; // 몫을 제외한 나머지를 money 에 넣는다.
        }

        return answer;
    }
}
