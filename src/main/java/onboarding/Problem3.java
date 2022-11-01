package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += find369Num(i);
        }
        return answer;
    }

    public static int find369Num(int num) {
        int ans = 0;
        while (num != 0) {
            int check369 = num % 10;
            if (check369 == 3 || check369 == 6 || check369 == 9)
                ans++;
            num /= 10;
        }
        return ans;
    }
}
