package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int cnt = i;
            while (cnt != 0) {
                if (cnt % 10 == 3 || cnt % 10 == 6 || cnt % 10 == 9){
                    answer++;
                }
                cnt /= 10;
            }
        }
        return answer;
    }
}
