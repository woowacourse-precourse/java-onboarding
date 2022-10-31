package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= number; i++) {
            sb.append(i);
        }

        String clap = sb.toString().replaceAll("[^369]", "");

        return answer;
    }
}
