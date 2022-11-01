package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int rest = 0;

        for (int i=1; i<=number; i++) {
            int j = i;
            while (j > 0) {
                rest = j % 10;
                if (rest == 3 || rest == 6 || rest == 9) {
                    answer += 1;
                }
                j = j / 10;
            }
        }

        return answer;
    }
}
