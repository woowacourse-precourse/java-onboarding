package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        while (number > 0) {
            int i = number;
            while (i > 0) {
                if ((i % 10 != 0) && (i % 10) % 3 == 0) {
                    answer++;
                }
                i /= 10;
            }
            number--;
        }
        return answer;
    }
}
