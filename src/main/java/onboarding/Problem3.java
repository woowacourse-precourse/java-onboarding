package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            int x = i;
            while (x != 0) {
                int f = x % 10;
                if (f % 3 == 0) {
                    if (checkThree(f)) {
                        answer++;
                    }
                }
                x /= 10;
            }
        }
        return answer;
    }

    static boolean checkThree(int a) {
        return a / 3 == 1 || a / 3 == 2 || a / 3 == 3;
    }
}
