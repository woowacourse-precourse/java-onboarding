package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // dp로 풀 수도 있지 않을까?
        for (int i = 3; i <= number; i++) {
            String num = String.valueOf(i);
            for (int j = 0; j < num.length(); j++) {
                if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }
}
