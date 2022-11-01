/*----------------------------------------------------------------------------------------
 * Author: 조형준
 * Date: 2022/11/01
 * Objective:
 *   1. 각각의 권종 액면가를 원소로 갖는 List 선언
 *   2. 각 권종의 개수를 갖게 될 List 선언
 *   3. 전달받은 money 값에서 각 권종의 Remainder를 구해나감
 *---------------------------------------------------------------------------------------*/
package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> bill = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);
        List<Integer> bill_type = new ArrayList<>();

        for(int e: bill){
            bill_type.add(money/e);
            money %= e;
        }

        List<Integer> answer = bill_type;
        return answer;
    }
}
