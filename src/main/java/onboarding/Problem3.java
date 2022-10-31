package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countClap(number);
    }

    private static int countClap(int number) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            String num = String.valueOf(i);
            for(int j = 0; j < num.length(); j++) {
                int charsNumericValue = num.charAt(j)-'0';
                if((charsNumericValue) % 3 == 0 && (charsNumericValue != 0)) {
                    answer++;
                }
            }
        }
        return answer;
    }
}