package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
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
