package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = looper(number);
        return answer;
    }


    public static int looper(int value) {
        int result = 0;
        for (int i = 0; i <= value; i++) {
            int valueToAdd = clapCount(i);
            result += valueToAdd;
        }
        return result;
    }

    public static int clapCount(int value) {

        if (value / 10 == 0) {
            return clap(value);
        }

        return clapCount(value / 10) + clap(value % 10);
    }
    public static int clap(int value) {
        if (value == 3 || value == 6 || value == 9) {
            return 1;
        } else {
            return 0;
        }
    }
}
