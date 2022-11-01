package onboarding;

import java.util.stream.Stream;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int now = i;

            // 현재 수가 0이 아닐때까지 while문을 반복해준다
            // while 문 안에서는 일의 자리 수가 3, 6, 9 중 하나인지 확인하고,
            // 그다음 10의 자리수가 3, 6, 9 중 하나인지 확인하기 위해 10으로 나눠준다.

            // ex) now = 36 이라면 박수를 두번쳐야 하기 때문에
            // 우선 10으로 나눈 나머지(일의자리)인 '6'을 처리할 때 박수 1번
            // 36을 10으로 나눠, now 10의자리인 '3'으로 만들어주고,
            // 다시 한번 while문을 돌아 박수를 1번 추가 할 수 있도록 해준다.

            while (now != 0) {
                if (now % 10 == 3 || now % 10 == 6 || now % 10 == 9){
                    answer++;
                }
                now /= 10;
            }
        }

        return answer;
    }
}
