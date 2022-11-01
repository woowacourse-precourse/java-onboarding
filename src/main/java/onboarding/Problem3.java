package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int count= 1; count <= number; count++) {
            String targetNumber = Integer.toString(count);
            char[] eachDigit = targetNumber.toCharArray();

            for(char digit:eachDigit) {
                int value = Character.getNumericValue(digit);
                if (value != 0 && value % 3 == 0) {
                    answer += 1;
                }
            }

        }

        return answer;
    }
}
