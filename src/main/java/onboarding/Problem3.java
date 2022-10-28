package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int count = 0;
        for (int i = 1; i <= number; i++) {

            String n = String.valueOf(i);

            for (int j = 0; j < n.length(); j++) {
                if (n.charAt(j) == '3' || n.charAt(j) == '6' || n.charAt(j) == '9') {
                    count += 1;
                }

            }
        }

        answer = count;

        return answer;
    }
}
