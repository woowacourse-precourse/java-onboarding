package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
자릿수 추출하기
원래의 수를 10으로 나눈 나머지
나눠야 할 수가 10 미만이면 그만둔다
 */
/*
answer = 0
1. 1부터 number까지 for문을 돌면서 자릿수 추출한다.
2. 추출한 자릿수가 3, 6, 9 중 하나이면 answer + 1
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int n = 0;
        for (int num = 1; num <= number; num++) {
            n = num;
            while (true) {
                if (n % 10 == 3 || n % 10 == 6 || n % 10 == 9)
                    answer += 1;
                if (n < 10)
                    break;
                n = n / 10;
            }
        }
        return answer;
    }
}
