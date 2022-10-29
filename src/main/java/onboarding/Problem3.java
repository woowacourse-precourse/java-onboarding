package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
 * 좀만 더 생각해보기
 * 테스트 무시가 나온다 왜지
 *
*/
public class Problem3 {
    public static int solution(int number) {
/*        List<Integer> save_arr = new ArrayList<>(number);
        int count = 0;
        for (int num = 1; num <= number; num++) {
            while (num != 0) {
                if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                    count += 1;
                }
                num /= 10;
            }
            save_arr.add(count);
        }
       return save_arr.get(number);
 */
       int count = 0;
        for (int num = 1; num <= number; num++) {
            while (num != 0) {
                if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                    count++;
                }
                num /= 10;
            }
        }
        return count;
    }
}
