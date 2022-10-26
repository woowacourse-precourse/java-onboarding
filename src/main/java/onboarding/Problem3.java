package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int save = 0;
        // 각 자리수 별로 잘라서 3, 6, 9가 있으면 박수.
        for (int i = 1; i <= number; i++) {
            save = i;
            while (i > 0) {
                if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
                    answer++;
                }
                i /= 10;
            }
            i = save;
        }

        return answer;
    }
}
