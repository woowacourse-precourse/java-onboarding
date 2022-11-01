package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    public static int countClap(int i) {
        int count = 0;

        while (i > 0) {
            int mod = i % 10;
            if (mod == 3 || mod == 6 || mod == 9) {
                count++;
            }
            i = i / 10;
        }

        return count;
    }
}
