package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = number / 3;
        if (number > 10) {
            int[] cnt = new int[number + 1];
            cnt[3] = 1;
            cnt[6] = 1;
            cnt[9] = 1;
            answer = 3;
            for (int i = 10; i <= number; i++) {
                cnt[i] = cnt[i / 10] + ((i % 10) != 0 && (i % 10) % 3 == 0 ? 1 : 0);
                answer += cnt[i];
            }
        }
        return answer;
    }
}
