package onboarding.problem3;

import static onboarding.problem3.Controller.getCount;

public class Repository {

    // 누적 기능 : 1~10000 범위내 자연수 number 순회
    public static int save(int number) {

        int count = 0;
        for (int i = 1; i <= number; i++) {
            number = i;
            // number는 1~10000 자연수
            if (number == 3 || number == 6 || number == 9) { count += 1; }
        }

        return count;

    }
}


