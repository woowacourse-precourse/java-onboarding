package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++){
            String numToStr = String.valueOf(i);
            char[] numToChars = numToStr.toCharArray();
            for (char numChar:numToChars) {
                String numCharToStr = String.valueOf(numChar);
                if (numCharToStr.contains("3") || numCharToStr.contains("6") || numCharToStr.contains("9") ) answer++;
            }
        }
        return answer;
    }
}
