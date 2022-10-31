package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer = clap(answer, i);
        }
        return answer;
    }

    private static int clap(int answer, int i) {
        String value = String.valueOf(i);
        for (String s : value.split("")) {
            if (checkThreeSixNine(s)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean checkThreeSixNine(String str) {
        return str.equals("3") || str.equals("6") || str.equals("9");
    }
}
