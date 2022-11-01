package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; ++i) {
            answer += count369(i);
        }

        return answer;
    }

    private static int count369(int number) {
        int ret = 0;
        char rules[] = {'3', '6', '9'};
        String str = String.valueOf(number);

        for (char rule : rules) {
            ret += countNumberByStr(str, rule);
        }
        return ret;
    }

    private static int countNumberByStr(String str, char c) {
        int ret = 0;

        for (int i = 0; i < str.length(); ++i) {
            if (c == str.charAt(i)) {
                ++ret;
            }
        }
        return ret;
    }
}
