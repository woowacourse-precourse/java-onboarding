package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number + 1; i ++) {
            String numString = Integer.toString(i);
            for (int j = 0; j < numString.length(); j++) {
                char numChar = numString.charAt(j);
                if (numChar == '3' || numChar == '6' || numChar == '9') {
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
