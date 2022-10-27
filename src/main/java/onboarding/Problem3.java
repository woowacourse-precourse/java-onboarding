package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += getClaps(i);
        }

        return answer;
    }

    private static int getClaps(int x) {
        String str = String.valueOf(x);
        String fix = str.replace("3", "")
                .replace("6", "")
                .replace("9", "");

        return str.length() - fix.length();
    }

}
