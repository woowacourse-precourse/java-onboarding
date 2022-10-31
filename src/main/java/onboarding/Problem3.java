package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String str = String.valueOf(i);
            if (is369Contained(str)) answer += count369(str);
        }

        return answer;
    }

    public static boolean is369Contained(String str) {
        return str.contains("3") || str.contains("6") || str.contains("9");
    }

    public static int count369(String str) {
        int cnt = 0;

        for (char c : str.toCharArray()) {
            if (c == '3' || c == '6' || c == '9') cnt++;
        }

        return cnt;
    }
}
