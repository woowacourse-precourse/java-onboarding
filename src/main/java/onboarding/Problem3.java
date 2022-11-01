package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number; i++) {
            sb.append(i + 1);
        }
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '3' || sb.charAt(i) == '6' || sb.charAt(i) == '9') {
                answer += 1;
            }
        }
        return answer;
    }

}
