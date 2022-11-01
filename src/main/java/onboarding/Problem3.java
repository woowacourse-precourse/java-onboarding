package onboarding;

public class Problem3 {
    private static int check369 (int number) {
        int tmp = 0;
        while (number > 0) {
            int mod = number % 10;
            if (mod == 3 || mod == 6 || mod == 9)
                tmp++;
            number /= 10;
        }
        return tmp;
    }
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += check369(i);
        }
        return answer;
    }
}
