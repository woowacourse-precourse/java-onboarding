package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int rest = 0;

        for (int i=1; i<=number; i++) {
            while (i > 0) {
                rest = i % 10;
                if (rest == 3 || rest == 6 || rest == 9) {
                    answer += 1;
                }
                i = i / 10;
            }
        }

        return answer;
    }
}
