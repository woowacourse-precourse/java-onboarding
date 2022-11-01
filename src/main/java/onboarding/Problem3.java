package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

    for (int i = 0; i <= number; i++) {

        int current = i;
        while (current != 0) {
            if ((current / 3) == 0) {
                answer++;
                current /= 10;
            }
        }
    }
        return answer;
    }
}
