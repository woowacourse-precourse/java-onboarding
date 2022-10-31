package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        boolean game = validation(number);
        if (!game) {
            return 0;
        }

        for (int i = 0; i < number + 1; i++) {
            int ten_num = i / 10; // 십의 자리
            int one_num = i % 10; // 일의 자리

            // 십의 자리수 3,6,9 판별
            if (ten_num == 3 || ten_num == 6 || ten_num == 9) {
                answer += 1;
            }

            // 일의 자리수 3,6,9 판별
            if(one_num == 3 || one_num == 6 || one_num == 9) {
                answer += 1;
            }
        }
        return answer;
    }

    private static boolean validation(int num) {
        // 1미만, 10000 초과
        if(num < 1 || num > 10000) {
            return false;
        }
        return true;
    }
}
