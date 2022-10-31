package onboarding;

public class Problem3 {
    public static boolean isClap(int number) {
        if (number == 3 || number == 6 || number == 9) return true;
        else return false;
    }
    public static int clapPerNumber(int number) {
        int count = 0;
        while (number != 0) {
            if (isClap(number % 10)) count++;
            number /= 10;
        }

        return count;
    }
    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i<=number; i++) {
            answer += clapPerNumber(i);
        }
        return answer;
    }
}
