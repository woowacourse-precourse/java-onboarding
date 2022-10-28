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
        String str = String.valueOf(number);

        ret += countNumberByStr(str, '3');
        ret += countNumberByStr(str, '6');
        ret += countNumberByStr(str, '9');
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
