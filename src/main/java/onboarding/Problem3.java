package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 1. 1~number까지 반복문을 돌기
        for (int i = 1; i <= number; i++) {
            // 2. 임시 숫자 temp에 3이 몇 개 포함되는지 세기
            int tmp = i;
            while(tmp > 0) {
                int tmp2 = tmp % 10;
                if(tmp2 != 0 && (tmp2 % 3) == 0) {
                    answer++;
                }
                tmp /= 10;
            }
        }

        return answer;
    }
}
