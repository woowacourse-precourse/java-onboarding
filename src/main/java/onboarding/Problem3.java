/*----------------------------------------------------------------------------------------
 * Author: 조형준
 * Date: 2022/11/01
 * Objective:
 *   1. Math.log10을 이용해 주어진 숫자의 자릿수를 구함
 *   2. 3, 6, 9를 원소로 갖는 List의 contains 메서드를 활용하여 3, 6, 9의 존재 여부를 판별
 *   3. loop를 활용해 각 자릿수가 3, 6, 9에 해당하는 숫자인지 판별하고 이를 count
 *---------------------------------------------------------------------------------------*/
package onboarding;

import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        int cipher = (int)Math.log10(number) + 1;
        int digit;
        List<Integer> _369 = List.of(3, 6, 9);

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= cipher; j++) {
                digit = (i % (int)Math.pow(10, j)) / (int)Math.pow(10, j - 1);
                if (_369.contains(digit))
                    count++;
            }
        }
        int answer = count;
        return answer;
    }
}
