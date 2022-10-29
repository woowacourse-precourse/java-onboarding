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
/*      int[] save_arr = new int[10001];
        int count = 0;
        for (int num = 1; num <= number; num++) {
            while (num != 0) {
                if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9) {
                    count += 1;
                }
                num /= 10;

            }
            save_arr[num] = count;
        }
        return save_arr[number-1];
*/
        int count = 0;
        for (int i = 1; i <= number; i++) {
            int current_number = i;
            while (current_number != 0) {
                if (current_number % 10 == 3 || current_number % 10 == 6 || current_number % 10 == 9) {
                    count++;
                }
                current_number /= 10;
            }
        }
        return count;
    }
}

