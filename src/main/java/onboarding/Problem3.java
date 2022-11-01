package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            char[] numberToCharList = String.valueOf(i).toCharArray();
            for (char c : numberToCharList) {
                if (c == '3' || c == '6' || c == '9') {
                    answer++;
                }
            }
        }
        return answer;
    }

}
