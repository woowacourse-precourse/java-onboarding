/*
 * 1, 각 돈에 대한 배열을 만든다.
 *  5만원 | 1만원군 | 오천원권 | 천원권 | 오백원| 백원 | 오십원 | 십원 | 일원
 *  9개
 * 2, 가장 큰값에 대한 값부터 뺀 후 카운팅한다.
 * 3, 출력한다.
 */
package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> moneyList = new ArrayList<>();
        moneyList.add(50000);
        moneyList.add(10000);
        moneyList.add(5000);
        moneyList.add(1000);
        moneyList.add(500);
        moneyList.add(100);
        moneyList.add(50);
        moneyList.add(10);
        moneyList.add(1);

        List<Integer>answer = new ArrayList<>();
        for(int i = 0; i <= moneyList.size();i++){
            int count = 0; // 지속적으로 0으로 초기화
            if(0 < money){
                count = money / moneyList.get(i); // 최대 몇번 나눌 수 있는지
                answer.add(count); // 나눈 값을 해당 인덱스에 저장
                money = money % moneyList.get(i); // 나눈 값의 나머지 값
            }
        }
        for(int i = 0; i < answer.size();i++){
            if(answer.size() != 9){
                answer.add(0);
            }
        }
        return answer;
    }
}
