package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {

            //자릿수로 분해하기
            ArrayList<Integer> arrNumber = new ArrayList<>();
            int num=i;
            while (num > 0) {
                arrNumber.add(num % 10);
                num /= 10;
            }

            //3, 6, 9가 있는 개수만큼 값 더하기
            for (Integer arrNum : arrNumber) {
                if (arrNum == 3 || arrNum == 6 || arrNum == 9)
                    answer++;
            }
        }
        return answer;
    }
}
