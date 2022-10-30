package onboarding;

public class Problem3 {
    public static int solution(int number) {
        if (outOfRange(number)) return -1;

        return play369Game(number);
    }

    private static int play369Game(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += get369Count(i);
        }

        return answer;
    }

    private static int get369Count(int num) {
        int answer = 0;
        while (num > 0) {
            if (is369(num % 10)) {
                answer++;
            }

            num /= 10;
        }
        return answer;
    }

    private static boolean is369(int n) {
        return n == 3 || n == 6 || n == 9;
    }

    static boolean outOfRange(int number) {
        return number < 1 || number > 10000;
    }
}
