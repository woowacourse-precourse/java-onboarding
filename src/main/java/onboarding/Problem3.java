package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number + 1; i++) {
            int staNum = i;
            while (staNum > 0) {
                int disNum = staNum % 10;
                if (disNum == 3 || disNum == 6 || disNum == 9) {
                    answer++;
                }
                staNum /= 10;
            }
        }
        return answer;
    }
}
