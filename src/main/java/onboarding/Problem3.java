package onboarding;

import java.util.ArrayList;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        ArrayList<Integer> full = new ArrayList<Integer>();

        // 숫자를 한 자리씩 떼어다가 리스트에 추가
        for (int i = 1; i <= number; i++) {
            int num = i;
            while (num > 0) {
                full.add(num % 10);
                num /= 10;
            }
        }

        // 3, 6, 9의 갯수를 센다
        for (int i = 0; i < full.size(); i++) {
            if (full.get(i) == 3 || full.get(i) == 6 || full.get(i) == 9) {
                answer++;
            }
        }

        return answer;
    }
}
