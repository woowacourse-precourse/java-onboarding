package onboarding;

import java.util.ArrayList;

public class Problem3 {
    /**
     문제:
     - 369를 해서 박수치는 횟수를 구해라

     해결 방법:
     - 1부터 입력값까지 순회합니다. ( 순회 = current )
     - current % 10 이 3,6,9 이면 answer 증가
     - current 를 10으로 나눠줌
        => 예를 들어, 31이 되는 경우 31/10 = 3이므로 카운트가 1증가됨
        => 이 원리를 이용해 30, 300, 3000 ... 의 자리수에 대해서 카운트 증가를 시킬 수 있음

     **/
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int current = i;
            while (current != 0) {
                if (current % 10 == 3 || current % 10 == 6 || current % 10 == 9) {
                    answer++;
                }
                current /= 10;
            }
        }
        return answer;
    }
}
